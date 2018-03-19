package com.cnfantasia.server.domainbase.parkingRecord.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
import java.lang.Integer;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(停车记录表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class ParkingRecord implements Serializable{
*/


public class ParkingRecord extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	/** 停车小区Id */
	private BigInteger tGroupBuildingId;
	public ParkingRecord(){
	}
	public ParkingRecord(ParkingRecord arg){
		this.id = arg.getId();
		this.parkingFee = arg.getParkingFee();
		this.tGroupBuildingId = arg.gettGroupBuildingId();
		this.sys0AddTime = arg.getSys0AddTime();
		this.sys0UpdTime = arg.getSys0UpdTime();
	/**
	public ParkingRecord(BigInteger id,String parkingStartTime,String parkingEndTime,BigInteger tCarNumId,Long parkingFee,BigInteger tGroupBuildingId,String sys0AddTime,String sys0UpdTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,String sys0DelTime,BigInteger sys0DelUser,Integer sys0DelState){
		this.id = id;
		this.parkingFee = parkingFee;
		this.tGroupBuildingId = tGroupBuildingId;
		this.sys0AddTime = sys0AddTime;
		this.sys0UpdTime = sys0UpdTime;

	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("parkingFee=").append(parkingFee).append(";");
		sbf.append("tGroupBuildingId=").append(tGroupBuildingId).append(";");
		sbf.append("sys0AddTime=").append(sys0AddTime).append(";");
		sbf.append("sys0UpdTime=").append(sys0UpdTime).append(";");
	}
	
	public BigInteger getId() {
	public BigInteger gettGroupBuildingId() {
		return tGroupBuildingId;
	}
	public void settGroupBuildingId(BigInteger tGroupBuildingId) {
		this.tGroupBuildingId = tGroupBuildingId;
	}
	
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
		ParkingRecord other = (ParkingRecord) obj;
		if (id == null) {
		return true;
	}
	
}