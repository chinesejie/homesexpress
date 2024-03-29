<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0038)http://v3.bootcss.com/examples/signin/ -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="http://v3.bootcss.com/docs-assets/ico/favicon.png">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="http://v3.bootcss.com/dist/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://v3.bootcss.com/examples/signin/signin.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript"
	src="js/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
</head>

<body>

	<div class="container">

		<form class="form-signin" role="form" method="post"
			action="slogin.action">
			<h2 class="form-signin-heading">快递管理后台登录</h2>
			<input name="name" type="text" class="form-control" placeholder="用户名"
				required="" autofocus=""> <input type="password"
				name="password" class="form-control" placeholder="密码" required="">
			<input type="code" name="code" class="form-control" placeholder="验证码"
				required=""> <img id="imgObj" alt="验证码" src="code.action" />
			<a href="#" onclick="javascript:changeImg();">换一张</a>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

	</div>
	<!-- /container -->

	<script type="text/javascript">
		function changeImg() {
			var imgSrc = $("#imgObj");
			var src = imgSrc.attr("src");
			imgSrc.attr("src", chgUrl(src));
		}
		//时间戳   
		//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
		function chgUrl(url) {
			var timestamp = (new Date()).valueOf();
			url = url.substring(0, 17);
			if ((url.indexOf("&") >= 0)) {
				url = url + "×tamp=" + timestamp;
			} else {
				url = url + "?timestamp=" + timestamp;
			}
			return url;
		}
	</script>


</body>
</html>
