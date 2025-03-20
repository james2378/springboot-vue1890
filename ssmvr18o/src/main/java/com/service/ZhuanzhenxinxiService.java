package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanzhenxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuanzhenxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanzhenxinxiView;


/**
 * 转诊信息
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface ZhuanzhenxinxiService extends IService<ZhuanzhenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanzhenxinxiVO> selectListVO(Wrapper<ZhuanzhenxinxiEntity> wrapper);
   	
   	ZhuanzhenxinxiVO selectVO(@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);
   	
   	List<ZhuanzhenxinxiView> selectListView(Wrapper<ZhuanzhenxinxiEntity> wrapper);
   	
   	ZhuanzhenxinxiView selectView(@Param("ew") Wrapper<ZhuanzhenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanzhenxinxiEntity> wrapper);
   	
}

