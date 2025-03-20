package com.dao;

import com.entity.DingdanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanshenqingVO;
import com.entity.view.DingdanshenqingView;


/**
 * 订单申请
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface DingdanshenqingDao extends BaseMapper<DingdanshenqingEntity> {
	
	List<DingdanshenqingVO> selectListVO(@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);
	
	DingdanshenqingVO selectVO(@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);
	
	List<DingdanshenqingView> selectListView(@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);

	List<DingdanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);
	
	DingdanshenqingView selectView(@Param("ew") Wrapper<DingdanshenqingEntity> wrapper);
	
}
