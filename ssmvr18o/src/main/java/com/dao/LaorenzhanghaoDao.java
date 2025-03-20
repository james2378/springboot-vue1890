package com.dao;

import com.entity.LaorenzhanghaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaorenzhanghaoVO;
import com.entity.view.LaorenzhanghaoView;


/**
 * 老人账号
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface LaorenzhanghaoDao extends BaseMapper<LaorenzhanghaoEntity> {
	
	List<LaorenzhanghaoVO> selectListVO(@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);
	
	LaorenzhanghaoVO selectVO(@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);
	
	List<LaorenzhanghaoView> selectListView(@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);

	List<LaorenzhanghaoView> selectListView(Pagination page,@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);
	
	LaorenzhanghaoView selectView(@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);
	
}
