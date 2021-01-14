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
  	<script src="js/overview/totalView.js?v=${js_version}"></script>
	<style type="text/css">
		.chart_text{
			text-align:left;
			font-size:15px;
		}
		.chart_describe{
			display:inline-block;
			float:right;
			font-size:15px;
		}
		.detail_text{
			text-align:left;
		}
		.lineChart{
			width:100%;
			height:75%;
		}
		.chart_detail2{
			text-align:center;
		}
	</style>
	<script type="text/javascript">
	</script>
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
								<h5>防护概览</h5>
							</div>
							<div class="ibox-content">
								<div class="row" style="min-height:850px;">
									<!-- 三个并列图 -->
									<div class="col-md-12 col-sm-12" style="padding-top:30px;">
										<div class="col-md-4 col-sm-12 content-top">
											<div class ="second-content" id ="webChart">
												<div class ="chart_title" >
													<span class ="chart_text">Web攻击</span>
													<a onclick="view('0')" class = "chart_describe">查看报表> </a>
												</div>
												<div class ="chart_detail" >
													<div class="chart_detail2">
														<span class="detail_amount" id="webYesterday">0</span><a>/次</a><br/>
														<span class ="detail_text">昨日</span>
													</div>
													<div class="chart_detail2">
														<span class="detail_amount" id="webToday">0</span><a>/次</a><br/>
														<span class ="detail_text">今日</span>
													</div>
												</div>
												<div class="lineChart" id="webLineChart"></div>
											</div>
										</div>
										<div class="col-md-4 col-sm-12 content-top">
											<div class ="second-content" id ="ccChart" >
												<div class ="chart_title" >
													<span class ="chart_text">cc攻击</span>
													<a onclick="view('1')" class = "chart_describe">查看报表></a>
												</div>
												<div class ="chart_detail" >
													<div class="chart_detail2">
														<span class="detail_amount" id="ccYesterday">0</span><a>/次</a><br/>
														<span class ="detail_text">昨日</span>
													</div>
													<div class="chart_detail2">
														<span class="detail_amount" id="ccToday">0</span><a>/次</a><br/>
														<span class ="detail_text">今日</span>
													</div>
													
												</div>
												<div class="lineChart" id="ccLineChart" ></div>
											</div>
										</div>
										<div class="col-md-4 col-sm-12 content-top">
											<div class ="second-content" id ="controlChart" >
												<div class ="chart_title" >
													<span class ="chart_text">访问控制事件</span>
													<a onclick="view('2')" class = "chart_describe">查看报表></a>
												</div>
												<div class ="chart_detail" >
													<div class="chart_detail2">
														<span class="detail_amount" id="visitYesterday">0</span><a>/次</a><br/>
														<span class ="detail_text">昨日</span>
													</div>
													<div class="chart_detail2">
														<span class="detail_amount" id="visitToday">0</span><a>/次</a><br/>
														<span class ="detail_text">今日</span>
													</div>
												</div>
												<div class="lineChart" id="controlLineChart"></div>
											</div>
										</div>
										<div class="col-md-15 col-sm-12 content-top">
											<div class ="second-content" id ="bandWidthChart" >
												<div class="lineChart" id="bandWidthChart"></div>
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
</body>
</html>