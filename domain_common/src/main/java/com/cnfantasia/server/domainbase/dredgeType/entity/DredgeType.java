package com.cnfantasia.server.domainbase.dredgeType.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(疏通类型) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class DredgeType implements Serializable{
*/


public class DredgeType extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public DredgeType(){
	}
	public DredgeType(DredgeType arg){
		this.id = arg.getId();
	}
	/**
	public DredgeType(BigInteger id,String code,BigInteger tCommunitySupplyTypeFId,String name,String picUrl,String desc,String priceDesc,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,String serviceProcessUrl,Integer isHasNum){
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
		DredgeType other = (DredgeType) obj;
		if (id == null) {
		return true;
	}
	
}