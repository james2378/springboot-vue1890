package com.dao;

import com.entity.ShenghuofuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenghuofuwuVO;
import com.entity.view.ShenghuofuwuView;


/**
 * 生活服务
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface ShenghuofuwuDao extends BaseMapper<ShenghuofuwuEntity> {
	
	List<ShenghuofuwuVO> selectListVO(@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);
	
	ShenghuofuwuVO selectVO(@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);
	
	List<ShenghuofuwuView> selectListView(@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);

	List<ShenghuofuwuView> selectListView(Pagination page,@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);
	
	ShenghuofuwuView selectView(@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);
	
}
