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
	<%@ include  file="/html/head_date.jsp"%>
	<%@ include  file="/html/head_table.jsp"%>
	<script src="plugin/echarts/echarts.min.js"></script>
	<script src="plugin/echarts/china.js"></script>
	<script src="plugin/echarts/echarts-gl.js"></script>
	<script src="js/report/webInfo.js?v=${js_version}"></script>
	
	
	<script type="text/javascript">
		var pageType ; 
		$(function() {
			pageType = '${param1}';

		});
	</script>
	
	
	<style type="text/css">
		.title_text{
			text-align:center;
			font-size: 20px;
			color:#708090;
		}
		.detail_text{
			text-align:center;
			font-size: 13px;
		}
		.chart_detail2{
			text-align:center;
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
								<h5>安全报表><a href="javascript:history.back(-1)">返回上级列表</a></h5>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:600px;">
									<div class="col-lg-12 col-md-12 col-sm-12 toolBar_body">
										<div class="toolBar-left">
			                            	<span class="detail_text">选择域名</span>
			                            </div>
										<div class="toolBar-left">
			                            	<select id="domain_select" class="form-control form_inline" style="width: 250px"></select>
			                            </div>
			                            <div class="toolBar-left">
			                            	<select id="type_select" class="form-control form_inline" style="width: 150px">
			                            		<option value="0">Web应用攻击</option>
			                            		<option value="1">CC攻击</option>
			                            		<option value="2">精准访问打击</option>
			                            	</select>
			                            </div>
		                            	<c:import url="/include/right_top_date"/>
			                            <div class="toolBar-left">
											<span class="btn btn-info" onclick="search()">查询</span>					                            
										</div>
									</div>
									<!-- <div class="col-lg-12 col-md-12 col-sm-12" style="margin: 10px">
										<div class="tabs-container">
											<ul class="nav nav-tabs">
						                        <li class="active"><a href="report/webInfo">Web应用攻击</a></li>
						                        <li class=""><a href="report/ccInfo">CC攻击</a></li>
						                        <li class=""><a href="report/accessInfo">访问控制事件</a></li>
						                    </ul>
										</div>
									</div> -->
									<div class="col-lg-12 col-md-12 col-sm-12" style="padding-top:30px;">
										<div class="col-md-4 col-sm-12" style="border-right: 3px solid;">
											<div class ="inner-content">
												<div class ="chart_detail">
													<div class ="chart_detail2">
														<span class="detail_amount" id="allCount">0</span><br/>
														<span class="detail_text">总请求数</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-12 ">
											<div class ="inner-content" style="border-right: 3px solid;">
												<div class ="chart_detail">
													<div class ="chart_detail2">
														<span class="detail_amount" id="ipCount">0</span><br/>
														<span class="detail_text">IP个数</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-12 ">
											<div class ="inner-content">
												<div class ="chart_detail">
													<div class ="chart_detail2">
														<span class="detail_amount" id="urlCount">0</span><br/>
														<span class="detail_text">攻击的url数</span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12" style="margin-top: 30px">
										<div class="tabs-container tabs-container-span">
					                   		<ul class="nav nav-tabs">
						                        <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true"><span onclick="showChart()">IP</span></a></li>
						                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false"><span onclick="showAreaChart()">区域</span></a></li>
						                        <li class=""><a data-toggle="tab" href="#tab-3" aria-expanded="false"><span onclick=" showCodeChart()">状态码</span></a></li>
						                        <li class=""><a data-toggle="tab" href="#tab-4" aria-expanded="false"><span onclick="showChartBandWidth()">带宽</span></a></li>
						                    </ul>
                    						<div class="tab-content">
						                        <div id="tab-1" class="tab-pane active">
						                            <div class="panel-body">
														<div class="col-lg-8 col-md-8 col-sm-12" style="height:300px;overflow:auto">
															<table id = "attackIpTab" class="table"></table>
														</div>
														<div class="col-md-4 col-sm-12">
															<div class="second-content" id = "attack_sourceArea">
																<div class="pieChart" id = "safePieChart"></div>
															</div>
														</div>
						                            </div>
						                        </div>
						                        <div id="tab-2" class="tab-pane">
						                            <div class="panel-body">
						                            	<div class="col-lg-12 col-md-12 col-sm-12">
															<div id="container" style="height: 400px"></div>
														</div> 
						                            </div>
						                        </div>
						                        <div id="tab-3" class="tab-pane">
					                            	<div class="col-lg-12 col-md-12 col-sm-12 panel-body" id="codeDIV">
														<!-- <div class="col-lg-6 col-md-6 col-sm-12 code_body">
															<div class="code_left">
																<span class="code_num ft_20">499</span>
																<span class="code_num ft_14">260010次</span>
															</div>
															<div class="code_right">
																<span class="code_text ft_14">bad gateway（网关故障）</span>
																<span class="code_text ft_14">状态码描述：代理或网关服务器遇到问题</span>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 code_body">
															<div class="code_left">
																<span class="code_num ft_20">502</span>
																<span class="code_num ft_14">260010次</span>
															</div>
															<div class="code_right">
																<span class="code_text ft_14">bad gateway（网关故障）</span>
																<span class="code_text ft_14">状态码描述：代理或网关服务器遇到问题</span>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 code_body">
															<div class="code_left">
																<span class="code_num ft_20">404</span>
																<span class="code_num ft_14">260010次</span>
															</div>
															<div class="code_right">
																<span class="code_text ft_14">bad gateway（网关故障）</span>
																<span class="code_text ft_14">状态码描述：代理或网关服务器遇到问题</span>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 code_body">
															<div class="code_left">
																<span class="code_num ft_20">503</span>
																<span class="code_num ft_14">260010次</span>
															</div>
															<div class="code_right">
																<span class="code_text ft_14">bad gateway（网关故障）</span>
																<span class="code_text ft_14">状态码描述：代理或网关服务器遇到问题</span>
															</div>
														</div> -->
													</div> 
						                        </div>
						                        <div id="tab-4" class="tab-pane">
					                            	<div class="panel-body">
						                            	<div class="col-md-12 col-sm-12" style="margin-top: 30px">
																<div class="lineChart" id="bandWidthChart" style="width:100%;height:350px;"></div>
														</div>
						                            </div>
						                        </div>
						                    </div>
	 									</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--查看攻击详情-->
	    <div class="modal inmodal" id="attackDetailModal" tabindex="-1" role="dialog" aria-hidden="true">
		    <div class="modal-dialog" style="width:820px;">
		        <div class="modal-content animated bounceInRight">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
		                </button>
		                <h5 class="modal-title">查看攻击详情</h5>
		            </div>
	                <div class="modal-body">
	                	<div id="attackDetail">
	                		<table id = "webDetailTab" class="table"></table>
	                	</div>
	                </div>
	                <div class="modal-footer">
					</div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>