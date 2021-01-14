<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String hostname = request.getServerName();
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="REFRESH" content="0;url=http://<%=hostname %>/login?server=http://<%=hostname %>/newcdn/waf"/>
</head>
</html>