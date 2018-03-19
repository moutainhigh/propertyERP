package com.cnfantasia.server.domainbase.microblogContent.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(微博信息表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class MicroblogContent implements Serializable{
*/


public class MicroblogContent extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public MicroblogContent(){
	}
	public MicroblogContent(MicroblogContent arg){
		this.id = arg.getId();
	}
	/**
	public MicroblogContent(BigInteger id,String createTime,String activityName,String text,BigInteger userId,BigInteger tMicroblogTypeFId,BigInteger tGroupBuildingFId,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,String lastUpdateTime,Long totalSupportCount,Long totalCommentCount,Integer sourceType,Long showType,BigInteger tMicroblogQueueFId,String linkDetailJson){
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
		MicroblogContent other = (MicroblogContent) obj;
		if (id == null) {
		return true;
	}
	
}