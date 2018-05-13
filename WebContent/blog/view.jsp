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
<title>${ param.number }<fmt:message key="blog.view.title" /></title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<link rel="stylesheet" href="../static/css/awesome.css">
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/uikit.min.js"></script>
<script type="text/javascript">
	$(function() {
		if ('${ param.author }' == '${ user.getUsername() }') {
			$("#modify").removeClass("uk-hidden");
			$("#remove").removeClass("uk-hidden");
		}
	});
</script>
</head>
<body class="uk-height-1-1">
	<nav class="uk-navbar uk-navbar-attached uk-margin-bottom">
	<div class="uk-container uk-container-center">
		<a href="#" class="uk-navbar-brand"><fmt:message key="menu.blog" /></a>
		<ul class="uk-navbar-nav">
			<li><a href="../home.jsp"><i class="uk-icon-home"></i> <fmt:message
						key="menu.home" /></a></li>
			<li><a href="../blog/edit.jsp"><i class="uk-icon-book"></i>
					<fmt:message key="menu.edit" /></a></li>
			<li><a href="../message/message.jsp"><i
					class="uk-icon-align-left"></i> <fmt:message key="menu.message" /></a></li>
			<li><a href="../message/write.jsp"><i class="uk-icon-edit"></i>
					<fmt:message key="menu.write" /></a></li>
			<li><a href="../picture/picture.jsp"><i class="uk-icon-file"></i>
					<fmt:message key="menu.picture" /></a></li>
			<li><a href="../picture/upload.jsp"><i
					class="uk-icon-arrow-up"></i> <fmt:message key="menu.upload" /></a></li>
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

			<div class="uk-width-medium-3-4">
				<!-- 输出 -->
					<article class="uk-article">
					<h2>
						<a href="view.jsp?number=${ blog.number }&author=${ blog.author }">${ blog.title }</a>
					</h2>
					<p class="uk-article-meta">${ blog.author }
						<fmt:message key="home.published_in" />
						${ blog.create_time }
					</p>
					<p>
						<a id="modify" href="tomodifyblog.do?number=${ blog.number }"
							class="uk-hidden"><fmt:message key="blog.view.modify" /></a> <a
							id="remove" href="remove.do?number=${ blog.number }"
							class="uk-hidden" style="color: red"><fmt:message
								key="blog.view.remove" /></a>
					</p>
					<!-- <p>文章内容</p> -->
					<div class="post-body" itemprop="articleBody">${ blog.text }</div>
					</article>
				<hr class="uk-article-divider">

				<div class="uk-width-medium-3-4">
					<h3>
						<fmt:message key="blog.view.comment" />
					</h3>

					<c:forEach var="comment" items="${ listComment }">
						<c:choose>
							<c:when test="${ comment.username == user.getUsername() }">
								<article class="uk-comment uk-comment-primary"> <header
									class="uk-comment-header"> <img
									class="uk-comment-avatar" src="../static/img/usericon.svg"
									width="50" height="50" alt="">
								<h4 class="uk-comment-title">${ comment.username }</h4>
								<ul class="uk-comment-meta uk-subnav uk-subnav-line">
									<li><span>${ comment.time }</span></li>
									<li><a href="../comment/remove.do?blognumber=${ param.number }&number=${ comment.number }&author=${ param.author }"
										style="color: red"><fmt:message
												key="message.message.remove" /></a></li>
								</ul>
								</header>
								<div class="uk-comment-body">
									<p>${ comment.content }</p>
								</div>
								</article>
								<hr class="uk-article-divider">
							</c:when>
							<c:otherwise>
								<article class="uk-comment"> <header
									class="uk-comment-header"> <img
									class="uk-comment-avatar" src="../static/img/usericon.svg"
									width="50" height="50" alt="">
								<h4 class="uk-comment-title">${ comment.username }</h4>
								<div class="uk-comment-meta">${ comment.time }</div>
								</header>
								<div class="uk-comment-body">
									<p>${ comment.content }</p>
								</div>
								</article>
								<hr class="uk-article-divider">
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>

				<div class="uk-width-medium-3-4">
					<h3>
						<fmt:message key="blog.view.comment_title" />
					</h3>
					<article class="uk-comment">
					<div class="uk-comment-body">
						<form action="../comment/edit.do?blognumber=${ param.number }&author=${ param.author }"
							method="post" id="form-comment" class="uk-form">
							<div class="uk-alert uk-alert-danger uk-hidden"></div>
							<div class="uk-form-row">
								<textarea name="content" rows="6"
									placeholder="<fmt:message key="blog.view.comment_tip" />"
									style="width: 100%; resize: none;"></textarea>
							</div>
							<div class="uk-form-row">
								<button type="submit" class="uk-button uk-button-primary">
									<i class="uk-icon-comment"></i>
									<fmt:message key="blog.view.commented" />
								</button>
							</div>
						</form>
					</div>
					</article>
					<hr class="uk-article-divider">
				</div>
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