package com.cnfantasia.server.domainbase.user.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(用户表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class User implements Serializable{
*/


public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/** 用户编号 */
	public User(){
	}
	public User(User arg){
		this.id = arg.getId();
	}
	/**
	public User(BigInteger id,String mobile,String huaId,String nickName,String realName,String sex,String birthday,String imgprofile,BigInteger defaultRoomId,BigInteger mainRoomId,String utmCampaign,String utmContent,Integer isFirstLoginStatus,Long userState,Long tChannelSubFId,String inviteNo,Integer passwdStatus,String lastPwderrTime,String lastLoginTime,String lastPwdmodTime,String lastPwdResetTime,String deviceId,String signature,String channel,String version,Integer familyRole,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,BigInteger tOmsUserFId,Integer phoneBindState){
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
		User other = (User) obj;
		if (id == null) {
		return true;
	}
	
}