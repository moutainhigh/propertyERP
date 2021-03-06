package com.cnfantasia.server.domainbase.redpointContent.dao;

import java.util.Map;
import java.util.List;

import com.cnfantasia.server.business.pub.entity.PageModel;

import com.cnfantasia.server.domainbase.redpointContent.entity.RedpointContent;

/**
 * 描述:(红点信息表) DAO层接口
 * 
 * @version 1.00
 * @author null
 * 
 */
public interface IRedpointContentBaseDao {
	/**
	 * 根据条件查询(红点信息表)信息
	 * @param paramMap
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public List<RedpointContent> selectRedpointContentByCondition(Map<String,Object> paramMap,boolean isDim);
	/**
	 * 按条件分页查询(红点信息表)信息
	 * @param paramMap
	 * @param pageModel
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public List<RedpointContent> selectRedpointContentByCondition(Map<String,Object> paramMap,PageModel pageModel,boolean isDim);
	/**
	 * 根据序列号查询(红点信息表)信息
	 * @param id
	 * @return
	 */
	public RedpointContent selectRedpointContentBySeqId(java.math.BigInteger id);
	/**
	 * 根据条件查询满足条件的(红点信息表)记录数
	 * @param paramMap
	 * @param isDim true表示模糊查询,false表示精确查询
	 * @return
	 */
	public int selectRedpointContentCount(Map<String,Object> paramMap,boolean isDim);
	/**
	 * 往(红点信息表)新增一条记录
	 * @param redpointContent
	 * @return
	 */
	public int insertRedpointContent(RedpointContent redpointContent);
	
	/**
	 * 批量新增(红点信息表)信息
	 * @param redpointContentList
	 * @return
	 */
	public int insertRedpointContentBatch(List<RedpointContent> redpointContentList);
	
	/**
	 * 更新(红点信息表)信息
	 * @param redpointContent
	 * @return
	 */
	public int updateRedpointContent(RedpointContent redpointContent);
	
	/**
	 * 批量更新(红点信息表)信息
	 * @param redpointContentList
	 * @return
	 */
	public int updateRedpointContentBatch(List<RedpointContent> redpointContentList);
	
	/**
	 * 根据序列号删除(红点信息表)信息_逻辑删除
	 * @param id
	 * @return
	 */
	
	public int deleteRedpointContentLogic(java.math.BigInteger id);
	
	/**
	 * 根据Id 批量删除(红点信息表)信息_逻辑删除
	 * @param idList
	 * @return
	 */
	
	public int deleteRedpointContentLogicBatch(List<java.math.BigInteger> idList);
	
	
//	/**
//	 * 根据序列号删除(红点信息表)信息
//	 * @param id
//	 * @return
//	 */
//	public int deleteRedpointContent(java.math.BigInteger id);
//	
//	/**
//	 * 根据序列号批量删除(红点信息表)信息
//	 * @param idList
//	 * @return
//	 */
//	public int deleteRedpointContentBatch(List<java.math.BigInteger> idList);
	
	
}
