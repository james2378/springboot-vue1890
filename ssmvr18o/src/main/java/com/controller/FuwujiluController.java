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

import com.entity.FuwujiluEntity;
import com.entity.view.FuwujiluView;

import com.service.FuwujiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 服务记录
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
@RestController
@RequestMapping("/fuwujilu")
public class FuwujiluController {
    @Autowired
    private FuwujiluService fuwujiluService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwujiluEntity fuwujilu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laorenzhanghao")) {
			fuwujilu.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongzuorenyuan")) {
			fuwujilu.setRenyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();
		PageUtils page = fuwujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwujilu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwujiluEntity fuwujilu, HttpServletRequest request){
        EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();
		PageUtils page = fuwujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwujilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwujiluEntity fuwujilu){
       	EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwujilu, "fuwujilu")); 
        return R.ok().put("data", fuwujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwujiluEntity fuwujilu){
        EntityWrapper< FuwujiluEntity> ew = new EntityWrapper< FuwujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwujilu, "fuwujilu")); 
		FuwujiluView fuwujiluView =  fuwujiluService.selectView(ew);
		return R.ok("查询服务记录成功").put("data", fuwujiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        return R.ok().put("data", fuwujilu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        return R.ok().put("data", fuwujilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
    	fuwujilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwujilu);

        fuwujiluService.insert(fuwujilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
    	fuwujilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwujilu);

        fuwujiluService.insert(fuwujilu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwujilu);
        fuwujiluService.updateById(fuwujilu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwujiluService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<FuwujiluEntity> wrapper = new EntityWrapper<FuwujiluEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laorenzhanghao")) {
			wrapper.eq("laorenzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongzuorenyuan")) {
			wrapper.eq("renyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = fuwujiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
