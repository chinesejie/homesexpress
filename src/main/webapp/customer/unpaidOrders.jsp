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
						<li class="nav-header">我要寄件</li>
						<li><a href="quickOrderShow.action">快捷下单</a></li>


						<li class="nav-header">我的订单</li>
						<li class="active"><a href="unpaidOrders.action">待支付订单</a></li>
						<li><a href="paidOrders.action">已支付订单</a></li>
						<li class="nav-header">我的运单</li>
						<li><a href="untransportingOrders.action">未完成运单</a></li>
						<li><a href="transportingOrders.action">进行中运单</a></li>
						<li><a href="transportedOrders.action">已完成运单</a></li>

						<li class="nav-header">我的账户</li>
						<li><a href="accountShow.action">我的余额</a></li>
						<li><a href="accountAdd.action">我要充值</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9 main-content">

				<h2 class="title-line">未支付订单</h2>
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
						<c:forEach var="xx" items="${unpaidOrders}" varStatus="i">
							<tr>
							 
								<td>${i.count }</td>
								<td>${xx.receiverName} </td>
								<td>${xx.receiverNumber }</td>
								<td>${xx.receiverAddress }</td>
								<td>2013-8-15</td>
								<td>${xx.weight }</td>
								<td>10元</td>

								<td>
									<div class="btn-group">
										<button class="btn btn-small" onclick="window.location.href='unpaidOrder.action?oid=${xx.oid}'">详情</button>
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

	 



</body>
</html>
