package com.cnfantasia.server.domainbase.bcOfferRecord.entity;

/* */ import java.io.Serializable;/* */
import java.math.BigInteger;
/*  import com.cnfantasia.server.domain.pub.BaseEntity; */
/**
 * 描述:(发盘记录) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/* */
public class BcOfferRecord implements Serializable{
/* */

/* 
public class BcOfferRecord extends BaseEntity{
 */
	private static final long serialVersionUID = 1L;
	/**  */
	public BcOfferRecord(){
	}
	public BcOfferRecord(BcOfferRecord arg){
		this.id = arg.getId();
	}
	/**
	public BcOfferRecord(BigInteger id,BigInteger paybillId,String shortCode,String offerContent,String offerTime,BigInteger tBcGroupBuildingCycleFId){
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
		BcOfferRecord other = (BcOfferRecord) obj;
		if (id == null) {
		return true;
	}
	
}