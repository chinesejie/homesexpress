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


</script>
</head>

<body>

	<%@include file="../common/top.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">我要寄件</li>
						<li ><a href="quickOrderShow.action">快捷下单</a></li>


						<li class="nav-header">我的订单</li>
						<li  ><a href="unpaidOrders.action">待支付订单</a></li>
						<li class="active"><a href="paidOrders.action">已支付订单</a></li>
						<li class="nav-header">我的运单</li>
						<li ><a href="untransportingOrders.action">未完成运单</a></li>
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
				<h2 class="title-line">已经支付订单详情</h2>
				<div class="progress progress-info progress-striped">
					<div class="bar" style="width: 100%"></div>
				</div>
				<form class="form-horizontal">
					<!-- <div class="alert alert-error hide">
						<button class="close" data-dismiss="alert"></button>
						您的输入有误
					</div>
					<div class="alert alert-success hide">
						<button class="close" data-dismiss="alert"></button>
						验证成功!
					</div> -->
					<input type="hidden" id="oid" value="${quickOrder.oid}"> </input>
					<div class="control-group">
						<label class="control-label">发件人姓名</label>
						<div class="controls">
							<input type="text" name="senderName" required="true"
								class="span4 m-wrap" value="${quickOrder.senderName}"
								disabled="disabled"><font
								style="font-weight: bold; font-size: 16px;" color="red">*</font>
							<span for="name" class="help-inline"></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">发件人电话</label>
						<div class="controls">
							<input name="senderNumber" type="text" required="true"
								class="span4 m-wrap" value="${quickOrder.senderNumber}"
								disabled="disabled""> <font
								style="font-weight: bold; font-size: 16px;" color="red">*</font>
							<span for="tel" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">发件人地址</label>
						<div class="controls">
							<input type="text" name="senderProvince" id="province"
								placeholder="省" value="${quickOrder.senderAddress}"
								disabled="disabled" /> <font
								style="font-weight: bold; font-size: 16px;" color="red">*</font>
							<span for="address" class="help-inline"></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">收件人姓名</label>
						<div class="controls">
							<input type="text" name="receiverName"
								value="${quickOrder.receiverName}" disabled="disabled"
								required="true" class="span4 m-wrap"><font
								style="font-weight: bold; font-size: 16px;" color="red">*</font>
							<span for="name" class="help-inline"></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">收件人电话</label>
						<div class="controls">
							<input name="receiverNumber" type="text" required="true"
								class="span4 m-wrap" value="${quickOrder.receiverNumber}"
								disabled="disabled"> <font
								style="font-weight: bold; font-size: 16px;" color="red">*</font>
							<span for="tel" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">收件人地址</label>
						<div class="controls">
							<input type="text" id="province" placeholder="省"
								name="receiverProvince" value="${quickOrder.receiverAddress}"
								disabled="disabled" /> <font
								style="font-weight: bold; font-size: 16px;" color="red">*</font>
							<span for="address" class="help-inline"></span>
						</div>
					</div>


					<div class="control-group">
						<label class="control-label">物品重量</label>
						<div class="controls">
							<input name="weight" type="text" class="span4 m-wrap"
								value="${quickOrder.weight}" disabled="disabled" number="true">
							(公斤)<span for="weight" class="help-inline"></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">备注</label>
						<div class="controls">
							<textarea   rows="2" id="remark" name="note" maxlength="20"
								class="span4" style="resize: none;" 
								disabled="disabled">${quickOrder.note}</textarea>
							<span for="note" class="help-block">注: 备注不能超过20个字.</span>
						</div>
					</div>

					
				</form>

			</div>
			<!-- span9 -->
		</div>
		<!--/row-->



		<footer>
			<p>© xxx 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	 
	<script src="Ajax.js">
		
	</script>


</body>
</html>
