package com.newcloud.waf.web.controller.config.vo;

/**
 * 域名配置中左右框vo
 * @author song
 *
 */
public class RulesVO {

	private Integer ruleId;
	
	private String ruleName;
	
	private boolean flag;

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public RulesVO(Integer ruleId, String ruleName, boolean flag) {
		super();
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.flag = flag;
	}
	
	
}
