package com.cnfantasia.server.domainbase.prizeRuleGenerateUsercount.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:(折扣生成规则-用户数量因素) 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class PrizeRuleGenerateUsercount implements Serializable{
*/


public class PrizeRuleGenerateUsercount extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */
	public PrizeRuleGenerateUsercount(){
	}
	public PrizeRuleGenerateUsercount(PrizeRuleGenerateUsercount arg){
		this.id = arg.getId();
	}
	/**
	public PrizeRuleGenerateUsercount(BigInteger id,Long startCount,Long endCount,Long areaAPercent,Long areaBPercent,Long areaCPercent,Long areaDPercent,Long areaEPercent,String desc,Integer configType,String startTime,String endTime,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState){
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
		PrizeRuleGenerateUsercount other = (PrizeRuleGenerateUsercount) obj;
		if (id == null) {
		return true;
	}
	
}