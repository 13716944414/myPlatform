<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery/jquery-2.1.4.min.js"></script>
</head>

<body>
	This is my JSP page.
	<br><%=path%>
	<script type="text/javascript">
	
		$(function() {
			var contextPath = getContextPath();
			$.ajax({
				url : contextPath + "/user/page",
				type : "post",
				dataType : "json",
				data : {
					currentPage : 1,
					pageSize : 5
				},
				success : function(data){
					console.info(data);
				}
			});
		})
		
		/**
		 * 获得上下文
		 * @returns
		 */
		function getContextPath() {
			var pathName = document.location.pathname;
			var index = pathName.substr(1).indexOf("/");
			var result = pathName.substr(0, index + 1);
			return result;
		}
	</script>
</body>
</html>
