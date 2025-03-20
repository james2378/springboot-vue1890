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


import com.dao.FuwujiluDao;
import com.entity.FuwujiluEntity;
import com.service.FuwujiluService;
import com.entity.vo.FuwujiluVO;
import com.entity.view.FuwujiluView;

@Service("fuwujiluService")
public class FuwujiluServiceImpl extends ServiceImpl<FuwujiluDao, FuwujiluEntity> implements FuwujiluService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwujiluEntity> page = this.selectPage(
                new Query<FuwujiluEntity>(params).getPage(),
                new EntityWrapper<FuwujiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwujiluEntity> wrapper) {
		  Page<FuwujiluView> page =new Query<FuwujiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FuwujiluVO> selectListVO(Wrapper<FuwujiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwujiluVO selectVO(Wrapper<FuwujiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwujiluView> selectListView(Wrapper<FuwujiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwujiluView selectView(Wrapper<FuwujiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
