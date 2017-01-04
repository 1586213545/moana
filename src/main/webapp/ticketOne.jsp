<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>电影票抢票系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />

<!-- ajax异步请求，获取剩余票数，如果部署环境变化，需更改url地址 -->
<script type="text/javascript">
	function showInfo() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//回调函数
		xmlhttp.onreadystatechange = function() {
			//alert(xmlhttp.readyState);
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var respText = xmlhttp.responseText;
				// alert(respText);  
				var jsonT = eval("(" + respText + ")");
				document.getElementById("info").innerHTML = "剩余票数:<br> "
						+ jsonT.info;
			}
		}
		/*url根据部署环境改变  */
		var url = "http://localhost:8080/moana/loadInfo";
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>


</head>
<body>
	<!--每三秒调用一次ajax,实现实时更新数据  -->
	<script language=javascript>
		var int = self.setInterval("clock()", 3000)
		function clock() {
			showInfo();

		}
	</script>
	<div class="container">

		<header>
			<h1>
				您的邮箱地址为 : <span><s:property value="#session.email" /></span>
			</h1>

			<h1>
				<div id="info">
					剩余票数:</br>
					<s:property value="#application.ticketRemain" />
				</div>

				<div id="tip">
					<s:property value="#request.tip" />
				</div>
				<h1 />
				<h1>请选择电影票种类:</h1>
				<form action="rob" method="post">
					<br /> <input type="radio" name="ticketName" value="The Godfather"
						checked>
					<h2>The Godfather</h2>
					<br> <input type="radio" name="ticketName" value="12 Angry Men">
					<h2>12 Angry Men</h2>
					<br> <input type="radio" name="ticketName" value="Star Wars">
					<h2>Star Wars</h2>
					<br> <input type="submit" value="点击抢票"
						style="background:;width:80px;height:40px;" />

				</form>
				<br> <br>
				<h1>
					<a href="index.jsp">点击重新登录</a>
				</h1>
		</header>


	</div>
</body>
</html>