package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 转诊信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
@TableName("zhuanzhenxinxi")
public class ZhuanzhenxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhuanzhenxinxiEntity() {
		
	}
	
	public ZhuanzhenxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 老人账号
	 */
					
	private String laorenzhanghao;
	
	/**
	 * 老人姓名
	 */
					
	private String laorenxingming;
	
	/**
	 * 老人性别
	 */
					
	private String laorenxingbie;
	
	/**
	 * 老人年龄
	 */
					
	private String laorennianling;
	
	/**
	 * 老人照片
	 */
					
	private String laorenzhaopian;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 联系地址
	 */
					
	private String lianxidizhi;
	
	/**
	 * 转诊原因
	 */
					
	private String zhuanzhenyuanyin;
	
	/**
	 * 主要现病史
	 */
					
	private String zhuyaoxianbingshi;
	
	/**
	 * 既往病史
	 */
					
	private String jiwangbingshi;
	
	/**
	 * 病例
	 */
					
	private String bingli;
	
	/**
	 * 日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date riqi;
	
	/**
	 * 原医院
	 */
					
	private String yuanyiyuan;
	
	/**
	 * 现医院
	 */
					
	private String xianyiyuan;
	
	/**
	 * 转诊医院
	 */
					
	private String zhuanzhenyiyuan;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：老人账号
	 */
	public void setLaorenzhanghao(String laorenzhanghao) {
		this.laorenzhanghao = laorenzhanghao;
	}
	/**
	 * 获取：老人账号
	 */
	public String getLaorenzhanghao() {
		return laorenzhanghao;
	}
	/**
	 * 设置：老人姓名
	 */
	public void setLaorenxingming(String laorenxingming) {
		this.laorenxingming = laorenxingming;
	}
	/**
	 * 获取：老人姓名
	 */
	public String getLaorenxingming() {
		return laorenxingming;
	}
	/**
	 * 设置：老人性别
	 */
	public void setLaorenxingbie(String laorenxingbie) {
		this.laorenxingbie = laorenxingbie;
	}
	/**
	 * 获取：老人性别
	 */
	public String getLaorenxingbie() {
		return laorenxingbie;
	}
	/**
	 * 设置：老人年龄
	 */
	public void setLaorennianling(String laorennianling) {
		this.laorennianling = laorennianling;
	}
	/**
	 * 获取：老人年龄
	 */
	public String getLaorennianling() {
		return laorennianling;
	}
	/**
	 * 设置：老人照片
	 */
	public void setLaorenzhaopian(String laorenzhaopian) {
		this.laorenzhaopian = laorenzhaopian;
	}
	/**
	 * 获取：老人照片
	 */
	public String getLaorenzhaopian() {
		return laorenzhaopian;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：联系地址
	 */
	public void setLianxidizhi(String lianxidizhi) {
		this.lianxidizhi = lianxidizhi;
	}
	/**
	 * 获取：联系地址
	 */
	public String getLianxidizhi() {
		return lianxidizhi;
	}
	/**
	 * 设置：转诊原因
	 */
	public void setZhuanzhenyuanyin(String zhuanzhenyuanyin) {
		this.zhuanzhenyuanyin = zhuanzhenyuanyin;
	}
	/**
	 * 获取：转诊原因
	 */
	public String getZhuanzhenyuanyin() {
		return zhuanzhenyuanyin;
	}
	/**
	 * 设置：主要现病史
	 */
	public void setZhuyaoxianbingshi(String zhuyaoxianbingshi) {
		this.zhuyaoxianbingshi = zhuyaoxianbingshi;
	}
	/**
	 * 获取：主要现病史
	 */
	public String getZhuyaoxianbingshi() {
		return zhuyaoxianbingshi;
	}
	/**
	 * 设置：既往病史
	 */
	public void setJiwangbingshi(String jiwangbingshi) {
		this.jiwangbingshi = jiwangbingshi;
	}
	/**
	 * 获取：既往病史
	 */
	public String getJiwangbingshi() {
		return jiwangbingshi;
	}
	/**
	 * 设置：病例
	 */
	public void setBingli(String bingli) {
		this.bingli = bingli;
	}
	/**
	 * 获取：病例
	 */
	public String getBingli() {
		return bingli;
	}
	/**
	 * 设置：日期
	 */
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
	/**
	 * 设置：原医院
	 */
	public void setYuanyiyuan(String yuanyiyuan) {
		this.yuanyiyuan = yuanyiyuan;
	}
	/**
	 * 获取：原医院
	 */
	public String getYuanyiyuan() {
		return yuanyiyuan;
	}
	/**
	 * 设置：现医院
	 */
	public void setXianyiyuan(String xianyiyuan) {
		this.xianyiyuan = xianyiyuan;
	}
	/**
	 * 获取：现医院
	 */
	public String getXianyiyuan() {
		return xianyiyuan;
	}
	/**
	 * 设置：转诊医院
	 */
	public void setZhuanzhenyiyuan(String zhuanzhenyiyuan) {
		this.zhuanzhenyiyuan = zhuanzhenyiyuan;
	}
	/**
	 * 获取：转诊医院
	 */
	public String getZhuanzhenyiyuan() {
		return zhuanzhenyiyuan;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
