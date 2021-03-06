/**   
* Filename:    FamilyWealthController.java   
* @version:    1.0  
* Create at:   2015年4月29日 上午2:17:50   
* Description:  
*   
* Modification History:   
* Date        Author      Version     Description   
* ----------------------------------------------------------------- 
* 2015年4月29日    shiyl      1.0         1.0 Version   
*/
package com.cnfantasia.server.api.familyWealth.web;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnfantasia.server.api.commSysPara.constant.SysParamKey;
import com.cnfantasia.server.api.commSysPara.entity.CompanyInfoConfig;
import com.cnfantasia.server.api.commonBusiness.service.ICommonPrizeService;
import com.cnfantasia.server.api.commonBusiness.service.ICommonRoomService;
import com.cnfantasia.server.api.commonBusiness.util.EbuyChannelParseUtil;
import com.cnfantasia.server.api.commonBusiness.util.PropertyPeriodCalculateUtil;
import com.cnfantasia.server.api.commonBusiness.util.UserShowNameUtil;
import com.cnfantasia.server.api.company.service.ICompanyService;
import com.cnfantasia.server.api.familyWealth.constant.FamilyWealthDict;
import com.cnfantasia.server.api.familyWealth.entity.FamilyWealthOptionEntity;
import com.cnfantasia.server.api.familyWealth.service.IFamilyWealthService;
import com.cnfantasia.server.api.fileServer.constant.FileServerConstant;
import com.cnfantasia.server.api.fileServer.service.IFileServerService;
import com.cnfantasia.server.api.operation.constant.OperationDict;
import com.cnfantasia.server.api.operation.service.IOperationService;
import com.cnfantasia.server.api.plotproperty.constant.PlotpropertyConstant;
import com.cnfantasia.server.api.plotproperty.entity.PlotpropertyCombEntity;
import com.cnfantasia.server.api.plotproperty.entity.PlotpropertyCombShowEntity;
import com.cnfantasia.server.api.plotproperty.service.IPlotpropertyService;
import com.cnfantasia.server.api.plotproperty.util.PayBillShowUtil;
import com.cnfantasia.server.api.prize.entity.PrizeRecordSimpleEntity;
import com.cnfantasia.server.api.pub.BaseController;
import com.cnfantasia.server.api.pub.ControllerUtils;
import com.cnfantasia.server.api.pub.session.UserContext;
import com.cnfantasia.server.api.redenvelope.util.IDiscount2hbRule;
import com.cnfantasia.server.api.room.constant.RoomDict;
import com.cnfantasia.server.api.room.entity.RoomEntityWithValidate;
import com.cnfantasia.server.api.user.entity.UserSimpleEntity;
import com.cnfantasia.server.business.pub.CommControllerUtils;
import com.cnfantasia.server.business.pub.dao.IDualDao;
import com.cnfantasia.server.business.pub.sysParam.ISysParamManager;
import com.cnfantasia.server.business.pub.utils.DateUtil;
import com.cnfantasia.server.commbusi.plotproperty.entity.BusinessMonthYearFactory;
import com.cnfantasia.server.commbusi.plotproperty.entity.IBusinessMonthYear;
import com.cnfantasia.server.commbusi.plotproperty.entity.ISectionDateSignal;
import com.cnfantasia.server.common.json.JsonResponse;
import com.cnfantasia.server.common.utils.PriceUtil;
import com.cnfantasia.server.common.utils.StringUtils;
import com.cnfantasia.server.domainbase.groupBuilding.entity.GroupBuilding;
import com.cnfantasia.server.domainbase.payBill.entity.PayBill;

/**
 * Filename:    FamilyWealthController.java
 * @version:    1.0.0
 * Create at:   2015年4月29日 上午2:17:50
 * Description: 家庭财富Controller
 *
 * Modification History:
 * Date           Author           Version           Description
 * ------------------------------------------------------------------
 * 2015年4月29日       shiyl             1.0             1.0 Version
 */
@Controller
@RequestMapping("/familyWealth")
public class FamilyWealthController extends BaseController{
	
	private IFamilyWealthService familyWealthService;
	public void setFamilyWealthService(IFamilyWealthService familyWealthService) {
		this.familyWealthService = familyWealthService;
	}
	
	private IFileServerService fileServerService;
	public void setFileServerService(IFileServerService fileServerService) {
		this.fileServerService = fileServerService;
	}
	
