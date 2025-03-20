package com.dao;

import com.entity.LaorendanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaorendanganVO;
import com.entity.view.LaorendanganView;


/**
 * 老人档案
 * 
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface LaorendanganDao extends BaseMapper<LaorendanganEntity> {
	
	List<LaorendanganVO> selectListVO(@Param("ew") Wrapper<LaorendanganEntity> wrapper);
	
	LaorendanganVO selectVO(@Param("ew") Wrapper<LaorendanganEntity> wrapper);
	
	List<LaorendanganView> selectListView(@Param("ew") Wrapper<LaorendanganEntity> wrapper);

	List<LaorendanganView> selectListView(Pagination page,@Param("ew") Wrapper<LaorendanganEntity> wrapper);
	
	LaorendanganView selectView(@Param("ew") Wrapper<LaorendanganEntity> wrapper);
	
}
