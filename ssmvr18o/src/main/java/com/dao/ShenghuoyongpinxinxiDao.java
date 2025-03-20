package com.dao;

import com.entity.ShenghuoyongpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenghuoyongpinxinxiVO;
import com.entity.view.ShenghuoyongpinxinxiView;


/**
 * 生活用品信息
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:26
 */
public interface ShenghuoyongpinxinxiDao extends BaseMapper<ShenghuoyongpinxinxiEntity> {
	
	List<ShenghuoyongpinxinxiVO> selectListVO(@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
	
	ShenghuoyongpinxinxiVO selectVO(@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
	
	List<ShenghuoyongpinxinxiView> selectListView(@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);

	List<ShenghuoyongpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
	
	ShenghuoyongpinxinxiView selectView(@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
	
}
