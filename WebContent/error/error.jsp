<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<fmt:setBundle basename="cn.ciwest.message.blog" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="uk-height-1-1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<script src="../static/js/jquery.min.js"></script>
</head>
<body class="uk-height-1-1"
	style="background-image: url(../static/img/bike.jpg)">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<!-- 登录框 -->
		<div class="uk-vertical-align-middle" style="width: 320px">
			<div id="message" class="uk-alert uk-alert-danger">服务器出现错误，请关闭浏览器</div>
			    异常信息：<br>
    			<s:property value="exception.message"/>  <!-- 输出throw抛出的异常对象 -->
    			<s:property value="exceptionStack"/>     <!-- 输出异常堆栈详细信息，利于调试 -->
    			<s:debug />      <!-- 输出上下文值栈信息 -->
		</div>
	</div>
</body>
</html>