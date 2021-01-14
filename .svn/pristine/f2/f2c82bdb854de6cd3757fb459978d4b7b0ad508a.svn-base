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
	<script src="js/report/serviceAnalysis.js?v=${js_version}"></script>
	
	
	<script type="text/javascript">
	</script>
	
	
	<style type="text/css">
	.lineChart{
			width:100%;
			height:75%;
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
								<h5>业务分析</h5>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:2000px;">
									<div class="col-lg-12 col-md-12 col-sm-12 toolBar_body">
										<div class="toolBar-left">
			                            	<span>选择域名：</span>
			                            	<input type="text" id="infoDomain"/>
			                            </div>
										<div class="toolBar-left">
			                            	<span>查询时间：</span>
			                            	<button class="btn" onclick="searchDetail(1)">昨天</button>
			                            	<button class="btn" onclick="searchDetail(2)">今天</button>
			                            	<button class="btn" onclick="searchDetail(3)"> 7 天</button>
			                            	<button class="btn" onclick="searchDetail(4)">30天</button>
			                            </div >
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12" style="padding-top:30px;">
										<div class="col-md-6 col-sm-12 content-top">
											<div class ="second-content">
												<div class ="chart_title">
													<span class="title_text">访问次数</span>
												</div>
												<div class ="chart_detail">
													<div class ="chart_detail1">
														<span class="detail_text">昨日</span><br/>
														<span class="detail_amount" id ="yesVisitTimes">100万</span>
													</div>
													<div class ="chart_detail2">
														<span class="detail_text">今日</span><br/>
														<span class="detail_amount" id ="todVisitTimes">1000万</span>
													</div>
													<div class ="chart_detail2">
														<span class="detail_text">30天</span><br/>
														<span class="detail_amount" id ="lastVisitTimes">1000万</span>
													</div>
												</div>
												<div class="lineChart" id="numberLineChart"></div>
											</div>
										</div>
										<div class="col-md-6 c ol-sm-12 content-top">
											<div class ="second-content">
												<div class ="chart_title">
													<span class="title_text">访问IP数</span>
												</div>
												<div class ="chart_detail">
													<div class ="chart_detail1">
														<span class="detail_text">昨日</span><br/>
														<span class="detail_amount" id ="yesIpTimes">100万</span>
													</div>
													<div class ="chart_detail2">
														<span class="detail_text">今日</span><br/>
														<span class="detail_amount" id ="todIpTimes">1000万</span>
													</div>
													<div class ="chart_detail2">
														<span class="detail_text">30天</span><br/>
														<span class="detail_amount" id ="lastIpTimes">1000万</span>
													</div>
												</div>
												<div class="lineChart" id="ipLineChart"></div>
											</div>
										</div>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12" style="padding-top:30px;">
										<div class="col-md-4 col-sm-12 " >
											<div class="second-content">
												<span class = "detail_text">响应时间TOP5</span>
												<div class="pieChart" id = "responseTimeChart"></div>
											</div>
										</div>
										<div class="col-md-4 col-sm-12">
											<div class="second-content" >
												<span class = "detail_text">响应IP次数TOP5</span>
												<div class="pieChart" id = "responseIpChart"></div>
											</div>
										</div>
										<div class="col-md-4 col-sm-12">
											<div class="second-content" >
												<span class = "detail_text">请求来源区域 TOP5</span>
												<div class="pieChart" id = "requestResourceChart"></div>
											</div>
										</div>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12" style="padding-top:5px;">
										<div class="col-md-6 col-sm-12 " >
											<div class="second-content">
												<span class = "detail_text">服务器响应状态</span>
												<div class="pieChart" id = "responseStateChart"></div>
											</div>
										</div>
										<div class="col-md-6 col-sm-12">
											<div class="second-content">
												<span class = "detail_text">访问流量的浏览器分布</span>
												<div class="pieChart" id = "BrowserChart"></div>
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