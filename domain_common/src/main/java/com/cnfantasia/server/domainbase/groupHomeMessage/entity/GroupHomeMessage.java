package com.cnfantasia.server.domainbase.groupHomeMessage.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(首页公共消息表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class GroupHomeMessage implements Serializable{
*/


public class GroupHomeMessage extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public GroupHomeMessage(){
	}
	public GroupHomeMessage(GroupHomeMessage arg){
		this.id = arg.getId();
	}
	/**
	public GroupHomeMessage(BigInteger id,String messageCode,BigInteger gbId,String content,String extInfo,BigInteger resourceId,String validTime,String expireTime,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState){
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
		GroupHomeMessage other = (GroupHomeMessage) obj;
		if (id == null) {
		return true;
	}
	
}