	private ISysParamManager sysParamManager;
	public void setSysParamManager(ISysParamManager sysParamManager) {
		this.sysParamManager = sysParamManager;
	}
	
	private IPlotpropertyService plotpropertyService;
	public void setPlotpropertyService(IPlotpropertyService plotpropertyService) {
		this.plotpropertyService = plotpropertyService;
	}
	
	private IDualDao dualDao;
	public void setDualDao(IDualDao dualDao) {
		this.dualDao = dualDao;
	}
	
	private IDiscount2hbRule discount2hbRule;
	public void setDiscount2hbRule(IDiscount2hbRule discount2hbRule) {
		this.discount2hbRule = discount2hbRule;
	}
	
	private ICommonPrizeService commonPrizeService;
	public void setCommonPrizeService(ICommonPrizeService commonPrizeService) {
		this.commonPrizeService = commonPrizeService;
	}
	
	private ICommonRoomService commonRoomService;
	public void setCommonRoomService(ICommonRoomService commonRoomService) {
		this.commonRoomService = commonRoomService;
	}
	
	private IOperationService operationService;
	public void setOperationService(IOperationService operationService) {
		this.operationService = operationService;
	}
	
	private ICompanyService companyService;
	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * 查询家庭财富列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/qryWealthList.json")
	@ResponseBody
	public JsonResponse qryWealthList(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		BigInteger userId = UserContext.getOperIdMustExistBigInteger();
		//2.交互
		List<FamilyWealthOptionEntity> familyWealthOptionEntityList = familyWealthService.getFamilyWealthOptionList(userId,EbuyChannelParseUtil.parseIsLightApp(request));
		//3.结果处理
		List<Map<String,Object>> resList = new ArrayList<Map<String,Object>>();
		if(familyWealthOptionEntityList!=null&&familyWealthOptionEntityList.size()>0){
			for(FamilyWealthOptionEntity tmpEntity:familyWealthOptionEntityList){
				Map<String,Object> tmpMap = familyWealthOptionEntity2Map(tmpEntity);
				resList.add(tmpMap);
			}
		}
		return ControllerUtils.addPageInfo(jsonResponse, resList);
	}
	
	/**
	 * 查询物业折扣的信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/qryPropertyDiscountInfo.json")
	@ResponseBody
	public JsonResponse qryPropertyDiscountInfo(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		BigInteger userId = UserContext.getOperIdMustExistBigInteger();
		String yearMonth = CommControllerUtils.getYearMonth(request);
		//2.交互
		IBusinessMonthYear monthYearWithGB = null;
		PlotpropertyCombEntity plotpropertyCombEntity=null;
		GroupBuilding currGroupBuilding = commonRoomService.getGroupBuildingByUserId(userId);
		Date payTime = null;
		try {
			if(!StringUtils.isEmpty(yearMonth)){
				payTime = DateUtil.formatMonth.get().parse(yearMonth);
			}
		} catch (Exception e) {}
		boolean useDefaultIfNull = true;
		BigInteger billTypeId = plotpropertyService.getPropPayBillTypeByGbId(currGroupBuilding.getId(),useDefaultIfNull);
		if(payTime==null){//查询最新的物业账单信息
			payTime = dualDao.getNowDate();
//			monthYearWithGB = plotpropertyService.getBusinessMonthYearByPayTime(userId, payTime, billTypeId);
			if(monthYearWithGB==null){
				Date discountMonthDate = PropertyPeriodCalculateUtil.getDiscountMonthByNowTime(payTime, currGroupBuilding.getPayPeriodEnd());
				monthYearWithGB = BusinessMonthYearFactory.newInstanceByPayTime(discountMonthDate, currGroupBuilding);
			}
		}else{
//			monthYearWithGB = BusinessMonthYearFactory.newInstanceByBillMonth(yearMonth,currGroupBuilding);
			monthYearWithGB = BusinessMonthYearFactory.newInstanceByPayTime(payTime, currGroupBuilding);//2015-12-15 14:18:56账单月份改为折扣月份
		}
		
		//按月份查询对应账单信息
		plotpropertyCombEntity=plotpropertyService.getPayBillByMonth(userId, monthYearWithGB,false,billTypeId);
		PrizeRecordSimpleEntity prizeRecordSimpleEntity = plotpropertyCombEntity.getPrizeRecordSimpleEntity();
		if(prizeRecordSimpleEntity==null&&monthYearWithGB!=null){//最低折扣信息
			prizeRecordSimpleEntity = commonPrizeService.getLeastDiscountFirstByMonthAndUsed(userId, monthYearWithGB);
		}
		
		//3.结果处理
		PlotpropertyCombShowEntity showEntity = PayBillShowUtil.parsePlotpropertyComb(userId, plotpropertyCombEntity, dualDao.getNowTime());
		Map<String,Object> resMap = new HashMap<String, Object>();
		{//折扣相关信息
			BigInteger prizeUserId = null;
			String prizeUserInfo = null;
			
			if(prizeRecordSimpleEntity!=null){
				BigInteger prizeRecordId = prizeRecordSimpleEntity.getId();
				UserSimpleEntity userSimpleEntity = commonPrizeService.getUserByPrizeRecordId(prizeRecordId);
				if(userSimpleEntity!=null){
					prizeUserId = userSimpleEntity.getId();
					prizeUserInfo = UserShowNameUtil.getUserShowName(userSimpleEntity);
				}
			}
			resMap.put("prizeUserId", prizeUserId);//抽取人Id
			resMap.put("prizeUserInfo", prizeUserInfo);//抽取人
			resMap.put("discount", prizeRecordSimpleEntity==null?null:prizeRecordSimpleEntity.getDiscount());//本月最低折扣
			resMap.put("miniDiscount_convert_money", showEntity.fetchMiniDiscountConvertMoney(discount2hbRule, userId));//可兑换粮票所得金额
		}
		
		String payBillAddress = showEntity.getGroupBuildingDetail()==null?"":(showEntity.getGroupBuildingDetail()+showEntity.getRoomDetail());
		resMap.put("payBillAddress", payBillAddress);//缴费地址
		{	//2015-12-15 14:37:39改为折扣月份
			ISectionDateSignal tmp = monthYearWithGB.getDiscountMonth();
			resMap.put("month",tmp.getMonth());
			resMap.put("year",tmp.getYear());
			
			//账单月份
			/*if(billMonth instanceof ISectionDateSignal){
				ISectionDateSignal tmp = (ISectionDateSignal)billMonth;
				resMap.put("month",tmp.getMonth());
				resMap.put("year",tmp.getYear());
			}else if(billMonth instanceof ISectionDateMulti){
				ISectionDateMulti tmp = (ISectionDateMulti)billMonth;
				
			}*/
			
