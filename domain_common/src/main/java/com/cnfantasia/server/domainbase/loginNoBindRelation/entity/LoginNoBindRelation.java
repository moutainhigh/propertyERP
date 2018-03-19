package com.cnfantasia.server.domainbase.loginNoBindRelation.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(登录账号绑定关系) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class LoginNoBindRelation implements Serializable{
*/


public class LoginNoBindRelation extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public LoginNoBindRelation(){
	}
	public LoginNoBindRelation(LoginNoBindRelation arg){
		this.id = arg.getId();
	}
	/**
	public LoginNoBindRelation(BigInteger id,BigInteger mainUserId,BigInteger applyUserId,BigInteger mainLoginNoId,BigInteger applyLoginNoId,String createTime,BigInteger createUserId,BigInteger createRoomId,String mainAccNo,Long mainAccType,String applyAccNo,Long applyAccType,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState){
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
		LoginNoBindRelation other = (LoginNoBindRelation) obj;
		if (id == null) {
		return true;
	}
	
}