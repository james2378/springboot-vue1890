package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiwuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShiwuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwuxinxiView;


/**
 * 食物信息
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:26
 */
public interface ShiwuxinxiService extends IService<ShiwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiwuxinxiVO> selectListVO(Wrapper<ShiwuxinxiEntity> wrapper);
   	
   	ShiwuxinxiVO selectVO(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
   	
   	List<ShiwuxinxiView> selectListView(Wrapper<ShiwuxinxiEntity> wrapper);
   	
   	ShiwuxinxiView selectView(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiwuxinxiEntity> wrapper);
   	
}

