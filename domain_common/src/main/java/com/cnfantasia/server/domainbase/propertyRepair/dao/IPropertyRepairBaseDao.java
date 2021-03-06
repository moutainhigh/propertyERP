package com.cnfantasia.server.domainbase.propertyRepair.dao;

import java.util.Map;
import java.util.List;

import com.cnfantasia.server.business.pub.entity.PageModel;

import com.cnfantasia.server.domainbase.propertyRepair.entity.PropertyRepair;

/**
 * 描述:(物业报修单) DAO层接口
 * 
 * @version 1.00
 * @author null
 * 
 */
public interface IPropertyRepairBaseDao {
	/**
	 * 根据条件查询(物业报修单)信息
	 * @param paramMap
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public List<PropertyRepair> selectPropertyRepairByCondition(Map<String,Object> paramMap,boolean isDim);
	/**
	 * 按条件分页查询(物业报修单)信息
	 * @param paramMap
	 * @param pageModel
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public List<PropertyRepair> selectPropertyRepairByCondition(Map<String,Object> paramMap,PageModel pageModel,boolean isDim);
	/**
	 * 根据序列号查询(物业报修单)信息
	 * @param id
	 * @return
	 */
	public PropertyRepair selectPropertyRepairBySeqId(java.math.BigInteger id);
	/**
	 * 根据条件查询满足条件的(物业报修单)记录数
	 * @param paramMap
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public int selectPropertyRepairCount(Map<String,Object> paramMap,boolean isDim);
	/**
	 * 往(物业报修单)新增一条记录
	 * @param propertyRepair
	 * @return
	 */
	public int insertPropertyRepair(PropertyRepair propertyRepair);
	
	/**
	 * 批量新增(物业报修单)信息
	 * @param propertyRepairList
	 * @return
	 */
	public int insertPropertyRepairBatch(List<PropertyRepair> propertyRepairList);
	
	/**
	 * 更新(物业报修单)信息
	 * @param propertyRepair
	 * @return
	 */
	public int updatePropertyRepair(PropertyRepair propertyRepair);
	
	/**
	 * 批量更新(物业报修单)信息
	 * @param propertyRepairList
	 * @return
	 */
	public int updatePropertyRepairBatch(List<PropertyRepair> propertyRepairList);
	
	/**
	 * 根据序列号删除(物业报修单)信息_逻辑删除
	 * @param id
	 * @return
	 */
	
	public int deletePropertyRepairLogic(java.math.BigInteger id);
	
	/**
	 * 根据Id 批量删除(物业报修单)信息_逻辑删除
	 * @param idList
	 * @return
	 */
	
	public int deletePropertyRepairLogicBatch(List<java.math.BigInteger> idList);
	
	
//	/**
//	 * 根据序列号删除(物业报修单)信息
//	 * @param id
//	 * @return
//	 */
//	public int deletePropertyRepair(java.math.BigInteger id);
//	
//	/**
//	 * 根据序列号批量删除(物业报修单)信息
//	 * @param idList
//	 * @return
//	 */
//	public int deletePropertyRepairBatch(List<java.math.BigInteger> idList);
	
	
}
