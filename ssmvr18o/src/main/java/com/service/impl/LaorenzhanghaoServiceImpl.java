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


import com.dao.LaorenzhanghaoDao;
import com.entity.LaorenzhanghaoEntity;
import com.service.LaorenzhanghaoService;
import com.entity.vo.LaorenzhanghaoVO;
import com.entity.view.LaorenzhanghaoView;

@Service("laorenzhanghaoService")
public class LaorenzhanghaoServiceImpl extends ServiceImpl<LaorenzhanghaoDao, LaorenzhanghaoEntity> implements LaorenzhanghaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaorenzhanghaoEntity> page = this.selectPage(
                new Query<LaorenzhanghaoEntity>(params).getPage(),
                new EntityWrapper<LaorenzhanghaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaorenzhanghaoEntity> wrapper) {
		  Page<LaorenzhanghaoView> page =new Query<LaorenzhanghaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaorenzhanghaoVO> selectListVO(Wrapper<LaorenzhanghaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaorenzhanghaoVO selectVO(Wrapper<LaorenzhanghaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaorenzhanghaoView> selectListView(Wrapper<LaorenzhanghaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaorenzhanghaoView selectView(Wrapper<LaorenzhanghaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
