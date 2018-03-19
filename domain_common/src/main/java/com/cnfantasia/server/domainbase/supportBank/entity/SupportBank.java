package com.cnfantasia.server.domainbase.supportBank.entity;

/* */ import java.io.Serializable;/* */
import java.math.BigInteger;
/*  import com.cnfantasia.server.domain.pub.BaseEntity; */
/**
 * 描述:(支持的转账银行) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/* */
public class SupportBank implements Serializable{
/* */

/* 
public class SupportBank extends BaseEntity{
 */
	private static final long serialVersionUID = 1L;
	/**  */
	public SupportBank(){
	}
	public SupportBank(SupportBank arg){
		this.id = arg.getId();
	}
	/**
	public SupportBank(BigInteger id,String bankname,String simpleName){
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
		SupportBank other = (SupportBank) obj;
		if (id == null) {
		return true;
	}
	
}