package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenghuofuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenghuofuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenghuofuwuView;


/**
 * 生活服务
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface ShenghuofuwuService extends IService<ShenghuofuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenghuofuwuVO> selectListVO(Wrapper<ShenghuofuwuEntity> wrapper);
   	
   	ShenghuofuwuVO selectVO(@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);
   	
   	List<ShenghuofuwuView> selectListView(Wrapper<ShenghuofuwuEntity> wrapper);
   	
   	ShenghuofuwuView selectView(@Param("ew") Wrapper<ShenghuofuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenghuofuwuEntity> wrapper);
   	
}

