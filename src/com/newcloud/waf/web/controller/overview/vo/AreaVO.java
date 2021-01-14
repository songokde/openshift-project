package com.newcloud.waf.web.controller.overview.vo;

public class AreaVO {
	private String name;
 
	private Long value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public AreaVO(String name, Long value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	
}
