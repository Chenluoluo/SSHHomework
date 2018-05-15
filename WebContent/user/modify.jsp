<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<fmt:setBundle basename="cn.ciwest.ssh.message.blog" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="user.modify.title" /></title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<link rel="stylesheet" href="../static/css/awesome.css">
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/uikit.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#vm').show();
	});
</script>
</head>
<body class="uk-height-1-1">
	<nav class="uk-navbar uk-navbar-attached uk-margin-bottom">
	<div class="uk-container uk-container-center">
		<a href="#" class="uk-navbar-brand"><fmt:message key="menu.blog" /></a>
		<ul class="uk-navbar-nav">
			<li><a href="../tohome.do"><i class="uk-icon-home"></i> <fmt:message
						key="menu.home" /></a></li>
			<li><a href="../blog/edit.jsp"><i class="uk-icon-book"></i>
					<fmt:message key="menu.edit" /></a></li>
			<li><a href="../message/tomessage.do"><i
					class="uk-icon-align-left"></i> <fmt:message key="menu.message" /></a></li>
			<li><a href="../message/write.jsp"><i class="uk-icon-edit"></i>
					<fmt:message key="menu.write" /></a></li>
			<li><a href="../picture/topicture.do"><i class="uk-icon-file"></i>
					<fmt:message key="menu.picture" /></a></li>
			<li><a href="../picture/upload.jsp"><i class="uk-icon-arrow-up"></i>
					<fmt:message key="menu.upload" /></a></li>
		</ul>
		<div class="uk-navbar-flip">
			<ul class="uk-navbar-nav">
				<li class="uk-parent" data-uk-dropdown><a href="#"><i
						class="uk-icon-user"></i> ${ user.getUsername() }</a>
					<div class="uk-dropdown uk-dropdown-navbar">
						<ul class="uk-nav uk-nav-navbar">
							<li><a href="../user/modify.jsp"><i class="uk-icon-cog"></i>
									<fmt:message key="menu.modify_information" /></a></li>
						</ul>
					</div></li>
				<li><a href="../user/logout.do"><i class="uk-icon-sign-in"></i>
						<fmt:message key="menu.logout" /></a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="uk-container uk-container-center">
		<div class="uk-grid">
			<!-- content -->
			<div class="uk-width-1-1 uk-margin-bottom">
				<div class="uk-panel uk-panel-box">
					<ul class="uk-breadcrumb">
						<li><a href="../home.jsp"><fmt:message key="menu.home" /></a></li>
						<li><a href="../picture/picture.jsp"><fmt:message
									key="menu.picture" /></a></li>
						<li><a href="../comment/comment.jsp"><fmt:message
									key="menu.message" /></a></li>
					</ul>
				</div>
			</div>

			<div id="vm" class="uk-width-2-3">
				<form action="modify.do"
					class="uk-form uk-form-stacked">
					<div class="uk-alert uk-alert-danger uk-hidden"></div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message
								key="user.modify.username" /></label>
						<div class="uk-form-controls">
							<input readonly v-model="username" name="userModel.username" type="text"
								placeholder="${ user.getUsername() }" value="${ user.getUsername() }" class="uk-width-1-1">
						</div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message
								key="user.modify.name" /></label>
						<div class="uk-form-controls">
							<input v-model="name" rows="1" name="userModel.name"
								placeholder="<fmt:message
								key="user.modify.name" />"
								value="${ user.getName() }" class="uk-width-1-1"">
						</div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message
								key="user.modify.email" /></label>
						<div class="uk-form-controls">
							<input v-model="email" rows="1" name="userModel.email"
								placeholder="your-name@example.com" value="${ user.getEmail() }"
								class="uk-width-1-1"">
						</div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message
								key="user.modify.phone" /></label>
						<div class="uk-form-controls">
							<input v-model="phone" rows="1" name="userModel.phone"
								placeholder="<fmt:message
								key="user.modify.phone" />"
								value="${ user.getPhone() }" class="uk-width-1-1"">
						</div>
					</div>
					<div class="uk-form-row">
						<button type="submit" class="uk-button uk-button-primary">
							<i class="uk-icon-save"></i>
							<fmt:message key="user.modify.save" />
						</button>
						<a href="../home.jsp" class="uk-button"><i
							class="uk-icon-times"></i> <fmt:message key="user.modify.cancel" /></a>
						<a href="remove.do" class="uk-button uk-button-danger"><i
							class="uk-icon-times-circle"></i> <fmt:message
								key="user.modify.delete_account" /></a>
					</div>
				</form>
			</div>
			<!-- // content -->
		</div>
	</div>

	<div class="uk-margin-large-top"
		style="background-color: #eee; border-top: 1px solid #ccc;">
		<div class="uk-container uk-container-center uk-text-center">
			<div class="uk-panel uk-margin-top uk-margin-bottom">
				<p>
					<a target="_blank" href="http://weibo.com/u/5661149316"
						class="uk-icon-button uk-icon-weibo"></a> <a target="_blank"
						href="https://github.com/chenluoluo"
						class="uk-icon-button uk-icon-github"></a> <a target="_blank"
						href="http://www.linkedin.com/in/chenluoluo"
						class="uk-icon-button uk-icon-linkedin-square"></a> <a
						target="_blank" href="https://twitter.com/chenluoluo"
						class="uk-icon-button uk-icon-twitter"></a>
				</p>
				<p>
					Powered by <a href="http://www.ciwest.cn">ChenLuoLuo</a>. Copyright
					2017. [<a href="#">Manage</a>]
				</p>
				<p>
					<a href="http://www.ciwest.cn" target="_blank">www.ciwest.cn</a>.
					All rights reserved.
				</p>
			</div>

		</div>
	</div>
</body>
</html>