package com.newcloud.waf.web.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwordPageController {
	
	/**
	 * 设置页面传递参数
	 * 
	 * @param request
	 * @param en
	 * @param cn
	 */
	private void setParameter(HttpServletRequest request, int en, int cn) {
		if (en > 0) {
			for (int i = 1; i <= en; i++) {
				request.setAttribute("param" + i, request.getParameter("param" + i));
				System.out.println(request.getParameter("param" + i));
			}
		}
		if (cn > 0) {
			try {
				for (int i = 1; i <= cn; i++) {
					String cnparam = request.getParameter("cnparam" + i);
					if (cnparam != null) {
						cnparam = URLDecoder.decode(cnparam, "UTF-8");
					}
					request.setAttribute("cnparam" + i, cnparam);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/main")
	public String main(HttpServletRequest request) {
		return "main";
	}
	
	@RequestMapping("/overview/{path}")
	public String overview(HttpServletRequest request,@PathVariable String path) {
		return "overview/" + path;
	}
	
	@RequestMapping("/report/{path}")
	public String finance(HttpServletRequest request, @PathVariable String path) {
		setParameter(request,1,0);
		return "report/" + path;
	}
	
	@RequestMapping("/config/{path}")
	public String resource(HttpServletRequest request, @PathVariable String path) {
		return "config/" + path;
	}
	@RequestMapping("/include/{path}")
	public String include(HttpServletRequest request, @PathVariable String path) {
		return "include/" + path;
	}
	
}
