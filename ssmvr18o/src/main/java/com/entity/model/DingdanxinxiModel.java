package com.entity.model;

import com.entity.DingdanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 订单信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-04-16 15:09:25
 */
public class DingdanxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 检查检验项目
	 */
	
	private String jianchajianyanxiangmu;
		
	/**
	 * 维修服务
	 */
	
	private String weixiufuwu;
		
	/**
	 * 订单内容
	 */
	
	private String dingdanneirong;
		
	/**
	 * 订单须知
	 */
	
	private String dingdanxuzhi;
		
	/**
	 * 派单时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date paidanshijian;
		
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
	 * 老人当前状态
	 */
	
	private String laorendangqianzhuangtai;
		
	/**
	 * 人员账号
	 */
	
	private String renyuanzhanghao;
		
	/**
	 * 人员姓名
	 */
	
	private String renyuanxingming;
		
	/**
	 * 手机号
	 */
	
	private String shoujihao;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：检查检验项目
	 */
	 
	public void setJianchajianyanxiangmu(String jianchajianyanxiangmu) {
		this.jianchajianyanxiangmu = jianchajianyanxiangmu;
	}
	
	/**
	 * 获取：检查检验项目
	 */
	public String getJianchajianyanxiangmu() {
		return jianchajianyanxiangmu;
	}
				
	
	/**
	 * 设置：维修服务
	 */
	 
	public void setWeixiufuwu(String weixiufuwu) {
		this.weixiufuwu = weixiufuwu;
	}
	
	/**
	 * 获取：维修服务
	 */
	public String getWeixiufuwu() {
		return weixiufuwu;
	}
				
	
	/**
	 * 设置：订单内容
	 */
	 
	public void setDingdanneirong(String dingdanneirong) {
		this.dingdanneirong = dingdanneirong;
	}
	
	/**
	 * 获取：订单内容
	 */
	public String getDingdanneirong() {
		return dingdanneirong;
	}
				
	
	/**
	 * 设置：订单须知
	 */
	 
	public void setDingdanxuzhi(String dingdanxuzhi) {
		this.dingdanxuzhi = dingdanxuzhi;
	}
	
	/**
	 * 获取：订单须知
	 */
	public String getDingdanxuzhi() {
		return dingdanxuzhi;
	}
				
	
	/**
	 * 设置：派单时间
	 */
	 
	public void setPaidanshijian(Date paidanshijian) {
		this.paidanshijian = paidanshijian;
	}
	
	/**
	 * 获取：派单时间
	 */
	public Date getPaidanshijian() {
		return paidanshijian;
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
	 * 设置：老人当前状态
	 */
	 
	public void setLaorendangqianzhuangtai(String laorendangqianzhuangtai) {
		this.laorendangqianzhuangtai = laorendangqianzhuangtai;
	}
	
	/**
	 * 获取：老人当前状态
	 */
	public String getLaorendangqianzhuangtai() {
		return laorendangqianzhuangtai;
	}
				
	
	/**
	 * 设置：人员账号
	 */
	 
	public void setRenyuanzhanghao(String renyuanzhanghao) {
		this.renyuanzhanghao = renyuanzhanghao;
	}
	
	/**
	 * 获取：人员账号
	 */
	public String getRenyuanzhanghao() {
		return renyuanzhanghao;
	}
				
	
	/**
	 * 设置：人员姓名
	 */
	 
	public void setRenyuanxingming(String renyuanxingming) {
		this.renyuanxingming = renyuanxingming;
	}
	
	/**
	 * 获取：人员姓名
	 */
	public String getRenyuanxingming() {
		return renyuanxingming;
	}
				
	
	/**
	 * 设置：手机号
	 */
	 
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
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
