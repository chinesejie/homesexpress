<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0040)http://v2.bootcss.com/examples/hero.html -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>首页，平台介绍</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="http://v2.bootcss.com/assets/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="http://v2.bootcss.com/assets/css/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon"
	href="http://v2.bootcss.com/assets/ico/favicon.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="">一家快递</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a
							href="">首页</a></li>
						<li><a href="">关于我们</a></li>
						 
						 
					</ul>
					<form class="navbar-form pull-right" action="clogin.action"
						method="post">
						<input class="span2" type="text" name="name" placeholder="邮箱">
						<input class="span2" type="password" name="password"
							placeholder="密码">
						<button type="submit" class="btn">登录</button>
					</form>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>欢迎!</h1>
			<p>
				该网站引用bootstrap界面UI，SSH作为后台框架，搭建一个基于快递物流体系的简易平台系统。 <br />应用部署于sina云之上，同时接入微信订阅号，
				<br />集桌面应用与移动应用的特性于一身。
				<br />tips://开源的东西一直跟微软格格不入，最好使用chrome或者firefox等非IE内核的浏览器体验该网站。
			</p>
			<p>
				<a href="adminSignin.jsp" class="btn btn-primary btn-large">后台管理登陆
					 »</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Bootstrap</h2>
				<p>Bootstrap是Twitter推出的一个开源的用于前端开发的工具包。它由Twitter的设计师Mark Otto和Jacob Thornton合作开发，是一个CSS/HTML框架。Bootstrap提供了优雅的HTML和CSS规范，它即是由动态CSS语言Less写成。</p>
				<p>
					<a class="btn" href="http://www.bootcss.com/">View
						更多 »</a>
				</p>
			</div>
			<div class="span4">
				<h2>SSH</h2>
				<p>由Struts、Spring Framework、Hibernate组成的常见JAVA网上开发框架组合的缩称，struts2.0 已经在现在的开发中略显臃肿，该平台不使用struts了，而是由spring MVC作为control层的构建框架。但struts是不可忘怀的，继续使用SSH这个名字。</p>
				<p>
					<a class="btn" href="http://spring.io/">View
						更多 »</a>
				</p>
			</div>
			<div class="span4">
				<h2>新浪云</h2>
				<p>Sina App Engine（简称SAE）是新浪研发中心于2009年上旬开始内部开发，并在2009年11月3日正式推出第一个Alpha版本的国内首个公有云计算平台。</p>
				<p>
					<a class="btn" href=" ">View
						更多 »</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>© 一家快递 2013</p>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>