			resMap.put("payLimiteStart",monthYearWithGB.getPayTimeStartDesc());
			resMap.put("payLimiteEnd",monthYearWithGB.getPayTimeEndDesc());
//			StartEndTimeDescEntity currPropStartEndTimeDescEntity = monthYearWithGB.getStartEndTimeDescEntity(DataType.discount);
//			resMap.put("payLimiteStart",currPropStartEndTimeDescEntity==null?null:currPropStartEndTimeDescEntity.getStartDesc());//缴费开始时间
//			resMap.put("payLimiteEnd",currPropStartEndTimeDescEntity==null?null:currPropStartEndTimeDescEntity.getEndDesc());//缴费截止时间
		}
		
		{//物业账单相关信息
			PayBill payBill = plotpropertyCombEntity.getPayBillEntity();
			if(payBill!=null){
				resMap.put("payStatus", showEntity.getPayStatus());//本月是否已缴纳物业
				if(showEntity.getIsBuyFinance() != null && showEntity.getIsBuyFinance() == 1) {
					resMap.put("saveAmount", 0);//使用折扣缴物业可节省的金额
				} else {
					resMap.put("saveAmount", showEntity.getGainMoney()==null?0:PriceUtil.div100(showEntity.getGainMoney()));//使用折扣缴物业可节省的金额
				}
			}else{
				resMap.put("payStatus", PlotpropertyConstant.PlotpropertyMap_PayStatus.notPay);//本月是否已缴纳物业
				resMap.put("saveAmount", 0);//使用折扣缴物业可节省的金额
			}
		}
		
		{//小区相关信息
			boolean signStatus = plotpropertyCombEntity.fetchSignStatus();
			boolean isSupport = plotpropertyCombEntity.fetchIsSupport();
			int totalSupportCount = plotpropertyCombEntity.fetchTotalSupportCount();
			resMap.put("signStatus", signStatus);//签约状态
			resMap.put("isSupport", isSupport);//用户是否已点支持
			resMap.put("totalSupportCount", totalSupportCount);//已经支持解放的用户数
			resMap.put("groupBuildingId", showEntity.getGroupBuildingId());//小区Id	String	
//			resMap.put("timeDistanceLong", 0L);//物业折扣相差时间 折扣月份= 物业账单月份+ timeDistanceLong
			resMap.put("monthDistanceCount", monthYearWithGB.getDistanceDisc2PropMonthCount());//物业折扣月份相差月份数 折扣月份=物业账单月份+相差月份数
			
			//syl-add-2015-7-27 17:10:56是否可以缴纳物业费
			resMap.put("canPayProp", monthYearWithGB.getCanPayProp());//用户是否已点支持
		}
		jsonResponse.setDataValue(resMap);
		return jsonResponse;
	}
	
	/**
	 * 查询粮票使用说明
	 * @param request
	 * @return
	 */
	@RequestMapping("/qryHbUseDesc.json")
	@ResponseBody
	public JsonResponse qryHbUseDesc(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		//2.交互
		String noticeHtml = operationService.getOperationSignalWithDeal(OperationDict.OperationCode.HB_USE_DESC_TXT).getFinalContent();
		CompanyInfoConfig companyInfoConfig = companyService.getCompanyServiceInfo();
		String servicePhone = companyInfoConfig.getServiceTel();
		String qqGroup = companyInfoConfig.getQqGroup();
		//3.结果处理
		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("noticeHtml", noticeHtml);
		resMap.put("servicePhone", servicePhone);
		resMap.put("qqGroup", qqGroup);
		jsonResponse.setDataValue(resMap);
		return jsonResponse;
	}
	
	/**
	 * 查询折扣使用说明
	 * @param request
	 * @return
	 */
	@RequestMapping("/qryDiscountUseDesc.html")
	public ModelAndView qryDiscountUseDesc(HttpServletRequest request){//TODO 异常时的页面跳转的处理
		ModelAndView mav = new ModelAndView();
		//1.搜集参数
		BigInteger userId = UserContext.getOperIdBigInteger();
		//2.交互
		Integer roomVerifyStatus = RoomDict.RoomValidte_VerifyStatus.UNDO;
		boolean isSpecialUser = false;
		if(userId!=null){
			//获取用户当前门牌的验证状态
			RoomEntityWithValidate roomEntityWithValidate = commonRoomService.getDefaultRoomInfo(userId);
			roomVerifyStatus = roomEntityWithValidate.fetchRoomValidteVerifyStatus();
			//是否为特使用户
			isSpecialUser = commonRoomService.getIsSpecialUser(userId);
		}
		Integer showIndex = null;//1.门牌未验证用户 2.门牌通过验证用户 3.解放区特使（或被特使受邀注册者）
		{//设定图标显示位置
			if(roomVerifyStatus.compareTo(RoomDict.RoomValidte_VerifyStatus.UNDO)==0||roomVerifyStatus.compareTo(RoomDict.RoomValidte_VerifyStatus.DOING)==0){
				showIndex = 1;
			}else if(roomVerifyStatus.compareTo(RoomDict.RoomValidte_VerifyStatus.FAILED)==0||roomVerifyStatus.compareTo(RoomDict.RoomValidte_VerifyStatus.SUCCESS)==0){
				showIndex = 2;
			}
			if(isSpecialUser){
				showIndex = 3;
			}
		}
		request.setAttribute("roomVerifyStatus", roomVerifyStatus);
		request.setAttribute("isSpecialUser", isSpecialUser);
		request.setAttribute("showIndex", showIndex);
		
		//3.结果处理
		mav.setViewName("/discountUse/useDescPage");
		return mav;
	}
	
	/**
	 * 查询消费券使用说明
	 * @param request
	 * @return
	 */
	@RequestMapping("/qryConsumeDictUseDesc.json")
	@ResponseBody
	public JsonResponse qryConsumeDictUseDesc(HttpServletRequest request){
		JsonResponse jsonResponse = new JsonResponse();
		//1.搜集参数
		//2.交互
		String noticeHtml = operationService.getOperationSignalWithDeal(OperationDict.OperationCode.ConsumTicket_USE_DESC_TXT).getFinalContent();
		CompanyInfoConfig companyInfoConfig = companyService.getCompanyServiceInfo();
		String servicePhone = companyInfoConfig.getServiceTel();
		String qqGroup = companyInfoConfig.getQqGroup();
		//3.结果处理
		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("noticeHtml", noticeHtml);
		resMap.put("servicePhone", servicePhone);
		resMap.put("qqGroup", qqGroup);
		jsonResponse.setDataValue(resMap);
		return jsonResponse;
	}
	
	private Map<String,Object> familyWealthOptionEntity2Map(FamilyWealthOptionEntity entity){
		String iconBasePath = sysParamManager.getSysParaValue(SysParamKey.FamilyWealth_BaseIconUrl);
		Map<String,Object> tmpMap = new HashMap<String, Object>();
		tmpMap.put("type", entity.getType());//物业费折扣、粮票、消费券、积分
		tmpMap.put("name", entity.getName());
		tmpMap.put("iconUrl", StringUtils.isEmpty(entity.getIconUrl())?FileServerConstant.DEFAULT_NULL_PIC_URL:fileServerService.getAccessUrl(iconBasePath+entity.getIconUrl(),entity));
		tmpMap.put("desc", entity.getDesc());
		tmpMap.put("valueStr", entity.getValueStr());
		tmpMap.put("bottomLeft", entity.getBottomLeft());
		tmpMap.put("bottomRight", entity.getBottomRight());
		if(FamilyWealthDict.FamilyWealthOption_Type.PropertyDiscount.compareTo(entity.getType())==0){
			tmpMap.put("isEmptyRoom", entity.getIsEmptyRoom());//type为物业折扣时使用
		}
		
		return tmpMap;
	}
	
