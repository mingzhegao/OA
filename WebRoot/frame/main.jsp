<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<style type="text/css">
			html,body{
				width: 100%;
				height: 100%;
			}
			@media only screen and (min-width:768px ) {
				.navbar-side{
					height: 100%;
				}
				.navbar-side > .row{
					height: 100%;
				}
				.navbar-side > .row > .nav-pills{
					height: 100%;
				}
			}
			
			.nav-inside{
				padding-left: 15px;
				/*background-color: #444444;*/
				background-color: white;
			}
			.navbar-side > .row > .nav-pills >li a{
				/*color: lightgray;*/
				color: black;
			}
			.navbar-side > .panel > .panel-body > .nav-pills > li > ul >li{
				transition: padding 0.3s;
			}
			.navbar-side > .panel > .panel-body > .nav-pills li > ul >li:hover{
				padding-left: 10px;
			}
			#main-title{
				animation-name: xuanzhuan;
				animation-duration: 2s;
				animation-iteration-count: infinite;
			}
			@keyframes xuanzhuan{
				
				from{transform:perspective(100px) rotateY(0deg);}
				to{transform:perspective(100px) rotateY(360deg);}
			}
			.oa-content{
				padding: 0px;
			}
			object{
				margin: 0px;
				width: 100%;
				height: 110%;
				
				background:linear-gradient(white,#ebebeb,white);
			}
			.daohang{
				background-color: papayawhip;
				
			}
			.panel{
				height: 100%;
				margin-right: -5px;
				margin-left: -5px;
			}
			.navbar-left .form-group .nav li a{
				color: #4762F5;
			}
			.navbar-left .form-group .nav li a:hover{
				border-radius : 10px;
				background-color:#FFFFCC;
				color: blue;
			}
		</style>
	</head>
	<body>
		
		<nav class="nav navbar-inverse daohang" >
			<div class="nav navbar-header">
				<a class="navbar-brand navbar-inverse" id="main-title" href="#">Turing</a>
				<button class="navbar-toggle" data-toggle="collapse" data-target=".daohang">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse daohang" id="daohang">
				
				<div class="navbar-form navbar-left" >
					<div class="form-group "   >
						<ul class="nav navbar-nav ">
							<c:forEach items="${sessionScope.topList }" var="topMenu">
								<li>
									<a href="javascript:showMenu('${topMenu.menuId }')">
										${topMenu.menuName}
									</a>
								</li>
							</c:forEach>
							<li >
								<a href="#" class="text-muted" data-toggle="dropdown">
									<span class="glyphicon glyphicon-user" >：${sessionScope.person.ppName}</span>
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a target="right" href="<%=ctx %>/jsp/system/user/password.jsp">修改密码</a></li>
									<li class="divider"></li>
									<li><a href="#exit-modal" data-toggle="modal">退出登录</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
		<div class="col-sm-3 col-md-2  navbar-side daohang" style="height: 130%">
			<div class="panel panel-default">
				<div class="panel-body" style="overflow: auto;">
				<ul class="nav nav-pills nav-stacked navbar-default" id="leftUl">
				<c:forEach items="${oneList }" var="leftMenu" varStatus="i">
					<c:if test="${leftMenu.menuIslink=='2' && leftMenu.menuPare==pid}">
						<li>
							<a  href="#" data-toggle="collapse" data-target="#menu${i.count}" ><span class="glyphicon glyphicon-chevron-right"></span>${leftMenu.menuName}</a>
							<ul class="collapse nav nav-pills nav-stacked nav-inside" id="menu${i.count}">
								<c:forEach items="${leftMenu.menuList }" var="leftMenu1" >
									<c:if test="${leftMenu1.menuIslink=='3' && leftMenu1.menuPare==leftMenu.menuId}">
										<li><a href="<%=ctx %>/${leftMenu1.menuUrl}" target="right">${leftMenu1.menuName}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:if>
				</c:forEach>	
				</ul>
			
				</div>
			</div>
		</div>
		<div class="col-sm-9 col-md-10 oa-content" style="height: 130%;">
			<div class="panel panel-default">
				<div class="panel-body">
					<object style="" name="right" type="text/html" data="<%=ctx%>/frame/show_info.jsp"></object>
				</div>
			</div>
		</div>
		<div class="modal fade" id="exit-modal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: rgba(0,0,0,0.1)">
						<div class="modal-title">
							<span class="glyphicon glyphicon-log-out">退出登录</span>
							<span class="close" data-dismiss="modal">&times;</span>
						</div>
					</div>
					<div class="modal-body">
						<h1>确认退出吗？</h1>
					</div>
					<div class="modal-footer" >
						<button onclick="layout()" class="btn btn-primary">退出</button>
						<button class="btn btn-default" data-dismiss="modal">取消</button>
					</div>	
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		//退出登录
		function layout(){
			$.post("<%=ctx%>/login/layout.action",function(){
				location.href="<%=ctx%>/index.jsp";
			},"text");
		}
		
		window.onload=function(){
			if($(document).width()<=768){
				$(".navbar-side").addClass("collapse");
			}else{
				$(".navbar-side").removeClass("collapse");
			}
		};
		$("a").popover();
		
		function showMenu(pid){
			var url = "<%=ctx%>/login/menuLeft.action";
			data = "pid="+pid;
			$.post(url,data,function(msg){
				var ul = $("#leftUl");
				var info = "";
				for(i in msg){
					var leftMenu = msg[i];
					if(leftMenu.menuIslink=='2' && leftMenu.menuPare==pid){
						info+="<li><a  href='#' data-toggle='collapse' data-target='#menu"+(i+1)+"' ><span class=\"glyphicon glyphicon-chevron-right\"></span>"+leftMenu.menuName+"</a><ul class='collapse nav nav-pills nav-stacked nav-inside' id='menu"+(i+1)+"'>";
						for(j in leftMenu.menuList){
							var leftMenu1 = leftMenu.menuList[j];
							info+="<li><a href='<%=ctx %>/"+leftMenu1.menuUrl+"' target='right'>"+leftMenu1.menuName+"</a></li>";
						}
						info+="</ul></li>";
					}
				}
				ul.html(info);
			},"json");
		}
	</script>
</html>
