package com.cnfantasia.server.domainbase.realRoomHasMrLastRecord.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;import java.lang.Double;import java.lang.Integer;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(房间最后一次抄表读数) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class RealRoomHasMrLastRecord implements Serializable{
*/


public class RealRoomHasMrLastRecord extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */	private BigInteger id;	/**  */	private BigInteger tRealRoomFId;	/**  */	private BigInteger tMrFeeItemFId;	/** 间收费标准ID（抄表 */	private BigInteger tMrStandardRoomId;	/** 最后一次读数 */	private Double lastRecord;	/** 最近更新时间 */	private String lastUpdTime;
	public RealRoomHasMrLastRecord(){
	}
	public RealRoomHasMrLastRecord(RealRoomHasMrLastRecord arg){
		this.id = arg.getId();		this.tRealRoomFId = arg.gettRealRoomFId();		this.tMrFeeItemFId = arg.gettMrFeeItemFId();		this.tMrStandardRoomId = arg.gettMrStandardRoomId();		this.lastRecord = arg.getLastRecord();		this.lastUpdTime = arg.getLastUpdTime();		this.sys0AddTime = arg.getSys0AddTime();		this.sys0UpdTime = arg.getSys0UpdTime();		this.sys0DelTime = arg.getSys0DelTime();		this.sys0AddUser = arg.getSys0AddUser();		this.sys0UpdUser = arg.getSys0UpdUser();		this.sys0DelUser = arg.getSys0DelUser();		this.sys0DelState = arg.getSys0DelState();
	}
	/**	 * 	 * @param id 	 * @param tRealRoomFId 	 * @param tMrFeeItemFId 	 * @param tMrStandardRoomId 间收费标准ID（抄表	 * @param lastRecord 最后一次读数	 * @param lastUpdTime 最近更新时间	 * @param sys0AddTime 新增时间	 * @param sys0UpdTime 更新时间	 * @param sys0DelTime 删除时间	 * @param sys0AddUser 新增者	 * @param sys0UpdUser 修改者	 * @param sys0DelUser 删除者	 * @param sys0DelState 记录状态	 */
	public RealRoomHasMrLastRecord(BigInteger id,BigInteger tRealRoomFId,BigInteger tMrFeeItemFId,BigInteger tMrStandardRoomId,Double lastRecord,String lastUpdTime,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState){
		this.id = id;		this.tRealRoomFId = tRealRoomFId;		this.tMrFeeItemFId = tMrFeeItemFId;		this.tMrStandardRoomId = tMrStandardRoomId;		this.lastRecord = lastRecord;		this.lastUpdTime = lastUpdTime;		this.sys0AddTime = sys0AddTime;		this.sys0UpdTime = sys0UpdTime;		this.sys0DelTime = sys0DelTime;		this.sys0AddUser = sys0AddUser;		this.sys0UpdUser = sys0UpdUser;		this.sys0DelUser = sys0DelUser;		this.sys0DelState = sys0DelState;
	}

	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();		sbf.append("id=").append(id).append(";");		sbf.append("tRealRoomFId=").append(tRealRoomFId).append(";");		sbf.append("tMrFeeItemFId=").append(tMrFeeItemFId).append(";");		sbf.append("tMrStandardRoomId=").append(tMrStandardRoomId).append(";");		sbf.append("lastRecord=").append(lastRecord).append(";");		sbf.append("lastUpdTime=").append(lastUpdTime).append(";");		sbf.append("sys0AddTime=").append(sys0AddTime).append(";");		sbf.append("sys0UpdTime=").append(sys0UpdTime).append(";");		sbf.append("sys0DelTime=").append(sys0DelTime).append(";");		sbf.append("sys0AddUser=").append(sys0AddUser).append(";");		sbf.append("sys0UpdUser=").append(sys0UpdUser).append(";");		sbf.append("sys0DelUser=").append(sys0DelUser).append(";");		sbf.append("sys0DelState=").append(sys0DelState).append(";");		return sbf.toString();
	}
	
	public BigInteger getId() {		return id;	}	public void setId(BigInteger id) {		this.id = id;	}	public BigInteger gettRealRoomFId() {		return tRealRoomFId;	}	public void settRealRoomFId(BigInteger tRealRoomFId) {		this.tRealRoomFId = tRealRoomFId;	}	public BigInteger gettMrFeeItemFId() {		return tMrFeeItemFId;	}	public void settMrFeeItemFId(BigInteger tMrFeeItemFId) {		this.tMrFeeItemFId = tMrFeeItemFId;	}	public BigInteger gettMrStandardRoomId() {		return tMrStandardRoomId;	}	public void settMrStandardRoomId(BigInteger tMrStandardRoomId) {		this.tMrStandardRoomId = tMrStandardRoomId;	}	public Double getLastRecord() {		return lastRecord;	}	public void setLastRecord(Double lastRecord) {		this.lastRecord = lastRecord;	}	public String getLastUpdTime() {		return lastUpdTime;	}	public void setLastUpdTime(String lastUpdTime) {		this.lastUpdTime = lastUpdTime;	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealRoomHasMrLastRecord other = (RealRoomHasMrLastRecord) obj;
		if (id == null) {			if (other.id != null)				return false;		} else if (!id.equals(other.id))			return false;
		return true;
	}
	
}
