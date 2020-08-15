<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function restful(){
	var username = $("#username").val();
	var password = $("#password").val();
	$.ajax({
		//地址
		url : "${pageContext.request.contextPath }/user/"+username+"/"+password,
		//提交方式
		type : "GET",
		//发送请求时所传递的参数
		//返回的数据使用json
		dataType : "json",
		//成功
		success : function(data){
			if(data != null){
				alert("用户名为："+data.user_code+"，密码为："+data.user_password);
				//console.log("用户名为："+data.username+"，密码为："+data.password);
			}
		}
	});
}
</script>
</head>
<body>
                     
                    
	用户名：<input type="text" name="user_code" id="username"/><br/>
	密码：<input type="password" name="user_password" id="password"/><br/>
	<input type="button" value="测试" onclick="restful()"/>
</body>
</html>