package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JianchajianyanxiangmuEntity;
import com.entity.view.JianchajianyanxiangmuView;

import com.service.JianchajianyanxiangmuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 检查检验项目
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
@RestController
@RequestMapping("/jianchajianyanxiangmu")
public class JianchajianyanxiangmuController {
    @Autowired
    private JianchajianyanxiangmuService jianchajianyanxiangmuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianchajianyanxiangmuEntity jianchajianyanxiangmu, 
		HttpServletRequest request){

        EntityWrapper<JianchajianyanxiangmuEntity> ew = new EntityWrapper<JianchajianyanxiangmuEntity>();
		PageUtils page = jianchajianyanxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchajianyanxiangmu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianchajianyanxiangmuEntity jianchajianyanxiangmu, HttpServletRequest request){
        EntityWrapper<JianchajianyanxiangmuEntity> ew = new EntityWrapper<JianchajianyanxiangmuEntity>();
		PageUtils page = jianchajianyanxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianchajianyanxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianchajianyanxiangmuEntity jianchajianyanxiangmu){
       	EntityWrapper<JianchajianyanxiangmuEntity> ew = new EntityWrapper<JianchajianyanxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianchajianyanxiangmu, "jianchajianyanxiangmu")); 
        return R.ok().put("data", jianchajianyanxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianchajianyanxiangmuEntity jianchajianyanxiangmu){
        EntityWrapper< JianchajianyanxiangmuEntity> ew = new EntityWrapper< JianchajianyanxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianchajianyanxiangmu, "jianchajianyanxiangmu")); 
		JianchajianyanxiangmuView jianchajianyanxiangmuView =  jianchajianyanxiangmuService.selectView(ew);
		return R.ok("查询检查检验项目成功").put("data", jianchajianyanxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianchajianyanxiangmuEntity jianchajianyanxiangmu = jianchajianyanxiangmuService.selectById(id);
        return R.ok().put("data", jianchajianyanxiangmu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianchajianyanxiangmuEntity jianchajianyanxiangmu = jianchajianyanxiangmuService.selectById(id);
        return R.ok().put("data", jianchajianyanxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianchajianyanxiangmuEntity jianchajianyanxiangmu, HttpServletRequest request){
    	jianchajianyanxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchajianyanxiangmu);

        jianchajianyanxiangmuService.insert(jianchajianyanxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianchajianyanxiangmuEntity jianchajianyanxiangmu, HttpServletRequest request){
    	jianchajianyanxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianchajianyanxiangmu);

        jianchajianyanxiangmuService.insert(jianchajianyanxiangmu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JianchajianyanxiangmuEntity jianchajianyanxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianchajianyanxiangmu);
        jianchajianyanxiangmuService.updateById(jianchajianyanxiangmu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianchajianyanxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JianchajianyanxiangmuEntity> wrapper = new EntityWrapper<JianchajianyanxiangmuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jianchajianyanxiangmuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
