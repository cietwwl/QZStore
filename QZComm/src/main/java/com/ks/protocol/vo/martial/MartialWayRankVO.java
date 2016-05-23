package com.ks.protocol.vo.martial;

import java.util.ArrayList;
import java.util.List;

import com.ks.model.martial.MartialWay;
import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public class MartialWayRankVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="自己的属性")
	private UserBaseinfoVO myBaseInfo;
	@FieldDesc(desc="自己的武道大会数据")
	private MartialWayVO myWay;
	@FieldDesc(desc="排名数据")
	private List<UserBaseinfoVO> rankInfos;
	@FieldDesc(desc="排名数据")
	private List<MartialWayVO> rankWays;
	
	
	public void init(UserBaseinfo myBaseInfo, MartialWay myWay,
			int myRank, List<UserBaseinfo> rankInfos,
			List<MartialWay> rankWays,int page) {
		this.myBaseInfo = MessageFactory.getMessage(UserBaseinfoVO.class);
		this.myBaseInfo.init(myBaseInfo);
		
		if(myWay!=null){
			this.myWay = MessageFactory.getMessage(MartialWayVO.class);
			this.myWay.init(myWay,myRank);
		}
		
		this.rankInfos = new ArrayList<UserBaseinfoVO>();
		for(UserBaseinfo info : rankInfos){
			UserBaseinfoVO vo = MessageFactory.getMessage(UserBaseinfoVO.class);
			vo.init(info);
			this.rankInfos.add(vo);
		}
		this.rankWays = new ArrayList<MartialWayVO>();
		int i=1;
		for(MartialWay way : rankWays){
			MartialWayVO vo = MessageFactory.getMessage(MartialWayVO.class);
			vo.init(way,i+(page*10));
			this.rankWays.add(vo);
			i++;
		}
	}
	public UserBaseinfoVO getMyBaseInfo() {
		return myBaseInfo;
	}
	public void setMyBaseInfo(UserBaseinfoVO myBaseInfo) {
		this.myBaseInfo = myBaseInfo;
	}
	public MartialWayVO getMyWay() {
		return myWay;
	}
	public void setMyWay(MartialWayVO myWay) {
		this.myWay = myWay;
	}
	public List<UserBaseinfoVO> getRankInfos() {
		return rankInfos;
	}
	public void setRankInfos(List<UserBaseinfoVO> rankInfos) {
		this.rankInfos = rankInfos;
	}
	public List<MartialWayVO> getRankWays() {
		return rankWays;
	}
	public void setRankWays(List<MartialWayVO> rankWays) {
		this.rankWays = rankWays;
	}
}
