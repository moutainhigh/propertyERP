package com.cnfantasia.server.domainbase.ebuyProductHasTEbuyAuth.entity;

/* import java.io.Serializable;*/
import java.math.BigInteger;import java.lang.String;import java.lang.Integer;
 import com.cnfantasia.server.domain.pub.BaseEntity;
/**
 * 描述:() 实体类
 * 
 * @version 1.00
 * @author null
 * 
 */
/*
public class EbuyProductHasTEbuyAuth implements Serializable{
*/


public class EbuyProductHasTEbuyAuth extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**  */	private BigInteger id;	/**  */	private BigInteger tEbuyProductFId;	/**  */	private BigInteger tEbuyAuthFId;	/** 产品图片认证url */	private String authDetailImg;
	public EbuyProductHasTEbuyAuth(){
	}
	public EbuyProductHasTEbuyAuth(EbuyProductHasTEbuyAuth arg){
		this.id = arg.getId();		this.tEbuyProductFId = arg.gettEbuyProductFId();		this.tEbuyAuthFId = arg.gettEbuyAuthFId();		this.authDetailImg = arg.getAuthDetailImg();		this.sys0AddTime = arg.getSys0AddTime();		this.sys0UpdTime = arg.getSys0UpdTime();		this.sys0DelTime = arg.getSys0DelTime();		this.sys0AddUser = arg.getSys0AddUser();		this.sys0UpdUser = arg.getSys0UpdUser();		this.sys0DelUser = arg.getSys0DelUser();		this.sys0DelState = arg.getSys0DelState();
	}
	/**	 * 	 * @param id 	 * @param tEbuyProductFId 	 * @param tEbuyAuthFId 	 * @param authDetailImg 产品图片认证url	 * @param sys0AddTime 新增时间	 * @param sys0UpdTime 更新时间	 * @param sys0DelTime 删除时间	 * @param sys0AddUser 新增者	 * @param sys0UpdUser 修改者	 * @param sys0DelUser 删除者	 * @param sys0DelState 记录状态	 */
	public EbuyProductHasTEbuyAuth(BigInteger id,BigInteger tEbuyProductFId,BigInteger tEbuyAuthFId,String authDetailImg,String sys0AddTime,String sys0UpdTime,String sys0DelTime,BigInteger sys0AddUser,BigInteger sys0UpdUser,BigInteger sys0DelUser,Integer sys0DelState){
		this.id = id;		this.tEbuyProductFId = tEbuyProductFId;		this.tEbuyAuthFId = tEbuyAuthFId;		this.authDetailImg = authDetailImg;		this.sys0AddTime = sys0AddTime;		this.sys0UpdTime = sys0UpdTime;		this.sys0DelTime = sys0DelTime;		this.sys0AddUser = sys0AddUser;		this.sys0UpdUser = sys0UpdUser;		this.sys0DelUser = sys0DelUser;		this.sys0DelState = sys0DelState;
	}

	@Override
	public String toString() {
		StringBuffer sbf = new StringBuffer();		sbf.append("id=").append(id).append(";");		sbf.append("tEbuyProductFId=").append(tEbuyProductFId).append(";");		sbf.append("tEbuyAuthFId=").append(tEbuyAuthFId).append(";");		sbf.append("authDetailImg=").append(authDetailImg).append(";");		sbf.append("sys0AddTime=").append(sys0AddTime).append(";");		sbf.append("sys0UpdTime=").append(sys0UpdTime).append(";");		sbf.append("sys0DelTime=").append(sys0DelTime).append(";");		sbf.append("sys0AddUser=").append(sys0AddUser).append(";");		sbf.append("sys0UpdUser=").append(sys0UpdUser).append(";");		sbf.append("sys0DelUser=").append(sys0DelUser).append(";");		sbf.append("sys0DelState=").append(sys0DelState).append(";");		return sbf.toString();
	}
	
	public BigInteger getId() {		return id;	}	public void setId(BigInteger id) {		this.id = id;	}	public BigInteger gettEbuyProductFId() {		return tEbuyProductFId;	}	public void settEbuyProductFId(BigInteger tEbuyProductFId) {		this.tEbuyProductFId = tEbuyProductFId;	}	public BigInteger gettEbuyAuthFId() {		return tEbuyAuthFId;	}	public void settEbuyAuthFId(BigInteger tEbuyAuthFId) {		this.tEbuyAuthFId = tEbuyAuthFId;	}	public String getAuthDetailImg() {		return authDetailImg;	}	public void setAuthDetailImg(String authDetailImg) {		this.authDetailImg = authDetailImg;	}
	
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
		EbuyProductHasTEbuyAuth other = (EbuyProductHasTEbuyAuth) obj;
		if (id == null) {			if (other.id != null)				return false;		} else if (!id.equals(other.id))			return false;
		return true;
	}
	
}
