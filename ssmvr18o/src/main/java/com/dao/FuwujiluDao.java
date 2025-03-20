package com.dao;

import com.entity.FuwujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FuwujiluVO;
import com.entity.view.FuwujiluView;


/**
 * 服务记录
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface FuwujiluDao extends BaseMapper<FuwujiluEntity> {
	
	List<FuwujiluVO> selectListVO(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
	
	FuwujiluVO selectVO(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
	
	List<FuwujiluView> selectListView(@Param("ew") Wrapper<FuwujiluEntity> wrapper);

	List<FuwujiluView> selectListView(Pagination page,@Param("ew") Wrapper<FuwujiluEntity> wrapper);
	
	FuwujiluView selectView(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
	
}
