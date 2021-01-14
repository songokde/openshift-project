package com.newcloud.waf.storage.entity;

import org.apache.commons.lang.math.NumberUtils;

public class ComBox extends BaseEntity{
	private static final long serialVersionUID = -636091415670375211L;

	private Integer id;
	
	private String text;
	
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	
	public Long getLongText(){
		if(NumberUtils.isNumber(text)){
			return Long.valueOf(text);
		}else{
			return 0L;
		}
		
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ComBox(Integer id, String remark,String text) {
		super();
		this.id = id;
		this.remark = remark;
		this.text = text;
	}
	
	public ComBox(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	public ComBox(Integer id, Long text) {
		super();
		this.id = id;
		this.text = text.toString();
	}

	public ComBox() {
		super();
	}
}
