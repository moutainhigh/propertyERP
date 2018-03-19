package com.cnfantasia.server.domainbase.livingFeePayRecord.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(生活缴费记录) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class LivingFeePayRecord implements Serializable{
*/


public class LivingFeePayRecord extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public LivingFeePayRecord(){
	}
	public LivingFeePayRecord(LivingFeePayRecord arg){
		this.id = arg.getId();
	}
	/**
	public LivingFeePayRecord(BigInteger id,String chargeObject,String groupBuildingName,String roomNumuber,String address,String payTime,Long amount,Long amountBalance,Integer status,String linkTel,String name,String cardId,BigInteger tSpId,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,BigInteger tLivingFeeItemFId,BigInteger tEbuyOrderFId,BigInteger tUserFId){
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
		LivingFeePayRecord other = (LivingFeePayRecord) obj;
		if (id == null) {
		return true;
	}
	
}