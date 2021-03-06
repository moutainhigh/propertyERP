package com.cnfantasia.server.domainbase.propertyAccountInfo.dao;

import java.util.Map;
import java.util.List;

import com.cnfantasia.server.business.pub.entity.PageModel;

import com.cnfantasia.server.domainbase.propertyAccountInfo.entity.PropertyAccountInfo;

/**
 * 描述:(用户物业账户信息) DAO层接口
 * 
 * @version 1.00
 * @author null
 * 
 */
public interface IPropertyAccountInfoBaseDao {
	/**
	 * 根据条件查询(用户物业账户信息)信息
	 * @param paramMap
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public List<PropertyAccountInfo> selectPropertyAccountInfoByCondition(Map<String,Object> paramMap,boolean isDim);
	/**
	 * 按条件分页查询(用户物业账户信息)信息
	 * @param paramMap
	 * @param pageModel
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public List<PropertyAccountInfo> selectPropertyAccountInfoByCondition(Map<String,Object> paramMap,PageModel pageModel,boolean isDim);
	/**
	 * 根据序列号查询(用户物业账户信息)信息
	 * @param id
	 * @return
	 */
	public PropertyAccountInfo selectPropertyAccountInfoBySeqId(java.math.BigInteger id);
	/**
	 * 根据条件查询满足条件的(用户物业账户信息)记录数
	 * @param paramMap
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public int selectPropertyAccountInfoCount(Map<String,Object> paramMap,boolean isDim);
	/**
	 * 往(用户物业账户信息)新增一条记录
	 * @param propertyAccountInfo
	 * @return
	 */
	public int insertPropertyAccountInfo(PropertyAccountInfo propertyAccountInfo);
	
	/**
	 * 批量新增(用户物业账户信息)信息
	 * @param propertyAccountInfoList
	 * @return
	 */
	public int insertPropertyAccountInfoBatch(List<PropertyAccountInfo> propertyAccountInfoList);
	
	/**
	 * 更新(用户物业账户信息)信息
	 * @param propertyAccountInfo
	 * @return
	 */
	public int updatePropertyAccountInfo(PropertyAccountInfo propertyAccountInfo);
	
	/**
	 * 批量更新(用户物业账户信息)信息
	 * @param propertyAccountInfoList
	 * @return
	 */
	public int updatePropertyAccountInfoBatch(List<PropertyAccountInfo> propertyAccountInfoList);
	
	/**
	 * 根据序列号删除(用户物业账户信息)信息_逻辑删除
	 * @param id
	 * @return
	 */
	
	public int deletePropertyAccountInfoLogic(java.math.BigInteger id);
	
	/**
	 * 根据Id 批量删除(用户物业账户信息)信息_逻辑删除
	 * @param idList
	 * @return
	 */
	
	public int deletePropertyAccountInfoLogicBatch(List<java.math.BigInteger> idList);
	
	
//	/**
//	 * 根据序列号删除(用户物业账户信息)信息
//	 * @param id
//	 * @return
//	 */
//	public int deletePropertyAccountInfo(java.math.BigInteger id);
//	
//	/**
//	 * 根据序列号批量删除(用户物业账户信息)信息
//	 * @param idList
//	 * @return
//	 */
//	public int deletePropertyAccountInfoBatch(List<java.math.BigInteger> idList);
	
	
}
