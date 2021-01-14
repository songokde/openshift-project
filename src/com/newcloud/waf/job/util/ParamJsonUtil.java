package com.newcloud.waf.job.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newcloud.waf.storage.entity.waf.WafCcInfo;
import com.newcloud.waf.storage.entity.waf.WafDomainInfo;
import com.newcloud.waf.storage.entity.waf.WafExactInfo;

public class ParamJsonUtil {
	public static JSONObject analysisVOtoJson(WafDomainInfo vo, List<WafCcInfo> ccList, List<WafExactInfo> visitList) {
		JSONObject json = new JSONObject();
		json.put("name", vo.getWdiDname());
		json.put("webstatus", vo.getWdiWebShield().equals("N")?false:true);
		JSONArray array = new JSONArray();
		JSONArray visitArray = new JSONArray();
		if(ccList.size()>0) {
			for(WafCcInfo cc : ccList) {
				JSONObject ccJson = new JSONObject();
				ccJson.put("cc-url", cc.getWciUrl());
				ccJson.put("cc-ruleinfo", cc.getWciRuleInfo());
				ccJson.put("cc-duration", cc.getWciDuration());
				ccJson.put("cc-ip-vistit-count", cc.getWciIpCount());
				ccJson.put("cc-movement", cc.getWciMovement());
				ccJson.put("cc-time", cc.getWciTime());
				array.add(ccJson);
			}
		}else {
			json.put("ccstatus", false);
		}
		json.put("cc-rule", array);
		if(visitList.size()>0) {
			for(WafExactInfo visit : visitList) {
				JSONObject visitJson = new JSONObject();
				visitJson.put("visit-movement", visit.getWeiMovement());
				visitJson.put("visit-ruleinfo",JSONArray.parseArray(visit.getWeiRuleInfo()));
				visitArray.add(visitJson);
			}
		}else {
			json.put("visitstatus", false);
		}
		json.put("visit-rule", visitArray);
		json.put("ip-segment", StringUtils.isEmpty(vo.getWdiIpSegment())?"":vo.getWdiIpSegment());
		return json;
	}

}
