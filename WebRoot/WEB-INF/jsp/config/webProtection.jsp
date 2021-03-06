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
	<script src="plugin/echarts/echarts.common.min.js"></script>
	<script src="plugin/lc_switch/lc_switch.min.js"></script>
	<script src="js/config/webProtection.js?v=${js_version}"></script>
	<script type="text/javascript">
	var pageId = ${param.param1}; 
	var pageType;
	$(document).ready(function() {
		$("#ipCheck").click(function(){
		     if ($("#ipCheck").is(":checked")) {
		            $("#ipInput").css("display","block");
		        } else {
		        	$("#ipInput").css("display","none");
		        }  
		})
    }); 
	</script>
	<style type="text/css">
		.inner-describe{
			text-align: center;
			height:80%;
			padding-top:15px;
		}
		.inner_row .inner-describe{
			padding-top: 50px;
			padding-bottom:0px;
		}
		.inner_row .col-md-4{
			background:#dcdfe2; 
			height: 100%;
		}
		.inner-config{
			text-align: left;
			height:80%;
			padding-top: 30px;
		}
		.inner_row{
			height:150px;
			border:1px solid #DCDCDC;  
			margin:10px 5px 10px 20px;
			padding-left: 0
		}
		.text_total{
			font: 16px solid;
		}
		.text_detail{
			padding-bottom:10px;
			font-size: 12px;
		}
		.lc_remark{
			background: #dae4f3;
			margin:10px 20px;
			padding: 10px 10px 20px 10px;
		}
		.lc_remark>span{
			display: inline-block;
			margin:0 10px;
		}
		.lc_remark_text{
			font-size: 14px;
		}
		.lcs_check{
			vertical-align: sub;
		}
		.inner-config label{
			display: inline-block;
			height: 22px;
			line-height: 22px;
			font-weight: 400;
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
							<%-- <h5>域名 ：${param1}</h5> --%>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:600px;">
									<div class="lc_remark" >
										<span style="font-size: 16px">Web防火墙安全监测流程</span>
										<div class ="inner-describe lc_remark_text">
											<div class="col-md-4 col-sm-4" style="text-align: right;">
												<span>精准访问控制</span>
												<span class="glyphicon glyphicon-arrow-right"></span>
											</div>
											<div class="col-md-4 col-sm-4" >
												<span>cc安全防护</span>
												<span class="glyphicon glyphicon-arrow-right"></span>
											</div>
											<div class="col-md-4 col-sm-4" style="text-align: left;">
												<span>Web应用攻击防护</span>
												<span class="glyphicon glyphicon-arrow-right"></span>
											</div>
											<span style="display:inline-block;padding-top:30px;">流量经过Web应用防火墙时，首先依次匹配精准访问控制中的规则，再进行CC攻击的检测，最后进行Web应用攻击防护</span>
										</div>	
									</div >
									<div class="col-lg-12 col-md-12 col-sm-12">
										<div class="toolBar-left">
							                <label class="label-line">请选择域名</label>
							            </div>
							            <div class="toolBar-left">
							            	<select class="form-control" id="domainSelect" style="width:200px;">
											</select>
							            </div>
									</div>
									<div style="width: 97%">
										<div class="col-lg-12 col-md-12 col-sm-12 inner_row">
											<div class="col-md-4 col-sm-4">
												<div class ="inner-describe">
													<span class="text_total">Web应用防护攻击</span><br/>
													<span class="text_detail">防护SQL注入，XSS跨站等常见Web应用攻击，实时生效</span>
												</div>
											</div>
											<div class="col-md-8 col-sm-8" >
												<div class ="inner-config">
													<div >
														<label >状态：</label>
														<input type="checkbox" id="webCheck"  class="lcs_check" autocomplete="off" />
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 inner_row">
											<div class="col-md-4 col-sm-4">
												<div class ="inner-describe">
													<span class="text_total">CC安全防护</span><br/>
													<span class="text_detail">独家算法防护引擎、结合大数据，秒级拦截机器恶意CC攻击</span>
												</div>
											</div>
											<div class="col-md-8 col-sm-8" >
												<div class ="inner-config">
													<div >
														<label >状态：</label>
														<input type="checkbox"  id="ccCheck"  class="lcs_check" autocomplete="off" />
													</div>
													<div>
														<label >自定义规则：</label>
													</div>
													<div>
														<input type="hidden" id="ccRuleIds" />
														<label id="ccRuleNames"></label>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="refreshRule('cc')">前去配置</a>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 inner_row">
											<div class="col-md-4 col-sm-4">
												<div class ="inner-describe">
													<span class="text_total">精准访问控制</span><br/>
													<span class="text_detail">对常见的HTTP字段进行条件组合、支持业务场景的定制化防护策略</span>
												</div>
											</div>
											<div class="col-md-8 col-sm-8" >
												<div class ="inner-config">
													<div >
														<label >状态：</label>
														<input type="checkbox"  id="exactCheck" class="lcs_check" autocomplete="off" />
													</div>
													<div>
														<input type="hidden" id="exactRuleIds" />
														<label id="exactRuleNames"> </label>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="refreshRule('visit')">前去配置</a>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 inner_row">
											<div class="col-md-4 col-sm-4">
												<div class ="inner-describe">
													<span class="text_total">禁封IP/IP段</span><br/>
													<span class="text_detail"></span>
												</div>
											</div>
											<div class="col-md-8 col-sm-8" >
												<div class ="inner-config">
													<div >
														<label >状态：</label>
														<input type="checkbox" id="ipCheck"  class="lcs_check" autocomplete="off" />
													</div>
													<div  style="display: none;" id="ipInput">
														<label>ip段：</label>
														<textarea style="width: 200px;height: 50px;" id="ipSegment"></textarea>
													</div>
												</div>
											</div>
										</div>
									</div>
									
								</div>
								<div class="modal-footer" style="margin-top: 20px">
			                    	<button onclick="saveDomainConfig()" class="btn btn-primary save">保存</button>
			               		</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
	</div>
		 <!-- 弹出框 -->
		   <div class="modal inmodal" id="ccRuleModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
		    	<div class="modal-dialog" style="width:900px;">
			        <div class="modal-content animated bounceInRight">
			        	<div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
			                <h3 class="modal-title">编辑规则</h3>
			            </div>
				        <div class="col-lg-12 col-md-12 col-sm-12 modal-body">
               		 		<div class="col-lg-5 col-md-5 col-sm-12">
                           		<div class="col-lg-12 col-md-12 col-sm-12">
                            		<div class="toolBar-left">
                            			<input type="hidden" id="ruleType"/>
										<label class="label_text" style="color: red">未关联规则:</label>
		                            </div>
	                            </div>
	                            <div class="col-lg-12 col-md-12 col-sm-12">
									<select multiple="multiple" style="width:100%;margin-top: 5px" size="15" class="form-control form_inline select_domain" id="unrule">
                       				</select>
								</div>
                           	</div>
                           	<div class="col-lg-1 col-md-1 col-sm-12 flex_center" style="height:360px;padding-top:30px">
                           		<a style="margin:0 20px" class="btn btn-success" onclick="AllRight()">&gt;&gt;</a>
                           		<a style="margin:0 20px" title="this right" class="btn btn-default" id="toRight">&gt;</a><br>
								<a style="margin:0 20px" title="this Left" class="btn btn-default" id="toLeft">&lt;</a><br>
                         		<a style="margin:0 20px" class="btn btn-danger" onclick="AllLeft()">&lt;&lt;</a><br>
                    			<a class="btn btn-success" onclick="saveRule()">保存配置</a>
                         	</div>
                        	<div class="col-lg-6 col-md-6 col-sm-12">
                           		<div class="col-lg-12 col-md-12 col-sm-12">
                            		<div class="toolBar-left">
										<label class="label_text" style="color: green">已关联规则：</label>
		                            </div>
	                            </div>
	                            <div class="col-lg-12 col-md-12 col-sm-12">
									<select multiple="multiple" style="width:100%;margin-top: 5px" size="15" class="form-control form_inline select_domain" id="selrule">
                   					</select>
								</div>
                           	</div>
				        </div>
		           </div>
		       </div>
		   </div> 
</div>


 <script>
	 $(function () {
			//toRight
			$("#toRight").click(function () {
				//获取右边的下拉列表对象，append(左边下拉列表选中的option)
				$("#selrule").append($("#unrule > option:selected"));
	    	 });
	
	    	 //toLeft
	    	 $("#toLeft").click(function () {
	         //appendTo   获取右边选中的option，将其移动到左边下拉列表中
				$("#selrule > option:selected").appendTo($("#unrule"));
	    	 });
	 });	
	$(function() {
		$("#unrule").dblclick(function() {
			doubleClick(1);
		});
		$("#selrule").dblclick(function() {
			doubleClick(2);
		});
	});
	
	function doubleClick(n) {
		if (n == 1) {
			$("#unrule option:selected").appendTo("#selrule");
		} else if (n == 2) {
			$("#selrule option:selected").appendTo("#unrule");
		}
	}
	function AllRight() {
		$("#unrule option").appendTo("#selrule");
	}
	function AllLeft() {
		$("#selrule option").appendTo("#unrule");
	}
    </script>
</body>
</html>