package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.model.Mail;
import com.ks.db.model.SysMail;
import com.ks.db.model.User;
import com.ks.db.model.UserRecord;
import com.ks.exceptions.GameException;
import com.ks.logic.event.MailEvent;
import com.ks.logic.event.SendSysMailEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.MailService;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.mail.MailVO;
import com.ks.table.UserRecordTable;
import com.ks.timer.TimerController;

public class MailServiceImpl extends BaseService implements MailService {
	/********************************************************* 数据处理 ********************************************************************/
	/**
	 * 更新邮件
	 */
	private void updateMailData(Mail mail){
		mailDAO.updateMail(mail);
		mailDAO.updateMailCache(mail);
	}
	/**
	 * 删除邮件
	 */
	private void deleteMailData(int userId, int mailId){
		User user = userService.queryCacheUser(userId);
		if(user != null){
			Map<Integer, Mail> map = user.getMails();
			if(map != null){
				map.remove(mailId);
			}
		}
		mailDAO.deleteMail(user.getUserId(), mailId);
		mailDAO.delMailCache(user.getUserId(), mailId);
	}
	/**
	 * 添加邮件
	 */
	private void addMailData(int userId, Mail mail){
		User user = userService.queryCacheUser(userId);
		if(user != null){
			Map<Integer, Mail> map = user.getMails();
			if(map != null){
				map.put(mail.getMailId(), mail);
			}
		}
		mailDAO.addMail(mail);
		mailDAO.addMailCache(mail);
	}
	/**
	 * 加载邮件
	 * @param user
	 * @return
	 */
	private Map<Integer, Mail> loadMailMap(User user){
		Map<Integer, Mail> map = user.getMails();
		if(map == null){
			map = loadMailMap(user.getUserId());
			user.setMails(map);
		}
		return map;
	}
	/**
	 * 加载邮件
	 * @param userId
	 * @return
	 */
	private Map<Integer, Mail> loadMailMap(int userId){
		Map<Integer, Mail> map = mailDAO.queryMailsCache(userId);
		if(map == null){
			List<Mail> mails = mailDAO.queryMails(userId);
			map = new HashMap<Integer, Mail>();
			for(Mail mail : mails){
				map.put(mail.getMailId(), mail);
			}
			mailDAO.setMailsCache(userId, map);
		}
		return map;
	}
	private Collection<Mail> getMails(User user){
		return loadMailMap(user).values();
	}
	private Mail getMail(User user, int mailId){
		Mail mail = loadMailMap(user).get(mailId);
		if(mail == null){
			throw new GameException(GameException.CODE_邮件不存在, "");
		}
		return mail;
	}
	public void initMails(int userId){
		mailDAO.clearMailsCache(userId);
	}
	
	/************************************************************ 邮件逻辑***********************************************************************/
	@Override
	public List<MailVO> queryMail(int userId) {
		checkSendSysMail(userId);
		User user = userService.getOnlineUser(userId);
		Collection<Mail> mails = getMails(user);
		List<MailVO> vos = new ArrayList<MailVO>();
		Iterator<Mail> it = mails.iterator();
		while(it.hasNext()){
			Mail mail = it.next();
			boolean delete = false;
			long time = System.currentTimeMillis() - mail.getCreateTime().getTime();
			if(mail.getState() == SystemConstant.MAIL_STATE_READ){
				if(mail.getGoodses() == null || mail.getGoodses().length() == 0 || mail.getGoodsList().isEmpty()){
					delete = time >= 3*24*60*60*1000l;
				}else{
					delete = time >= 7*24*60*60*1000l;
				}
			}else{
				delete = time >= 30*24*60*60*1000l;
			}
			if(delete){
				it.remove();
				deleteMailData(userId, mail.getMailId());
			}else{
				MailVO vo = MessageFactory.getMessage(MailVO.class);
				vo.init(mail);
				vos.add(vo);
			}
		}
		return vos;
	}
	
	@Override
	public void viewMail(int userId, int mailId) {
		User user = userService.getOnlineUser(userId);
		Mail mail = getMail(user, mailId);
		mail.setState(SystemConstant.MAIL_STATE_READ);
		updateMailData(mail);
	}

