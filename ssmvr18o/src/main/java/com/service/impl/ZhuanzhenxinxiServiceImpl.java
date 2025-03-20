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


import com.dao.ZhuanzhenxinxiDao;
import com.entity.ZhuanzhenxinxiEntity;
import com.service.ZhuanzhenxinxiService;
import com.entity.vo.ZhuanzhenxinxiVO;
import com.entity.view.ZhuanzhenxinxiView;

@Service("zhuanzhenxinxiService")
public class ZhuanzhenxinxiServiceImpl extends ServiceImpl<ZhuanzhenxinxiDao, ZhuanzhenxinxiEntity> implements ZhuanzhenxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanzhenxinxiEntity> page = this.selectPage(
                new Query<ZhuanzhenxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhuanzhenxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanzhenxinxiEntity> wrapper) {
		  Page<ZhuanzhenxinxiView> page =new Query<ZhuanzhenxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanzhenxinxiVO> selectListVO(Wrapper<ZhuanzhenxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanzhenxinxiVO selectVO(Wrapper<ZhuanzhenxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanzhenxinxiView> selectListView(Wrapper<ZhuanzhenxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanzhenxinxiView selectView(Wrapper<ZhuanzhenxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
