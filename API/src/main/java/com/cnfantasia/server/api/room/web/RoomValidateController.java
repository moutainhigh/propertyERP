/**   
* Filename:    RoomValidateController.java   
* @version:    1.0  
* Create at:   2014年8月14日 上午8:05:15   
* Description:  
*   
* Modification History:   
* Date        Author      Version     Description   
* ----------------------------------------------------------------- 
* 2014年8月14日    shiyl      1.0         1.0 Version   
*/
package com.cnfantasia.server.api.room.web;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnfantasia.server.api.commSysPara.constant.SysParamKey;
import com.cnfantasia.server.api.commonBusiness.service.ICommonRoomService;
import com.cnfantasia.server.api.fileServer.constant.FileServerConstant;
import com.cnfantasia.server.api.fileServer.service.IFileServerService;
import com.cnfantasia.server.api.pub.BaseController;
import com.cnfantasia.server.api.pub.session.UserContext;
import com.cnfantasia.server.api.pub.utils.CnfantasiaCommbusiUtil;
import com.cnfantasia.server.api.room.constant.RoomDict;
import com.cnfantasia.server.api.room.service.IRoomService;
import com.cnfantasia.server.business.pub.entity.RequestFileEntity;
import com.cnfantasia.server.business.pub.sysParam.ISysParamManager;
import com.cnfantasia.server.business.pub.utils.CommRequestFileParser;
import com.cnfantasia.server.common.exception.BusinessRuntimeException;
import com.cnfantasia.server.common.json.JsonResponse;
import com.cnfantasia.server.common.utils.ParamUtils;
import com.cnfantasia.server.common.utils.StringUtils;
import com.cnfantasia.server.domainbase.room.entity.Room;
import com.cnfantasia.server.domainbase.room.service.IRoomBaseService;
import com.cnfantasia.server.domainbase.roomValidate.entity.RoomValidate;

/**
 * Filename:    RoomValidateController.java
 * @version:    1.0.0
 * Create at:   2014年8月14日 上午8:05:15
 * Description:
 *
 * Modification History:
 * Date           Author           Version           Description
 * ------------------------------------------------------------------
 * 2014年8月14日       shiyl             1.0             1.0 Version
 */
@Controller
@RequestMapping("/roomValidate")
public class RoomValidateController extends BaseController{
	private Log logger = LogFactory.getLog(this.getClass());
	
	private IRoomService roomService;
	public void setRoomService(IRoomService roomService) {
		this.roomService = roomService;
	}

	private IFileServerService fileServerService;
	public void setFileServerService(IFileServerService fileServerService) {
		this.fileServerService = fileServerService;
	}

	private ISysParamManager sysParamManager;
	public void setSysParamManager(ISysParamManager sysParamManager) {
		this.sysParamManager = sysParamManager;
	}
	
	/**
	 * 查询当前门牌验证信息
	 */
	@RequestMapping("/qryCurrRoomValidateInfo.json")
	@ResponseBody
	public JsonResponse qryCurrRoomValidateInfo(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		BigInteger roomId = null;
		String roomIdStr = request.getParameter("roomId");
		if(!StringUtils.isEmpty(roomIdStr)){
			roomId = new BigInteger(roomIdStr);
		}
		BigInteger userId = UserContext.getOperIdMustExistBigInteger();
		//2.交互
		RoomValidate roomValidate = null;
		if(roomId!=null){
			roomValidate = roomService.getRoomValidate(userId,roomId);
		}else{
			roomValidate = roomService.getRoomValidateWithDefault(userId);
		}
		
		//3.结果处理
		Map<String,Object> resMap = roomValidate2Map(roomValidate);
		jsonResponse.setDataValue(resMap);
		return jsonResponse;
	}
	
	/**
	 * 提交门牌验证
	 */
	@RequestMapping("/confirmValidate.json")
	@ResponseBody
	public JsonResponse confirmValidate(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		BigInteger roomId = null;
		String roomIdStr = request.getParameter("roomId");
		if(!StringUtils.isEmpty(roomIdStr)){
			roomId= new BigInteger(roomIdStr);
		}
		BigInteger userId = UserContext.getOperIdMustExistBigInteger();
		RequestFileEntity requestFileEntity = CommRequestFileParser.parseRequsetFileInfo(request, "picInfo");
		if(requestFileEntity==null||requestFileEntity.getFileContent()==null||requestFileEntity.getFileContent().length<=0){
			throw new BusinessRuntimeException("roomValidate.confirmValidate.picInfo.isEmpty");
		}
		//2.交互
		RoomValidate roomValidate = roomService.confirmValidate(userId, roomId, requestFileEntity);
		//3.结果处理
		Map<String,Object> resMap = roomValidate2Map(roomValidate);
		jsonResponse.setDataValue(resMap);
		return jsonResponse;
	}
	
