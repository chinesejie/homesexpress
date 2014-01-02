<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://v2.bootcss.com/examples/fluid.html -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Home Express</title>
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

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
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

	<%@include file="../common/top.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">初始件处理</li>
						<li><a href="gettingExpress.action">待收件</a></li>
						<li><a href="flushingExpress.action">待发件</a></li>

						<li class="nav-header">终点件订单</li>
						<li><a href="arrivingExpress.action">待达订单</a></li>
						<li><a href="sendingExpress.action">待派订单</a></li>
						<li class="active"><a href="signingExpress.action">待签收单</a></li>
						<li class="nav-header">已成订单</li>
						<li><a href="finalExpress.action">已成订单</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9 main-content">

				<h2 class="title-line">待签订单</h2>
				<div class="progress progress-info progress-striped">
					<div class="bar" style="width: 20%"></div>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>收件人姓名</th>
							<th>收件人手机</th>
							<th>收件人地址</th>
							<th>预约派件时间</th>
							<th>重量</th>
							<th>代收货款</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="xx" items="${express}" varStatus="i">
							<tr>

								<td>${i.count }</td>
								<td>${xx.receiverName}</td>
								<td>${xx.receiverNumber }</td>
								<td>${xx.receiverAddress }</td>
								<td>${xx.orderTime }</td>
								<td>${xx.weight }</td>
								<td>10元</td>

								<td>
									<div class="btn-group">
										<button class="btn btn-small" id="${i.count }"
											onclick="javascript:add1ToStatus(${i.count },${xx.oid},'signExpress.action')">确认签收</button>
									
										<button class="btn btn-small dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>

									</div>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>


			</div>
			<!-- span9 -->
		</div>
		<!--/row-->



		<footer>
			<p>© xxx 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->
	<script src="mAjax.js">
		
	</script>



</body>
</html>
