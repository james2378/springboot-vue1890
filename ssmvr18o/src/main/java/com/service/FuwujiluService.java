package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwujiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwujiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwujiluView;


/**
 * 服务记录
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface FuwujiluService extends IService<FuwujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwujiluVO> selectListVO(Wrapper<FuwujiluEntity> wrapper);
   	
   	FuwujiluVO selectVO(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
   	
   	List<FuwujiluView> selectListView(Wrapper<FuwujiluEntity> wrapper);
   	
   	FuwujiluView selectView(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwujiluEntity> wrapper);
   	
}

