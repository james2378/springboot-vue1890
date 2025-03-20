package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenghuoyongpinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenghuoyongpinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenghuoyongpinxinxiView;


/**
 * 生活用品信息
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:26
 */
public interface ShenghuoyongpinxinxiService extends IService<ShenghuoyongpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenghuoyongpinxinxiVO> selectListVO(Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
   	
   	ShenghuoyongpinxinxiVO selectVO(@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
   	
   	List<ShenghuoyongpinxinxiView> selectListView(Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
   	
   	ShenghuoyongpinxinxiView selectView(@Param("ew") Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenghuoyongpinxinxiEntity> wrapper);
   	
}

