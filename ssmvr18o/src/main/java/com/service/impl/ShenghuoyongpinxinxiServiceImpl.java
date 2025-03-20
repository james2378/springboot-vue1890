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


import com.dao.ShenghuoyongpinxinxiDao;
import com.entity.ShenghuoyongpinxinxiEntity;
import com.service.ShenghuoyongpinxinxiService;
import com.entity.vo.ShenghuoyongpinxinxiVO;
import com.entity.view.ShenghuoyongpinxinxiView;

@Service("shenghuoyongpinxinxiService")
public class ShenghuoyongpinxinxiServiceImpl extends ServiceImpl<ShenghuoyongpinxinxiDao, ShenghuoyongpinxinxiEntity> implements ShenghuoyongpinxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenghuoyongpinxinxiEntity> page = this.selectPage(
                new Query<ShenghuoyongpinxinxiEntity>(params).getPage(),
                new EntityWrapper<ShenghuoyongpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenghuoyongpinxinxiEntity> wrapper) {
		  Page<ShenghuoyongpinxinxiView> page =new Query<ShenghuoyongpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenghuoyongpinxinxiVO> selectListVO(Wrapper<ShenghuoyongpinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenghuoyongpinxinxiVO selectVO(Wrapper<ShenghuoyongpinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenghuoyongpinxinxiView> selectListView(Wrapper<ShenghuoyongpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenghuoyongpinxinxiView selectView(Wrapper<ShenghuoyongpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
