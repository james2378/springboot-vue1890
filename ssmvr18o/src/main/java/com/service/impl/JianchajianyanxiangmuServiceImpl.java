package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JianchajianyanxiangmuDao;
import com.entity.JianchajianyanxiangmuEntity;
import com.service.JianchajianyanxiangmuService;
import com.entity.vo.JianchajianyanxiangmuVO;
import com.entity.view.JianchajianyanxiangmuView;

@Service("jianchajianyanxiangmuService")
public class JianchajianyanxiangmuServiceImpl extends ServiceImpl<JianchajianyanxiangmuDao, JianchajianyanxiangmuEntity> implements JianchajianyanxiangmuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianchajianyanxiangmuEntity> page = this.selectPage(
                new Query<JianchajianyanxiangmuEntity>(params).getPage(),
                new EntityWrapper<JianchajianyanxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianchajianyanxiangmuEntity> wrapper) {
		  Page<JianchajianyanxiangmuView> page =new Query<JianchajianyanxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JianchajianyanxiangmuVO> selectListVO(Wrapper<JianchajianyanxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianchajianyanxiangmuVO selectVO(Wrapper<JianchajianyanxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianchajianyanxiangmuView> selectListView(Wrapper<JianchajianyanxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianchajianyanxiangmuView selectView(Wrapper<JianchajianyanxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
