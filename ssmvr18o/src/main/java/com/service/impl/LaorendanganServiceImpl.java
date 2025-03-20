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


import com.dao.LaorendanganDao;
import com.entity.LaorendanganEntity;
import com.service.LaorendanganService;
import com.entity.vo.LaorendanganVO;
import com.entity.view.LaorendanganView;

@Service("laorendanganService")
public class LaorendanganServiceImpl extends ServiceImpl<LaorendanganDao, LaorendanganEntity> implements LaorendanganService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaorendanganEntity> page = this.selectPage(
                new Query<LaorendanganEntity>(params).getPage(),
                new EntityWrapper<LaorendanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaorendanganEntity> wrapper) {
		  Page<LaorendanganView> page =new Query<LaorendanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaorendanganVO> selectListVO(Wrapper<LaorendanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaorendanganVO selectVO(Wrapper<LaorendanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaorendanganView> selectListView(Wrapper<LaorendanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaorendanganView selectView(Wrapper<LaorendanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
