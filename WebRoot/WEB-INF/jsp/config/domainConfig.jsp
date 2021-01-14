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
  	<script src="js/config/domainConfig.js?v=${js_version}"></script>
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
								<h5>域名配置</h5>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:850px;">
									<div class="col-lg-12 col-md-12 col-sm-12 toolBar_body">
										<div class="toolBar-left">
											<input id="search" name="search" class="form-control form_inline" type="text" placeholder="请输入域名进行搜索..." style="width:250px;"/>
		                            	</div>
			                             <div class="toolBar-left">
					                     	<button class="btn btn-info" id="selected" onclick="searchDomain()" type="button">查询</button>
					                    </div>
					                     <div class="toolBar-right">
					                     	<button type="button" class="btn navy-bg" onClick="protectionConfig(-1)">添加域名</button>
					                     </div>
		                           	</div>
									<div class="col-md-12 col-sm-12">
										<table id = "domainProtectionTab"  class="table"></table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	 <!-- 弹出框 -->
   <!--  <div class="modal inmodal" id="domainProtectionModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
	    <div class="modal-dialog" style="width:600px;">
	        <div class="modal-content animated bounceInRight">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
	                <h3 class="modal-title">添加防护域名</h3>
	            </div>
	            <form id="domainProtectionForm">
	                <div class="modal-body" style="padding: 25px 10px 5px 20px">
	                	<input type="hidden" id="id" name="id"/>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">域名：</label>
				            </div>
				            <div class="col-xs-9">
				            	<input class="form-control" type="text" id="domain" name="domain" style="width:90%" required/>
				            </div>
	                	</div>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">协议类型：</label>
				            </div>
				            <div class="col-xs-9">
				            	<select class="form-control" id="protocolType" style="width:90%;">
								    <option value="0">http</option>
								    <option value="1">https</option>
								</select>
				            </div>
	                	</div>
	                	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">源站IP：</label>
				            </div>
				            <div class="col-xs-9">
				            	<textarea class="form-control"  id="resourceIp" name="resourceIp" style="width:90%" rows="5" required></textarea>
				            	<span>请以英文 "," 隔开，不可换行，最多20个</span>
				            </div>
	                	</div>
                	   	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">是否已使用了高防、CDN、云加速等代理？：</label>
				            </div>
				            <div class="col-xs-9">
								<label><input name="useAgent"  id= "useAgentA" type="radio" value="0"  /> 是 </label> 
								<label><input name="useAgent" id="useAgentB"  type="radio" value="1" checked/> 否 </label> 
				            </div>
	                	</div>
                	   	<div class="row form-group">
	                		<div class="col-xs-3">
				                <label class="label-line">是否使用非标准端口？：</label>
				            </div>
				            <div class="col-xs-9">
								<label><input name="port" id="portA" type="radio" value="0"  /> 是 </label> 
								<label><input name="port" id="portB" type="radio" value="1" checked/> 否 </label> 
				            </div>
	                	</div>
	                	
	                </div>
	                <div class="modal-footer">
                    	<button type="submit" class="btn btn-primary save">保存</button>
               		</div>
                </form>
            </div>
        </div>
    </div>  -->
 </div>
		<!--右侧部分结束-->
</body>
</html>