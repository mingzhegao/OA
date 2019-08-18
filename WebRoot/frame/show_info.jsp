<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		<form class="form-horizontal col-xs-12" style="margin-top: 25px;" >
			<div class="container ">
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">用户名称:</label>
					<div class=" col-sm-9">
						<input class="form-control " disabled="disabled" value="${sessionScope.user.userName}"  />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">人员名称:</label>
					<div class=" col-sm-9  control-label " style="text-align: left;">
						<input class="form-control " disabled="disabled" value="${sessionScope.person.ppName}"  />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">所在部门:</label>
					<div class=" col-sm-9  control-label " style="text-align: left;">
						<input class="form-control " disabled="disabled" value="${sessionScope.dept.deptName}"  />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">联系方式:</label>
					<div class=" col-sm-9  control-label " style="text-align: left;">
						<input class="form-control " disabled="disabled" value="${sessionScope.person.ppPhone}"  />
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
