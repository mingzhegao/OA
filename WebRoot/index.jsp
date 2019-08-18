<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<style type="text/css">
			html,body{
				height: 100%;
				display: flex;
				width: 100%;
				background-image: url(images/login/1349109563392088389.jpg);
			}
			.login{
			
				height: auto;
				margin: auto;
			}
			.tab-content{
				margin-top: 15px;
				
			}
			.form-control{
				background-color: rgba(0,0,30,0.2);
				color: white;
			}
			
		</style>
	</head>
	<body>
		<div class="login col-xs-12 col-md-5">
			<div class="  panel " style="background-color: rgba(0,0,30,0.2);" >
				<div class="panel-heading">
					<div class="panel-title text-center" style="color: white;font-size: x-large;">
						系统登录
					</div>
				</div>
				<div class="tab-content">
					<form class="form-horizontal" name="userLoginForm" action="<%=ctx %>/login/login.action"  method="post">
						<div class="form-group   ">
							<div class="input-group col-xs-offset-1 col-xs-10">
								<label class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
								</label>
								<input type="text" id="userName" name="userName" value="admin" class="form-control" required placeholder="请输入用户账号" />
							</div>
						</div>
						<div class="form-group">
							<div class="input-group col-xs-offset-1 col-xs-10">
								<label class="input-group-addon">
									<span class="glyphicon glyphicon-pencil"></span>
								</label>
								<input type="password" id="userPass" name="userPass" value="admin" required placeholder="请输入用户密码" class="form-control"  />
							</div>
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-default" >登录</button>
							<button type="reset" class="btn btn-primary" >清空</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	$(function(){
		var arr=["1349109563392088389.jpg"
				,"1375005261331698523.jpg"
				,"1467047578716070913.jpg"
				,"161848111708759040.jpg"
				,"2020427382929234967.jpg"
				,"2029716057160704972.jpg"
				,"2065744854179650341.jpg"
				,"26177172851989173.jpg"
				,"2874422462269319179.jpg"
				,"3093409994068022529.jpg"
				,"3857051605966499771.jpg"
				,"4856287773289047193.jpg"
				,"6597261081681170076.jpg"
				,"6598134093912150825.jpg"
				,"711005791271265196.jpg"
				,"729583139734395697.jpg"];
		$("body").css("background-image","url(images/login/"+arr[parseInt(Math.random()*arr.length)]+")");
	});
	//登录验证
	document.getElementById("userName").oninput = function(){
		document.getElementById("userName").setCustomValidity("");
	};
	document.getElementById("userPass").oninput = function(){
		document.getElementById("userPass").setCustomValidity("");
	};
	document.getElementById("userName").oninvalid = function(){
		document.getElementById("userName").setCustomValidity("登录名不可为空!");
	};
	document.getElementById("userPass").oninvalid = function(){
		document.getElementById("userPass").setCustomValidity("登录密码不可为空!");
	};

</script>