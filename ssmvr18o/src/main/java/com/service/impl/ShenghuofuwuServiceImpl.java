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


import com.dao.ShenghuofuwuDao;
import com.entity.ShenghuofuwuEntity;
import com.service.ShenghuofuwuService;
import com.entity.vo.ShenghuofuwuVO;
import com.entity.view.ShenghuofuwuView;

@Service("shenghuofuwuService")
public class ShenghuofuwuServiceImpl extends ServiceImpl<ShenghuofuwuDao, ShenghuofuwuEntity> implements ShenghuofuwuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenghuofuwuEntity> page = this.selectPage(
                new Query<ShenghuofuwuEntity>(params).getPage(),
                new EntityWrapper<ShenghuofuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenghuofuwuEntity> wrapper) {
		  Page<ShenghuofuwuView> page =new Query<ShenghuofuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenghuofuwuVO> selectListVO(Wrapper<ShenghuofuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenghuofuwuVO selectVO(Wrapper<ShenghuofuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenghuofuwuView> selectListView(Wrapper<ShenghuofuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenghuofuwuView selectView(Wrapper<ShenghuofuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
