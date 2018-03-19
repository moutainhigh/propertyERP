package com.cnfantasia.server.domainbase.propertyRepair.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(物业报修单) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class PropertyRepair implements Serializable{
*/


public class PropertyRepair extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public PropertyRepair(){
	}
	public PropertyRepair(PropertyRepair arg){
		this.id = arg.getId();
	}
	/**
	public PropertyRepair(BigInteger id,String number,String address,String tel,String repairContent,String expectDate,String expectTimeBegin,String expectTimeEnd,Integer repaireState,String cancelTime,String asignTime,String asignDesc,String finishedTime,String picUrl,BigInteger tGroupBuildingFId,BigInteger tUserFId,BigInteger tRoomFId,Integer isTransed,BigInteger tPropertyRepairerFId,String estimateDoorTimeBegin,String estimateDoorTimeEnd,BigInteger tPropertyRepairTypeFId,String softwareBillId,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,String finishDesc){
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();
	}
	
	public BigInteger getId() {
	
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
		PropertyRepair other = (PropertyRepair) obj;
		if (id == null) {
		return true;
	}
	
}