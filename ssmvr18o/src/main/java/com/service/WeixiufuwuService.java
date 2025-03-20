package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiufuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiufuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiufuwuView;


/**
 * 维修服务
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface WeixiufuwuService extends IService<WeixiufuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiufuwuVO> selectListVO(Wrapper<WeixiufuwuEntity> wrapper);
   	
   	WeixiufuwuVO selectVO(@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);
   	
   	List<WeixiufuwuView> selectListView(Wrapper<WeixiufuwuEntity> wrapper);
   	
   	WeixiufuwuView selectView(@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiufuwuEntity> wrapper);
   	
}

