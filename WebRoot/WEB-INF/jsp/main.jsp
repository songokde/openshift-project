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
	<script type="text/javascript">
		$(function(){
		    //菜单点击
		    $(".J_menuItem").on('click',function(){
		        var url = $(this).attr('href');
		        $("#J_iframe").attr('src',url);
		        return false;
		    });
		});
    </script>
	<style>
		.t_90{
			transform:rotate(90deg);
			-ms-transform:rotate(90deg); 		/* IE 9 */
			-moz-transform:rotate(90deg); 		/* Firefox */
			-webkit-transform:rotate(90deg); 	/* Safari 和 Chrome */
			-o-transform:rotate(90deg); 		/* Opera */
		}
		.actives{
			background: #3eaec8;
			color: #fff!important;
		}
		#content-main{
			overflow-y:hidden!important;
		}
	</style>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
	<div id="wrapper">
		<!--top开始-->

        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                
                	<!-- 标题 -->
                    <li class="nav-header" style="position:fixed;z-index: 2000">
                        <div class="dropdown profile-element" style="width:180px;height:51px;color: #fff;line-height: 50px;font-size:17px;text-align: center;font-weight: 600">
                           <i class="fa fa-th"></i>
                       		 <span class="ng-scope">&nbsp;&nbsp;WAF&nbsp;&nbsp;&nbsp;防&nbsp;&nbsp;&nbsp;护</span>
                        </div>
                        <div class="logo-element" style="width:70px;height:40px;color: #fff;line-height:40px;font-size:17px;text-align: center;font-weight: 600">
                        	 <i class="fa fa-th"></i>
                        </div>
                    </li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs" style="margin-top:60px;">
                    
                    <!-- 概览 -->
                    <li>
                   		<a class="J_menuItem" href="#">
	                     	<span class="nav-label">Web应用防火墙 </span>
                        </a>
	                   	<a class="J_menuItem" href="overview/totalView">
	                    	<i class="fa fa fa-home"></i>
	                    	<span class="nav-label">安全总览 </span>
                       </a>
	                   <a class="J_menuItem" href="config/domainConfig">
	                   		<i class="fa fa fa-gear"></i>
	                   		<span class="nav-label">域名配置 </span>
                       </a>
                       <a class="J_menuItem" href="config/ccConfig">
	                   		<i class="fa fa fa-file"></i>
	                   		<span class="nav-label">cc防护配置 </span>
                       </a>
                       <a class="J_menuItem" href="config/exactConfig">
	                   		<i class="fa fa fa-file"></i>
	                   		<span class="nav-label">精准防护配置 </span>
                       </a>
	               	</li>
                </ul>
            </div>
		</nav>
		
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <ul class="nav navbar-top-links navbar-right">
                    	<li class="dropdown">
	                    	<a href="http://<%=hostname %>/main" style="color:#23b7e5;font-size: 14px;" title='返回主页'>
	                    		<i class="fa fa-home"></i>
	                      	</a>
	                    </li>
	                    <li class="dropdown" style="margin-right: 20px">
                    		<a href="exit" style="color:#ff5e00;font-size: 14px;" title='退出登录'>
                    			<i class="fa fa-sign-out"></i>
                      		</a>
	                    </li>
                    </ul>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main" style="overflow:visible!important">
                <iframe id="J_iframe" width="100%" height="100%" src="overview/totalView" frameborder="0" seamless></iframe>
                	<div id = "">
                		<div class = "page-head">
                			<div id ="total">全部</div>
                		</div>
                	</div>
            </div>
        </div>
        <!--右侧部分结束-->
        
    </div>
    <!--导航结束-->
    
</body>
</html>