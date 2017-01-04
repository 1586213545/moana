<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en" class="no-js">
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
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<div class="codrops-top">
			<span class="right"> </span>
			<div class="clr"></div>
		</div>
		<header>
			<h1>
				电影票抢票系统<span></span>
			</h1>

		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form action="login" autocomplete="on" method="post">
							<h1>请登录</h1>
							<p>
								<label for="username" class="uname" data-icon="u">
									请输入您的邮箱 </label> <input id="username" name="email"
									required="required" type="email" />
							</p>
							<p class="login button">
								<input type="submit" value="登录" />
							</p>
							
	</form>

						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>