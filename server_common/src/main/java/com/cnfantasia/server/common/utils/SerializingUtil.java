/**   
 * Filename:    SerializingUtil.java   
 * @version:    1.0  
 * Create at:   2015年7月8日 上午2:52:49   
 * Description:  
 *   
 * Modification History:   
 * Date        Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年7月8日    shiyl      1.0         1.0 Version   
 */
package com.cnfantasia.server.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Filename:    SerializingUtil.java
 * @version:    1.0.0
 * Create at:   2015年7月8日 上午2:52:49
 * Description:
 *
 * Modification History:
 * Date           Author           Version           Description
 * ------------------------------------------------------------------
 * 2015年7月8日       shiyl             1.0             1.0 Version
 */
/**
 * 功能简述: 序列化工具类，负责byte[]和Object之间的相互转换.
 * 
 * @author Nick Xu
 * @version 1.0
 */
public class SerializingUtil {

	private static Log logger = LogFactory.getLog(SerializingUtil.class);

	/**
	 * 功能简述: 对实体Bean进行序列化操作.
	 * 
	 * @param source
	 *          待转换的实体
	 * @return 转换之后的字节数组
	 * @throws Exception
	 */
	public static byte[] serialize(Object source) {
		ByteArrayOutputStream byteOut = null;
		ObjectOutputStream ObjOut = null;
		try {
			byteOut = new ByteArrayOutputStream();
			ObjOut = new ObjectOutputStream(byteOut);
			ObjOut.writeObject(source);
			ObjOut.flush();
		} catch (IOException e) {
			logger.error(source.getClass().getName() + " serialized error !", e);
		} finally {
			try {
				if (null != ObjOut) {
					ObjOut.close();
				}
			} catch (IOException e) {
				ObjOut = null;
			}
		}
		return byteOut.toByteArray();
	}

	/**
	 * 功能简述: 将字节数组反序列化为实体Bean.
	 * 
	 * @param source
	 *          需要进行反序列化的字节数组
	 * @return 反序列化后的实体Bean
	 * @throws Exception
	 */
	public static Object deserialize(byte[] source) {
		ObjectInputStream ObjIn = null;
		Object retVal = null;
		try {
			ByteArrayInputStream byteIn = new ByteArrayInputStream(source);
			ObjIn = new ObjectInputStream(byteIn);
			retVal = ObjIn.readObject();
		} catch (Exception e) {
			logger.error("deserialized error  !", e);
		} finally {
			try {
				if (null != ObjIn) {
					ObjIn.close();
				}
			} catch (IOException e) {
				ObjIn = null;
			}
		}
		return retVal;
	}

//	public static void main(String[] args) {
//		// 对JavaBean的存储和获取：定义实体：借助于Timestamp类，获取ms值。
//
//		Userinfo actual = new Userinfo(140520, "Nick Xu", new Date(Timestamp.valueOf("1990-11-11 00:00:00").getTime()));
//
//		// 使用Jedis操作：key、value都需要转成byte[]字节数组。
//
//		String key = "user.userid." + actual.getUserId();
//		jedis.set(key.getBytes(), SerializingUtil.serialize(actual));
//		Userinfo expected = (Userinfo) SerializingUtil.deserialize(jedis.get(key.getBytes()));
//
//		// 对象的比较：需要覆写equals和hashCode方法。
//
//		assertEquals(expected, actual);
//	}
	
}
