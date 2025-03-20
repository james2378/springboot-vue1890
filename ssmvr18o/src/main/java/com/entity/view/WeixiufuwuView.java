package com.entity.view;

import com.entity.WeixiufuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 维修服务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
@TableName("weixiufuwu")
public class WeixiufuwuView  extends WeixiufuwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiufuwuView(){
	}
 
 	public WeixiufuwuView(WeixiufuwuEntity weixiufuwuEntity){
 	try {
			BeanUtils.copyProperties(this, weixiufuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
