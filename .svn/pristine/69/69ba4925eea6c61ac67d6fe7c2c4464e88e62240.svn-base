 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath()+"/";
	String hostname = request.getServerName();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<base href="<%=path %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=0.5, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>新壹云</title>
	<%@ include  file="/html/head_css.jsp"%>
	<%@ include  file="/html/head_js.jsp"%>
	<%@ include  file="/html/head_table.jsp"%>
	<%@ include  file="/html/head_validata.jsp"%>
	<script src="plugin/echarts/echarts.common.min.js"></script>
	<script src="plugin/lc_switch/lc_switch.min.js"></script>
	<script src="js/config/ccConfig.js?v=${js_version}"></script>
	<style type="text/css">
		.inner-describe{
			text-align: center;
			height:80%;
			padding-top: 50px;
		}
		.inner-config{
			text-align: left;
			height:80%;
			padding-top: 30px;
		}
		.inner_row{
			height:150px;
			width: 100%;
			border:1px solid #DCDCDC;  
			margin-top: 20px;
		}
		.text_total{
			font: 16px solid;
		}
		.text_detail{
			padding-bottom:10px;
			font-size: 12px;
		}
		.div_rule_font{
			font-size: small;
			font-weight: bold;	
			display: inline-block;
			height: 30px;
			line-height: 30px;
			margin: 0 5px;
		}
		input[type=radio]{
			display: inline-block;
			margin:2px 5px 0 10px;
			vertical-align: sub;
		}
	</style>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" >
	<div id="">
        <!--右侧部分开始-->
		<div class="row J_mainContent" id="content-main">
			<div class="wrapper wrapper-content">
				<div class="row">
					<div class="col-sm-12">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>CC防护规则列表</h5>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:850px;">
									<div class="col-lg-12 col-md-12 col-sm-12 toolBar_body">
										<div class="toolBar-left">
											<input id="domain" name="domain" class="form-control form_inline" type="text" placeholder="请输入规则名进行搜索..." style="width:250px;"/>
		                            	</div>
			                             <div class="toolBar-left">
					                     	<button class="btn btn-info" id="selected" onclick="search()" type="button">查询</button>
					                    </div>
					                     <div class="toolBar-right">
					                     	<button type="button" class="btn navy-bg" onClick="addRule()">添加规则</button>
					                     </div>
		                           	</div>
									<div class="col-md-12 col-sm-12">
										<table id = "ccConfigTab"  class="table"></table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		 <!-- 弹出框 -->
	    <div class="modal inmodal" id="ccRuleModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
	    <div class="modal-dialog" style="width:600px;">
	        <div class="modal-content animated bounceInRight">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
	                <h3 class="modal-title">编辑规则</h3>
	            </div>
	            <form id="ccRuleForm">
	                <div class="modal-body" style="padding: 25px 10px 5px 20px">
	                	<input type="hidden" id="id" name="id"/>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">规则名称：</label>
				            </div>
				            <div class="col-xs-9">
				            	<input class="form-control" type="text" id="wciRuleName" name="wciRuleName" style="width:80%" required/>
				            </div>
	                	</div>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">URL：</label>
				            </div>
				            <div class="col-xs-9">
				            	<input class="form-control" type="text" id="wciUrl" name="wciUrl" style="width:80%" required/>
				            </div>
	                	</div>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">匹配规则：</label>
				            </div>
		            	  	<div class="col-xs-9">
								<label><input class="wciRuleInfo" name="wciRuleInfo"  type="radio" value="0" />完全匹配 </label> 
								<label><input class="wciRuleInfo" name="wciRuleInfo"  type="radio" value="1" />前缀匹配 </label> 
		           			 </div>
	                	</div>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">检测时长：</label>
				            </div>
				            <div class="col-xs-9">
				            	<div style="float: left">
				            		<input class="form-control" type="text" id="wciDuration" name="wciDuration" style="width:140px" required/>
				           		</div>
				           		<div style="float: left">
					            	<a class="div_rule_font">/秒</a>
				            	</div>
				            </div>
	                	</div>
	                	
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">单一IP访问次数：</label>
				            </div>
				            <div class="col-xs-9">
				            	<div style="float: left">
					            	<input class="form-control" type="text" id="wciIpCount" name="wciIpCount" style="width:140px" required/>
				            	</div>
				            	<div style="float: left">
					            	<a class="div_rule_font">/次</a>
				            	</div>
				            </div>
	                	</div>
                	   	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">阻断类型：</label>
				            </div>
				            <div class="col-xs-9">
								<label><input class="wciMovement" name="wciMovement"  type="radio" value="0" />封禁 </label> 
								<label><input class="wciMovement" name="wciMovement"  type="radio" value="1" /> 人机识别 </label> 
				            </div>
	                	</div>
                	   	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line"></label>
				            </div>
				            <div class="col-xs-9">
				            	<div style="float: left">
									<input class="form-control" type="text" id="wciTime" name="wciTime" style="width:140px" required/>
								</div>
								<div style="float: left">
					            	<a class="div_rule_font">/分钟</a>
				            	</div>
				            </div>
	                	</div>
	                </div>
	                <div class="modal-footer">
                    	<button type="submit" id="saveConfig" class="btn btn-primary save">保存</button>
               		</div>
                </form>
            </div>
        </div>
    </div> 
	</div>
</body>
</html>