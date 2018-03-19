package com.cnfantasia.server.domainbase.ebuyOrderHasCoupon.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(订单使用消费券表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class EbuyOrderHasCoupon implements Serializable{
*/


public class EbuyOrderHasCoupon extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public EbuyOrderHasCoupon(){
	}
	public EbuyOrderHasCoupon(EbuyOrderHasCoupon arg){
		this.id = arg.getId();
	}
	/**
	public EbuyOrderHasCoupon(BigInteger id,BigInteger tEbuyOrderFId,BigInteger tUserCouponFId,Long amount,String sys0AddTime,BigInteger sys0AddUser,String sys0UpdTime,BigInteger sys0UpdUser,String sys0DelTime,BigInteger sys0DelUser,Integer sys0DelState){
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
		EbuyOrderHasCoupon other = (EbuyOrderHasCoupon) obj;
		if (id == null) {
		return true;
	}
	
}