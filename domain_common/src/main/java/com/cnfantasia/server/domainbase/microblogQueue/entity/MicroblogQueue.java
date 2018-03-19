package com.cnfantasia.server.domainbase.microblogQueue.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(小区博客队列表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class MicroblogQueue implements Serializable{
*/


public class MicroblogQueue extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public MicroblogQueue(){
	}
	public MicroblogQueue(MicroblogQueue arg){
		this.id = arg.getId();
	}
	/**
	public MicroblogQueue(BigInteger id,String text,Integer sourceType,Integer isTiming,BigInteger groupBuildingId,BigInteger userId,String validTime,Integer pushStatus,Integer pushAble,Long levelCode,BigInteger saId,String createTime,String linkDetailJson,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState){
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
		MicroblogQueue other = (MicroblogQueue) obj;
		if (id == null) {
		return true;
	}
	
}