//	private Map<String,Object> wealth2Map(FamilyWealthOptionEntity familyWealthOptionEntity){
//		Map<String,Object> tmpMap = new HashMap<String, Object>();
//		tmpMap.put("type", "1");//物业费折扣、粮票、消费券、积分
//		tmpMap.put("name", "物业费折扣");
//		tmpMap.put("iconUrl", "www.a.com/a.jpg");
//		tmpMap.put("desc", "缴管理费时可打折");
//		tmpMap.put("valueStr", "8.5");
//		tmpMap.put("bottomLeft", "缴管理费时可打折");
//		tmpMap.put("bottomRight", "抽取人:小伙");
//		//tmpMap.put("backGroundPic", "test.jpg");
//		return tmpMap;
//	}
	
	
////1物业费折扣、2粮票、3消费券、4积分
//{
//	Map<String,Object> tmpMap = new HashMap<String, Object>();
//	tmpMap.put("type", "1");
//	tmpMap.put("name", "物业费折扣");
//	tmpMap.put("iconUrl", "www.a.com/a.jpg");
//	tmpMap.put("desc", "缴管理费时可打折");
//	tmpMap.put("valueStr", "8.5");
//	tmpMap.put("bottomLeft", "缴管理费时可打折");
//	tmpMap.put("bottomRight", "抽取人:小伙");
//	//tmpMap.put("backGroundPic", "test.jpg");
//	resList.add(tmpMap);
//}
//{
//	Map<String,Object> tmpMap = new HashMap<String, Object>();
//	tmpMap.put("type", "2");
//	tmpMap.put("name", "粮票");
//	tmpMap.put("iconUrl", "www.a.com/a.jpg");
//	tmpMap.put("desc", "购物可以抵现金");
//	tmpMap.put("valueStr", "79.55");
//	tmpMap.put("bottomLeft", "");
//	tmpMap.put("bottomRight", "");
//	//tmpMap.put("backGroundPic", "test.jpg");
//	resList.add(tmpMap);
//}
//{
//	Map<String,Object> tmpMap = new HashMap<String, Object>();
//	tmpMap.put("type", "3");
//	tmpMap.put("name", "消费券");
//	tmpMap.put("iconUrl", "www.a.com/a.jpg");
//	tmpMap.put("desc", "可在超市购物");
//	tmpMap.put("valueStr", "5");
//	tmpMap.put("bottomLeft", "消费使用时不找零");
//	tmpMap.put("bottomRight", "");
//	//tmpMap.put("backGroundPic", "test.jpg");
//	resList.add(tmpMap);
//}
//{
//	Map<String,Object> tmpMap = new HashMap<String, Object>();
//	tmpMap.put("type", "4");
//	tmpMap.put("name", "积分");
//	tmpMap.put("iconUrl", "www.a.com/a.jpg");
//	tmpMap.put("desc", "每天都能领");
//	tmpMap.put("valueStr", "230");
//	tmpMap.put("bottomLeft", "今天已领取,已经连续领取3天");
//	tmpMap.put("bottomRight", "");
//	//tmpMap.put("backGroundPic", "test.jpg");
//	resList.add(tmpMap);
//}
	
}