	@Override
	public GainAwardVO collectAdjunct(int userId, int mailId) {
		User user = userService.getOnlineUser(userId);
		Mail mail = getMail(user, mailId);
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_邮件获得);
		effects.appendGoods(mail.getGoodsList(), 0);
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		GainAwardVO awards = effectService.addGainAwardVo(user, effects);
		mail.getGoodsList().clear();
		deleteMailData(userId, mailId);
		return awards;
	}
	
	@Override
	public void sendMail(int userId, Mail mail, boolean notice) {
		addMailData(userId, mail);
		if(notice){
			MailEvent event = new MailEvent(mail.getUserId(),mail);
			TimerController.submitGameEvent(event);
		}
	}
	
	@Override
	public void deleteMail(int userId, int mailId) {
		deleteMailData(userId, mailId);
	}
	
	/************************************************系统邮件*********************************************************/
	
	@Override
	public void addSysMail(SysMail sysMail){
		sysMailDao.addSysMail(sysMail);
		sysMailDao.addSysMailCache(sysMail);
		TimerController.submitGameEvent(new SendSysMailEvent(sysMail));
	}
	
	@Override
	public void deleteSysMail(int id){
		sysMailDao.deleteSysMail(id);
		sysMailDao.delSysMailCache(id);
	}
	
	/**
	 * 校验发送系统邮件
	 */
	private void checkSendSysMail(int userId){
		User user = userService.getUser(userId);
		Map<Integer, SysMail> map = sysMailDao.querySysMailsCache();
		if(map != null){
			boolean update = false;
			UserRecord record = userDAO.getUserRecord(user.getUserId());
			for(SysMail sysMail : map.values()){
				if(sysMail.getPartner() == user.getPartner()){
					if(!record.isReceiveSysMail(sysMail.getId()) && sysMail.isGain(user.getUserId())){
						Mail mail = Mail.createMail(user.getUserId(), SystemConstant.MAIL_TYPE_系统邮件, sysMail.getTitle(), sysMail.getContent(), sysMail.getGoods());
						mailService.sendMail(userId, mail, false);
						record.addReceiveSysMail(sysMail.getId());
						update = true;
					}
				}
			}
			List<Integer> ids = record.getSysMailList();
			if(!ids.isEmpty()){
				Iterator<Integer> it = ids.iterator();
				while(it.hasNext()){
					int id = it.next();
					if(!map.containsKey(id)){
						it.remove();
						update = true;
					}
				}
			}
			if(update){
				record.initSysMailIds();
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(UserRecordTable.SYSMAILIDS, SQLOpt.EQUAL);
				userDAO.updateUserRecord(record, opt);
			}
		}
	}
	
	@Override
	public void sendSysMail(User user, SysMail sysMail){
		UserRecord record = userDAO.getUserRecord(user.getUserId());
		if(!record.isReceiveSysMail(sysMail.getId()) && sysMail.isGain(user.getUserId())){
			Mail mail = Mail.createMail(user.getUserId(), SystemConstant.MAIL_TYPE_系统邮件, sysMail.getTitle(), sysMail.getContent(), sysMail.getGoods());
			sendMail(user.getUserId(), mail, true);
			record.addReceiveSysMail(sysMail.getId());
			record.initSysMailIds();
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserRecordTable.SYSMAILIDS, SQLOpt.EQUAL);
			userDAO.updateUserRecord(record, opt);
		}
	}
	
	@Override
	public void initSysMallCache(){
		List<SysMail> list = sysMailDao.querySysMails();
		Map<Integer, Map<Integer, SysMail>> map = new HashMap<>();
		for(SysMail mail : list){
			Map<Integer, SysMail> m = map.get(mail.getPartner());
			if(m == null){
				m = new HashMap<>();
				map.put(mail.getPartner(), m);
			}
			m.put(mail.getId(), mail);
		}
		sysMailDao.clearSysMailCache();
		for(Entry<Integer, Map<Integer, SysMail>> entry : map.entrySet()){
			sysMailDao.setSysMailsCache(entry.getKey(), entry.getValue());
		}
	}
}
