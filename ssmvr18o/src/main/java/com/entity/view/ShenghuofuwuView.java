package com.entity.view;

import com.entity.ShenghuofuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 生活服务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
@TableName("shenghuofuwu")
public class ShenghuofuwuView  extends ShenghuofuwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenghuofuwuView(){
	}
 
 	public ShenghuofuwuView(ShenghuofuwuEntity shenghuofuwuEntity){
 	try {
			BeanUtils.copyProperties(this, shenghuofuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
