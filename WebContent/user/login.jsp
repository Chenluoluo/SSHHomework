<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="cn.ciwest.ssh.message.blog" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="uk-height-1-1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="user.login.title" /></title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<script src="../static/js/jquery.min.js"></script>
<script type="text/javascript">
	function checklogin(form) {
		if (form.username.value == "") {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.login.username_message" />');
			})
			form.username.focus();
			return false;
		}
		if (form.password.value == "") {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.login.password_message" />');
			})
			form.password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body class="uk-height-1-1"
	style="background-image: url(../static/img/bike.jpg)">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<!-- 登录框 -->
		<div class="uk-vertical-align-middle" style="width: 320px">
			<!-- 登陆表单 -->
			<form action="login.do"
				onsubmit="return checklogin(this)"
				class="uk-panel uk-panel-box uk-form">
				<!-- 标题图标和文字 -->
				<p style="font-size: 34px; margin: 30px">
					<b><fmt:message key="user.login.form_title" /></b>
				</p>
				<!-- 提示信息 -->
				<div id="message" class="uk-alert uk-alert-danger uk-hidden"></div>
				<!-- 用户名 -->
				<div class="uk-form-row">
					<div class="uk-form-icon uk-width-1-1">
						<i class="uk-icon-envelope-o"></i> <input v-model="uusername" id="username"
							name="userModel.username" type="text" placeholder="<fmt:message key="user.login.username" />" maxlength="50"
							class="uk-width-1-1 uk-form-large">
					</div>
				</div>
				<!-- 密码 -->
				<div class="uk-form-row">
					<div class="uk-form-icon uk-width-1-1">
						<i class="uk-icon-lock"></i> <input v-model="passwd" id="password"
							name="userModel.password" type="password" placeholder="<fmt:message key="user.login.password" />" maxlength="50"
							class="uk-width-1-1 uk-form-large">
					</div>
				</div>
				<!-- 登录按钮 -->
				<div class="uk-form-row">
					<button type="submit"
						class="uk-width-1-1 uk-button uk-button-large">
						<i class="uk-icon-sign-in"></i> <fmt:message key="user.login.login" />
					</button>
				</div>
			</form>
			<div class="uk-form-row">
				<a href="register.jsp">
					<button type="submit"
						class="uk-width-1-1 uk-button uk-button-large uk-button-primary"
						>
						<i class="uk-icon-sign-in"></i> <fmt:message key="user.login.register" />
					</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>