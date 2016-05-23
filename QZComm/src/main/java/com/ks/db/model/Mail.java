package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.codehaus.jackson.type.TypeReference;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.util.JSONUtil;
/**
 * 邮件
 * @author ks
 */
@DBBeanSet(primaryKey={"mail_id"})
@Data
public class Mail implements Serializable {
	private static final long serialVersionUID = 1L;
	/**邮件编号*/
	@DBFieldSet(dbfname="mail_id")
	private int mailId;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**标题*/
	@DBFieldSet(dbfname="title")
	private String title;
	/**内容*/
	@DBFieldSet(dbfname="context")
	private String context;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**物品*/
	@DBFieldSet(dbfname="goods")
	private String goodses;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	
	private List<Goods> goodsList;
	private void initGoodsList(){
		goodsList = JSONUtil.toObject(goodses, new TypeReference<List<Goods>>(){});
	}
	private void initGoodses(){
		goodses = JSONUtil.toJson(goodsList);
	}
	public static final Mail createMail(int userId,int type,String title,String context, List<Goods> goodses){
		Mail mail = new Mail();
		mail.setUserId(userId);
		mail.setType(type);
		mail.setTitle(title);
		mail.setContext(context);
		mail.setGoodsList(goodses);
		mail.setState(SystemConstant.MAIL_STATE_UNREAD);
		return mail;
	}
	public int getMailId() {
		return mailId;
	}
	public void setMailId(int mailId) {
		this.mailId = mailId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getGoodses() {
		initGoodses();
		return goodses;
	}
	public void setGoodses(String goodses) {
		this.goodses = goodses;
		initGoodsList();
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
