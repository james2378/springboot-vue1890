package com.entity.view;

import com.entity.ShenghuoyongpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 生活用品信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-16 15:09:26
 */
@TableName("shenghuoyongpinxinxi")
public class ShenghuoyongpinxinxiView  extends ShenghuoyongpinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenghuoyongpinxinxiView(){
	}
 
 	public ShenghuoyongpinxinxiView(ShenghuoyongpinxinxiEntity shenghuoyongpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shenghuoyongpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
