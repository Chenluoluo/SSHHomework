<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="cn.ciwest.message.blog" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="uk-height-1-1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言失败</title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<script src="../static/js/jquery.min.js"></script>
<span style="font-size: 24px;">
	<meta http-equiv="refresh" content="3;URL=../home.jsp">
</span>
</head>
<body class="uk-height-1-1"
	style="background-image: url(../static/img/bike.jpg)">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<!-- 登录框 -->
		<div class="uk-vertical-align-middle" style="width: 320px">
			<div class="uk-alert uk-alert-danger">
				<p>留言失败，三秒后自动跳转...</p>
				<a href="../home.jsp">点击此处立即跳转</a>
			</div>
		</div>
	</div>
</body>
</html>