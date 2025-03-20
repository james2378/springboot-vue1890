package com.dao;

import com.entity.ZhuanzhenxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuanzhenxinxiVO;
import com.entity.view.ZhuanzhenxinxiView;


/**
 * 转诊信息
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface ZhuanzhenxinxiDao extends BaseMapper<ZhuanzhenxinxiEntity> {
	
	List<ZhuanzhenxinxiVO> selectListVO(@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);
	
	ZhuanzhenxinxiVO selectVO(@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);
	
	List<ZhuanzhenxinxiView> selectListView(@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);

	List<ZhuanzhenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);
	
	ZhuanzhenxinxiView selectView(@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);
	
}
