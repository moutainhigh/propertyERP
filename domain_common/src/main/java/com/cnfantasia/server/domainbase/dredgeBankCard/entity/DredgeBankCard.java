package com.cnfantasia.server.domainbase.dredgeBankCard.entity;

/* */ import java.io.Serializable;/* */
import java.math.BigInteger;
/*  import com.cnfantasia.server.domain.pub.BaseEntity; */
/**
 * 描述:(用户绑定的银行卡信息) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/* */
public class DredgeBankCard implements Serializable{
/* */

/* 
public class DredgeBankCard extends BaseEntity{
 */
	private static final long serialVersionUID = 1L;
	/**  */
	public DredgeBankCard(){
	}
	public DredgeBankCard(DredgeBankCard arg){
		this.id = arg.getId();
	}
	/**
	public DredgeBankCard(BigInteger id,String bankName,String bankBranchName,String ownerName,String bankNo,BigInteger tUserFId,Integer isDefault,String bankProvince,String bankCity){
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
		DredgeBankCard other = (DredgeBankCard) obj;
		if (id == null) {
		return true;
	}
	
}