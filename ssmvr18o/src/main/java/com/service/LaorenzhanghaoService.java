package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaorenzhanghaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaorenzhanghaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaorenzhanghaoView;


/**
 * 老人账号
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface LaorenzhanghaoService extends IService<LaorenzhanghaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaorenzhanghaoVO> selectListVO(Wrapper<LaorenzhanghaoEntity> wrapper);
   	
   	LaorenzhanghaoVO selectVO(@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);
   	
   	List<LaorenzhanghaoView> selectListView(Wrapper<LaorenzhanghaoEntity> wrapper);
   	
   	LaorenzhanghaoView selectView(@Param("ew") Wrapper<LaorenzhanghaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaorenzhanghaoEntity> wrapper);
   	
}

