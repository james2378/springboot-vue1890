package com.dao;

import com.entity.ShiwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShiwuxinxiVO;
import com.entity.view.ShiwuxinxiView;


/**
 * 食物信息
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:26
 */
public interface ShiwuxinxiDao extends BaseMapper<ShiwuxinxiEntity> {
	
	List<ShiwuxinxiVO> selectListVO(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
	
	ShiwuxinxiVO selectVO(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
	
	List<ShiwuxinxiView> selectListView(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);

	List<ShiwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
	
	ShiwuxinxiView selectView(@Param("ew") Wrapper<ShiwuxinxiEntity> wrapper);
	
}
