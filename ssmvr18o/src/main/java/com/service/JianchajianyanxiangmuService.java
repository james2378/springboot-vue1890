package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianchajianyanxiangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianchajianyanxiangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianchajianyanxiangmuView;


/**
 * 检查检验项目
 *
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public interface JianchajianyanxiangmuService extends IService<JianchajianyanxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianchajianyanxiangmuVO> selectListVO(Wrapper<JianchajianyanxiangmuEntity> wrapper);
   	
   	JianchajianyanxiangmuVO selectVO(@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);
   	
   	List<JianchajianyanxiangmuView> selectListView(Wrapper<JianchajianyanxiangmuEntity> wrapper);
   	
   	JianchajianyanxiangmuView selectView(@Param("ew") Wrapper<JianchajianyanxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianchajianyanxiangmuEntity> wrapper);
   	
}

