package com.cnfantasia.server.domainbase.remoteUser.entity;

/* */ import java.io.Serializable;/* */
import java.lang.Long;
/*  import com.cnfantasia.server.domain.pub.BaseEntity; */
/**
 * 描述:(远程用户信息) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/* */
public class RemoteUser implements Serializable{
/* */

/* 
public class RemoteUser extends BaseEntity{
 */
	private static final long serialVersionUID = 1L;
	/** 远程用户Id */
	public RemoteUser(){
	}
	public RemoteUser(RemoteUser arg){
		this.uid = arg.getUid();
	}
	/**
	public RemoteUser(Long uid,BigInteger tUserFId,String userName,String password,String email){
		this.uid = uid;
	}

	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();
	}
	
	public Long getUid() {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		RemoteUser other = (RemoteUser) obj;
		if (uid == null) {
		return true;
	}
	
}