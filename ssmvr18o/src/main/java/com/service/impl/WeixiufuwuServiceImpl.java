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


import com.dao.WeixiufuwuDao;
import com.entity.WeixiufuwuEntity;
import com.service.WeixiufuwuService;
import com.entity.vo.WeixiufuwuVO;
import com.entity.view.WeixiufuwuView;

@Service("weixiufuwuService")
public class WeixiufuwuServiceImpl extends ServiceImpl<WeixiufuwuDao, WeixiufuwuEntity> implements WeixiufuwuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiufuwuEntity> page = this.selectPage(
                new Query<WeixiufuwuEntity>(params).getPage(),
                new EntityWrapper<WeixiufuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiufuwuEntity> wrapper) {
		  Page<WeixiufuwuView> page =new Query<WeixiufuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiufuwuVO> selectListVO(Wrapper<WeixiufuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiufuwuVO selectVO(Wrapper<WeixiufuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiufuwuView> selectListView(Wrapper<WeixiufuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiufuwuView selectView(Wrapper<WeixiufuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
