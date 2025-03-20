package com.dao;

import com.entity.JianchajianyanxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianchajianyanxiangmuVO;
import com.entity.view.JianchajianyanxiangmuView;


/**
 * 检查检验项目
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface JianchajianyanxiangmuDao extends BaseMapper<JianchajianyanxiangmuEntity> {
	
	List<JianchajianyanxiangmuVO> selectListVO(@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);
	
	JianchajianyanxiangmuVO selectVO(@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);
	
	List<JianchajianyanxiangmuView> selectListView(@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);

	List<JianchajianyanxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);
	
	JianchajianyanxiangmuView selectView(@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);
	
}
