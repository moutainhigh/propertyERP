package com.cnfantasia.server.domainbase.operationServiceArea.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(服务范围的运营数据表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class OperationServiceArea implements Serializable{
*/


public class OperationServiceArea extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public OperationServiceArea(){
	}
	public OperationServiceArea(OperationServiceArea arg){
		this.id = arg.getId();
	}
	/**
	public OperationServiceArea(BigInteger id,BigInteger tAddressCountryFId,BigInteger tAddressProvinceFId,BigInteger tAddressCityFId,BigInteger tAddressBlockSelfFId,BigInteger tAddressBlockFId,BigInteger tGroupBuildingFId,Integer level,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,String addressUnique){
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
		OperationServiceArea other = (OperationServiceArea) obj;
		if (id == null) {
		return true;
	}
	
}