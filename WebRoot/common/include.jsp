<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.turingedu.com/tag/page" prefix="page" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
    <link href="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/jquery-2.2.4.min .js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/preview/preview.js"></script>
</head>
<%
	String ctx = request.getContextPath();
%>
