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
	<script src="js/config/exactConfig.js?v=${js_version}"></script>
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
		.div_rule{
			float:left;
			width: 30%;
			height:30px;
		}
		.div_rules{
			height: 30px;
			float: left;
			margin-top:10px
		}
		.div_rule_font{
			font-size: small;
			font-weight: bold;	
			position:absolute;
 			bottom:0px;
			padding:0px;
 			margin:0px 
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
							<h5>精准防护规则列表</h5>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:850px;">
									<div class="col-md-12 col-sm-12">
										<span style="display: inline-block;padding: 0 10px; color: #e4393c;width: 70%">注意：当前每一条规则中最多允许三个条件组合，并且条件之间是"与"的逻辑关系（即三个条件同时满足才算匹配中规则）。匹配中规则后的动作有三种:阻断、放行
										（可根据后续是否继续进行Web攻击拦截或CC攻击）、告罄（只记录不阻断）。规则之间是有先后匹配顺序的，可点击规则排序打到最优的防护效果。
										</span>
									</div >
									<div class="col-lg-12 col-md-12 col-sm-12 toolBar_body">
										<div class="toolBar-left">
											<input id="searchName" name="searchName" class="form-control form_inline" type="text" placeholder="请输入规则名进行搜索..." style="width:250px;"/>
		                            	</div>
			                             <div class="toolBar-left">
					                     	<button class="btn btn-info" id="selected" onclick="search()" type="button">查询</button>
					                    </div>
					                     <div class="toolBar-right">
					                     	<button type="button" class="btn navy-bg" onClick="addRule()">添加规则</button>
					                     </div>
		                           	</div>
									<div class="col-md-12 col-sm-12">
										<table id = "exactConfigTab"  class="table"></table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		 <!-- 弹出框 -->
	    <div class="modal inmodal" id="exactRuleModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
		    <div class="modal-dialog" style="width:900px;">
		        <div class="modal-content animated bounceInRight">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
		                <h3 class="modal-title">编辑规则</h3>
		            </div>
		            <form id="exactRuleForm">
		                <div class="modal-body" style="padding: 25px 10px 5px 20px">
		                	<input type="hidden" id="id" name="id"/>
		                	<div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line">规则名称：</label>
					            </div>
					            <div class="col-xs-9">
					            	<input class="form-control" type="text" id="weiRuleName" name="weiRuleName" style="width:83%" required/>
					            </div>
		                	</div>
		                	<!-- <div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line">URL：</label>
					            </div>
					            <div class="col-xs-9">
					            	<input class="form-control" type="text" id="URL" name="URL" style="width:83%" required/>
					            </div>
		                	</div> -->
		                	<div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line">匹配条件：</label>
					            </div>
					            <div class="col-xs-9">
					            	<div class="div_rule"><span class="div_rule_font">匹配字段</span></div>
					            	<div style="height: 30px;width: 120px;float: left"><span class="div_rule_font">逻辑符</span></div>
					            	<div class="div_rule"><span class="div_rule_font">匹配内容</span></div>
					            </div>
		                	</div>
		                	<div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line"></label>
					            </div>
		                		<div class="col-xs-9" id="add_config">
		                			<div class="div_rule">
		                				<select class="fields" name="fields" id="fields" style="height: 30px;width: 170px">
											<option value="url" >URL</option>
											<option value="ip" >IP</option>
											<option value="reference" >Reference</option>
											<option value="useragent" >User-Agent</option>
											<option value="params" >Params</option>
										</select>
									</div>
		                			<div style="height: 30px;width: 120px;float: left">
		                				<select class="symbols" name="symbols" id="symbols" style="height: 30px;width: 100px">
											<option value="notin" >不包含</option>
											<option value="in" >包含</option>
											<option value="notequals" >不等于</option>
											<option value="equals" >等于</option>
											<option value="morethan" >长度小于</option>
											<option value="lessthan" >长度大于</option>
										</select>
		                			</div>
		                			<div style="height: 30px;width: 220px;float: left">
		                				<input class="form-control infos" type="text" id="infos_1" name="infos" style="height: 30px;width: 220px" required/>
		                			</div>
		                			<div style="float: left;margin: 5px">
			                			<span onclick="addButton1()" id="btn_add1" class="btn_place"  style="margin:0;color: #2d99e8;">
											<i class="glyphicon glyphicon-plus"></i>
										</span>
		                			</div> 
	                			</div>
				            </div>
		                	<div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line">匹配动作：</label>
					            </div>
					            <div class="div_rule" style="margin-left: 15px">
				            		<select  class="weiMovement"  id="weiMovement" name ="weiMovement" style="height:30px;width:170px">
										<option value="0" >阻断</option>
										<option value="1" >放行</option>
									</select>
				            	</div>
					           <!--  <div class="col-xs-9">
					            	<div class="div_rule" style="width: 100px">
					            		<span class="div_rule_font" style="bottom:5px">防护规则策略：</span>
					            	</div>
					            	<div class="div_rule">
					            		<select name="action" style="height:30px;width:170px">
											<option value="a" >阻断</option>
											<option value="b" >放行</option>
											<option value="c" >告罄</option>
										</select>
					            	</div>
									
					            </div> -->
		                	</div>
		                	
		               	   <!-- 	<div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line">阻断类型：</label>
					            </div>
					            <div class="col-xs-9">
									<label><input name="useagent"  type="radio" value="0"  />封禁 </label> 
									<label><input name="useagent"  type="radio" value="1" checked/> 人机识别 </label> 
					            </div>
		                	</div> -->
		               	   <!-- 	<div class="row form-group">
		                		<div class="col-xs-3">
					                <label class="label-line"></label>
					            </div>
					            <div class="col-xs-4">
					            	<input name="securityPolicy" type="checkbox"/><span style="font-size: initial">&nbsp;&nbsp;&nbsp;继续执行waf应用攻击防护</span><br>
					            	<input name="securityPolicy" type="checkbox"/><span style="font-size: initial">&nbsp;&nbsp;&nbsp;继续执行cc应用攻击防护</span><br>
					            	<input name="securityPolicy" type="checkbox"/><span style="font-size: initial">&nbsp;&nbsp;&nbsp;继续执行智能防护</span><br>
					            </div>
		                	</div> -->
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