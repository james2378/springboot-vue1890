package com.dao;

import com.entity.WeixiufuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiufuwuVO;
import com.entity.view.WeixiufuwuView;


/**
 * 维修服务
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface WeixiufuwuDao extends BaseMapper<WeixiufuwuEntity> {
	
	List<WeixiufuwuVO> selectListVO(@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);
	
	WeixiufuwuVO selectVO(@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);
	
	List<WeixiufuwuView> selectListView(@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);

	List<WeixiufuwuView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);
	
	WeixiufuwuView selectView(@Param("ew") Wrapper<WeixiufuwuEntity> wrapper);
	
}
