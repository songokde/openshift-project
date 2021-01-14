package com.newcloud.waf.storage.entity.info;

import com.newcloud.waf.storage.entity.BaseEntity;

public class InfoArea extends BaseEntity{
	private static final long serialVersionUID = 2394061108544352489L;
	
	private Integer ariId;
    private String ariProname;
    private String ariProvice;

    public InfoArea() {
    }
    
    public InfoArea(Integer ariId) {
    	this.ariId = ariId;
    }

    public InfoArea(String ariProname, String ariProvice) {
        this.ariProname = ariProname;
        this.ariProvice = ariProvice;
    }
    
    public Integer getAriId() {
        return this.ariId;
    }
    
    public void setAriId(Integer ariId) {
        this.ariId = ariId;
    }

    public String getAriProname() {
        return this.ariProname;
    }
    
    public void setAriProname(String ariProname) {
        this.ariProname = ariProname;
    }

    public String getAriProvice() {
        return this.ariProvice;
    }
    
    public void setAriProvice(String ariProvice) {
        this.ariProvice = ariProvice;
    }

}