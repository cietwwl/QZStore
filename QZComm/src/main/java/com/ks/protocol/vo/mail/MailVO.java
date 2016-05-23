package com.ks.protocol.vo.mail;

import java.util.ArrayList;
import java.util.List;

import com.ks.db.model.Goods;
import com.ks.db.model.Mail;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GoodsVO;

public abstract class MailVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="邮件编号")
	private int mailId;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="标题")
	private String title;
	@FieldDesc(desc="内容")
	private String context;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="物品")
	private List<GoodsVO> goodses;
	@FieldDesc(desc="创建时间")
	private long createTime;
	
	public void init(Mail o){
		this.mailId = o.getMailId();
		this.type = o.getType();
		this.title = o.getTitle();
		this.context = o.getContext();
		this.state = o.getState();
		this.goodses = new ArrayList<GoodsVO>();
		for(Goods goods : o.getGoodsList()){
			GoodsVO vo = MessageFactory.getMessage(GoodsVO.class);
			vo.init(goods);
			this.goodses.add(vo);
		}
		this.createTime = o.getCreateTime().getTime();
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
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

	public List<GoodsVO> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<GoodsVO> goodses) {
		this.goodses = goodses;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

}
