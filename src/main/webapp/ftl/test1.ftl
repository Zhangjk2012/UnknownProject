<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>  
<#list users as user>  
username : ${user.username}<br/>  
password : ${user.password}  
</#list>  
</body>  
</html> 