<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //项目的发布路径，例如:  /aws
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <base href="<%=basePath%>">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

<body>
    <h1>Ailbb, Hello World!</h1>
</body>
</html>