package com.cnfantasia.server.domainbase.groupBuildingHasTCommunitySupplyTmp.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(小区临时商家关系表) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class GroupBuildingHasTCommunitySupplyTmp implements Serializable{
*/


public class GroupBuildingHasTCommunitySupplyTmp extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public GroupBuildingHasTCommunitySupplyTmp(){
	}
	public GroupBuildingHasTCommunitySupplyTmp(GroupBuildingHasTCommunitySupplyTmp arg){
		this.id = arg.getId();
	}
	/**
	public GroupBuildingHasTCommunitySupplyTmp(BigInteger id,BigInteger tGroupBuildingFId,BigInteger tCommunitySupplyTmpFId,Integer order,Double distance,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState,BigInteger tCommunitySupplyCompanyFId){
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
		GroupBuildingHasTCommunitySupplyTmp other = (GroupBuildingHasTCommunitySupplyTmp) obj;
		if (id == null) {
		return true;
	}
	
}