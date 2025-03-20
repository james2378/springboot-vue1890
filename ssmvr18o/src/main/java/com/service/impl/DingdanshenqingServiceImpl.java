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


import com.dao.DingdanshenqingDao;
import com.entity.DingdanshenqingEntity;
import com.service.DingdanshenqingService;
import com.entity.vo.DingdanshenqingVO;
import com.entity.view.DingdanshenqingView;

@Service("dingdanshenqingService")
public class DingdanshenqingServiceImpl extends ServiceImpl<DingdanshenqingDao, DingdanshenqingEntity> implements DingdanshenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanshenqingEntity> page = this.selectPage(
                new Query<DingdanshenqingEntity>(params).getPage(),
                new EntityWrapper<DingdanshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanshenqingEntity> wrapper) {
		  Page<DingdanshenqingView> page =new Query<DingdanshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DingdanshenqingVO> selectListVO(Wrapper<DingdanshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanshenqingVO selectVO(Wrapper<DingdanshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanshenqingView> selectListView(Wrapper<DingdanshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanshenqingView selectView(Wrapper<DingdanshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
