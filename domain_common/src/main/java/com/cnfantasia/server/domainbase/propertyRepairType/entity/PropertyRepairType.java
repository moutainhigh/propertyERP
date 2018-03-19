package com.cnfantasia.server.domainbase.propertyRepairType.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(物业报修类型) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class PropertyRepairType implements Serializable{
*/


public class PropertyRepairType extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public PropertyRepairType(){
	}
	public PropertyRepairType(PropertyRepairType arg){
		this.id = arg.getId();
	}
	/**
	public PropertyRepairType(BigInteger id,String name,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,BigInteger tPropertyManagementFId,BigInteger tPropertyRepairTypeBaseFId,BigInteger tDredgeTypeFId){
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
		PropertyRepairType other = (PropertyRepairType) obj;
		if (id == null) {
		return true;
	}
	
}