	/**
	 * 申请门牌验证
	 */
	@RequestMapping("/applyValidate.json")
	@ResponseBody
	public JsonResponse applyValidate(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		BigInteger userId = UserContext.getOperIdMustExistBigInteger();
		//2.交互
		roomService.applyRoomValidate(userId);
		//3.结果处理
		return jsonResponse;
	}
	
	/**
	 * 申请门牌自动验证
	 */
	@RequestMapping("/applyAutoValidate.json")
	@ResponseBody
	public JsonResponse applyAutoValidate(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		try {
			BigInteger realRoomId = ParamUtils.getBigInteger(request, "realRoomId", BigInteger.ZERO);
			BigInteger huaId =  ParamUtils.getBigInteger(request, "userId", BigInteger.ZERO);
			
			logger.info("RoomValidateController realRoomId:" + realRoomId + ",huaId:" + huaId);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("tRealRoomFId", realRoomId);
			paramMap.put("creater", huaId);
			
			IRoomBaseService roomBaseService = (IRoomBaseService) CnfantasiaCommbusiUtil.getBeanManager("roomBaseService");
			ICommonRoomService commonRoomService = (ICommonRoomService) CnfantasiaCommbusiUtil.getBeanManager("commonRoomService");
			List<Room> roomList = roomBaseService.getRoomByCondition(paramMap);
			BigInteger roomId = roomList.get(0).getId();
			logger.info("RoomValidateController roomId:" + roomId);
			commonRoomService.addValidateSuccessInfo(huaId, roomId, RoomDict.RoomValidte_SourceType.Property_Card, "物业代扣卡划扣成功后，门牌自动验证通过成功");//增加验证成功的信息
			logger.info("物业代扣卡划扣成功后，门牌自动验证通过成功！");
		} catch(Exception e) {
			logger.error("物业代扣卡划扣成功后，门牌自动验证通过失败！");
			logger.error(e.getMessage(), e);
		}
		return jsonResponse;
	}
	
//	/**
//	 * 更改门牌验证
//	 */
//	@RequestMapping("/changeValidate.json")
//	@ResponseBody
//	public JsonResponse changeValidate(HttpServletRequest request){
//		JsonResponse jsonResponse = new JsonResponse();
//		//1.搜集参数
//		BigInteger roomId = new BigInteger(request.getParameter("roomId"));
//		BigInteger userId = UserContext.getOperIdMustExistBigInteger();
//		RequestFileEntity requestFileEntity = CommRequestFileParser.parseRequsetFileInfo(request, "picInfo");
//		if(requestFileEntity==null||requestFileEntity.getFileContent().length<=0){
//			throw new BusinessRuntimeException("roomValidate.confirmValidate.picInfo.isEmpty");
//		}
//		//2.交互
//		RoomValidate roomValidate = roomService.changeValidate(userId, roomId, requestFileEntity);
//		//3.结果处理
//		Map<String,Object> resMap = roomValidate2Map(roomValidate);
//		jsonResponse.setDataValue(resMap);
//		return jsonResponse;
//	}
	
	
	private Map<String,Object> roomValidate2Map(RoomValidate roomValidate){
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(roomValidate!=null){
			resMap.put("verifyId", roomValidate.getId());
			resMap.put("roomId", roomValidate.gettRoomFId());
			resMap.put("verifyPicUrl",StringUtils.isEmpty(roomValidate.getVerifyPicUrl())?FileServerConstant.DEFAULT_NULL_PIC_URL:fileServerService.getAccessUrl(sysParamManager.getSysParaValue(SysParamKey.ROOM_VALIDATE_PIC_BASEPATH)+roomValidate.getVerifyPicUrl(), roomValidate) );
			resMap.put("verifyResultDesc", roomValidate.getVerifyResultDesc());
			resMap.put("verifyStatus", roomValidate.getVerifyStatus());
		}else{
			resMap.put("verifyId", null);
			resMap.put("verifyStatus", RoomDict.RoomValidte_VerifyStatus.UNDO);
		}
		return resMap;
	}
	
	
}
