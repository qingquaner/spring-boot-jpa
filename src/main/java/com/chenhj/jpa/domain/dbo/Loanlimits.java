package com.chenhj.jpa.domain.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loanlimits")
public class Loanlimits {
	/**
	 * 
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(length = 25)
	private String djxh; // 登记序号
	@Column(length = 20)
	private String nsrsbh; // 纳税人识别号
	@Column(length = 12)
	private String nsrswjgdm; // 税务机关代码
	@Column(length = 80)
	private String nsrmc; // 纳税人名称
	@Column(length = 25)
	private String nsrdzdah; // 纳税人电子档案号
	@Column(length = 20)
	private String mobile; // 手机号码
	@Column(length = 10)
	private String yjnsze;
	@Column(length = 10)
	private String nnsze;

	@Column(length = 20)
	private String jsyh; // 江苏银行
	@Column(length = 20)
	private String zsyh; // 浙商银行
	@Column(length = 20)
	private String gdyh; // 广大银行
	@Column(length = 20)
	private String zhasyh; // 招商银行
	@Column(length = 20)
	private String njyh; // 南京银行
	@Column(length = 20)
	private String zgyh; // 中国银行
	@Column(length = 1)
	private String wether;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDjxh() {
		return djxh;
	}

	public void setDjxh(String djxh) {
		this.djxh = djxh;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getNsrswjgdm() {
		return nsrswjgdm;
	}

	public void setNsrswjgdm(String nsrswjgdm) {
		this.nsrswjgdm = nsrswjgdm;
	}

	public String getNsrmc() {
		return nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getNsrdzdah() {
		return nsrdzdah;
	}

	public void setNsrdzdah(String nsrdzdah) {
		this.nsrdzdah = nsrdzdah;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getYjnsze() {
		return yjnsze;
	}

	public void setYjnsze(String yjnsze) {
		this.yjnsze = yjnsze;
	}

	public String getNnsze() {
		return nnsze;
	}

	public void setNnsze(String nnsze) {
		this.nnsze = nnsze;
	}

	public String getJsyh() {
		return jsyh;
	}

	public void setJsyh(String jsyh) {
		this.jsyh = jsyh;
	}

	public String getZsyh() {
		return zsyh;
	}

	public void setZsyh(String zsyh) {
		this.zsyh = zsyh;
	}

	public String getGdyh() {
		return gdyh;
	}

	public void setGdyh(String gdyh) {
		this.gdyh = gdyh;
	}

	public String getZhasyh() {
		return zhasyh;
	}

	public void setZhasyh(String zhasyh) {
		this.zhasyh = zhasyh;
	}

	public String getNjyh() {
		return njyh;
	}

	public void setNjyh(String njyh) {
		this.njyh = njyh;
	}

	public String getZgyh() {
		return zgyh;
	}

	public void setZgyh(String zgyh) {
		this.zgyh = zgyh;
	}

	public String getWether() {
		return wether;
	}

	public void setWether(String wether) {
		this.wether = wether;
	}

	@Override
	public String toString() {
		return "Loanlimits [id=" + id + ", djxh=" + djxh + ", nsrsbh=" + nsrsbh + ", nsrswjgdm=" + nsrswjgdm
				+ ", nsrmc=" + nsrmc + ", nsrdzdah=" + nsrdzdah + ", mobile=" + mobile + ", yjnsze=" + yjnsze
				+ ", nnsze=" + nnsze + ", jsyh=" + jsyh + ", zsyh=" + zsyh + ", gdyh=" + gdyh + ", zhasyh=" + zhasyh
				+ ", njyh=" + njyh + ", zgyh=" + zgyh + ", wether=" + wether + "]";
	}

}
