package com.cnfantasia.server.domainbase.commonLock.entity;

/* */ import java.io.Serializable;/* */
import java.math.BigInteger;
/*  import com.cnfantasia.server.domain.pub.BaseEntity; */
/**
 * 描述:(公用的锁表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/* */
public class CommonLock implements Serializable{
/* */

/* 
public class CommonLock extends BaseEntity{
 */
	private static final long serialVersionUID = 1L;
	/**  */
	public CommonLock(){
	}
	public CommonLock(CommonLock arg){
		this.id = arg.getId();
	}
	/**
	public CommonLock(BigInteger id,String tableName){
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
		CommonLock other = (CommonLock) obj;
		if (id == null) {
		return true;
	}
	
}