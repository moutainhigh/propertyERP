package com.cnfantasia.server.domainbase.dredgeWorkerCancel.entity;

/* */ import java.io.Serializable;/* */
import java.math.BigInteger;
/*  import com.cnfantasia.server.domain.pub.BaseEntity; */
/**
 * 描述:(疏通师傅取消订单) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/* */
public class DredgeWorkerCancel implements Serializable{
/* */

/* 
public class DredgeWorkerCancel extends BaseEntity{
 */
	private static final long serialVersionUID = 1L;
	/**  */
	public DredgeWorkerCancel(){
	}
	/**
	public DredgeWorkerCancel(BigInteger id,String tCancelReason,BigInteger tUserFId,BigInteger tDredgeBillFId){
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
		DredgeWorkerCancel other = (DredgeWorkerCancel) obj;
		if (id == null) {
		return true;
	}
	
}