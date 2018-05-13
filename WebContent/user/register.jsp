<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="cn.ciwest.ssh.message.blog" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="uk-height-1-1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="user.register.title" /></title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<script src="../static/js/jquery.min.js"></script>
<script type="text/javascript">
	function checkregister(form) {
		if (form.username.value == "") {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.register.username_message" />');
			})
			form.username.focus();
			return false;
		}
		if (form.name.value == "") {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.register.name_message" />');
			})
			form.name.focus();
			return false;
		}
		if (form.email.value == "") {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.register.email_message" />');
			})
			form.email.focus();
			return false;
		}
		if (form.password.value == "") {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.register.password_message" />');
			})
			form.password.focus();
			return false;
		}
		if (form.password1.value == form.password.value) {
			$("#message").addClass("uk-hidden");
			return true;
		} else {
			$(document).ready(function(e) {
				$("#message").removeClass("uk-hidden");
				$('#message').html('<fmt:message key="user.register.repassword_message" />');
			})
			form.password1.focus();
			return false;
		}

	}
</script>
</head>
<body class="uk-height-1-1"
	style="background-image: url(../static/img/bike.jpg)">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<!-- 登录框 -->
		<div class="uk-vertical-align-middle" style="width: 320px">
			<!-- 登陆表单 -->
			<form method="post" action="register.do"
				onsubmit="return checkregister(this)"
				class="uk-panel uk-panel-box uk-form">
				<!-- 标题图标和文字 -->
				<p style="font-size: 34px; margin: 30px">
					<b><fmt:message key="user.register.form_title" /></b>
				</p>
				<!-- 提示信息 -->
				<div id="message" class="uk-alert uk-alert-danger uk-hidden"></div>
				<!-- 用户名 -->
				<div class="uk-form-row">
					<label class="uk-form-label"><fmt:message
							key="user.register.username" /></label>
					<div class="uk-form-controls">
						<input name="userModel.username" v-model="username" id="username" type="text"
							maxlength="50"
							placeholder="<fmt:message key="user.register.username" />"
							class="uk-width-1-1">
					</div>
				</div>
				<!-- 姓名 -->
				<div class="uk-form-row">
					<label class="uk-form-label"><fmt:message
							key="user.register.name" /></label>
					<div class="uk-form-controls">
						<input name="userModel.name" v-model="name" id="name" type="text" maxlength="50"
							placeholder="<fmt:message key="user.register.name" />"
							class="uk-width-1-1">
					</div>
				</div>
				<!-- 电子邮件 -->
				<div class="uk-form-row">
					<label class="uk-form-label"><fmt:message
							key="user.register.email" /></label>
					<div class="uk-form-controls">
						<input name="userModel.email" v-model="email" id="email" type="text" maxlength="50"
							placeholder="your-name@example.com" class="uk-width-1-1">
					</div>
				</div>
				<!-- 电话 -->
				<div class="uk-form-row">
					<label class="uk-form-label"><fmt:message
							key="user.register.phone" /></label>
					<div class="uk-form-controls">
						<input name="userModel.phone" v-model="phone" id="phone" type="text" maxlength="50"
							placeholder="<fmt:message key="user.register.phone" />"
							class="uk-width-1-1">
					</div>
				</div>
				<!-- 输入密码 -->
				<div class="uk-form-row">
					<label class="uk-form-label"><fmt:message
							key="user.register.password" /></label>
					<div class="uk-form-controls">
						<input name="userModel.password" v-model="password" id="password" type="password"
							maxlength="50" placeholder="<fmt:message key="user.register.password" />"
							class="uk-width-1-1">
					</div>
				</div>
				<!-- 重复密码 -->
				<div class="uk-form-row">
					<label class="uk-form-label"><fmt:message
							key="user.register.repassword" /></label>
					<div class="uk-form-controls">
						<input name="userModel.password1" v-model="password1" id="password1" type="password"
							maxlength="50"
							placeholder="<fmt:message key="user.register.repassword" />"
							class="uk-width-1-1">
					</div>
				</div>
				<!-- 注册按钮 -->
				<div class="uk-form-row">
					<button type="submit"
						class="uk-width-1-1 uk-button uk-button-large">
						<fmt:message key="user.register.register" />
					</button>
				</div>
			</form>
			<div class="uk-form-row">
				<a href="login.jsp">
					<button type="submit"
						class="uk-width-1-1 uk-button uk-button-large uk-button-primary">
						<i class="uk-icon-sign-in"></i>
						<fmt:message key="user.register.login" />
					</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>