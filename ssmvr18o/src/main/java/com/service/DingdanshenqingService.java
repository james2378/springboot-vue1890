package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanshenqingView;


/**
 * 订单申请
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface DingdanshenqingService extends IService<DingdanshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanshenqingVO> selectListVO(Wrapper<DingdanshenqingEntity> wrapper);
   	
   	DingdanshenqingVO selectVO(@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);
   	
   	List<DingdanshenqingView> selectListView(Wrapper<DingdanshenqingEntity> wrapper);
   	
   	DingdanshenqingView selectView(@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanshenqingEntity> wrapper);
   	
}

