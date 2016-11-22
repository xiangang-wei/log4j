<%--
  Created by IntelliJ IDEA.
  User: xiangang
  Date: 2016/11/22
  Time: 上午11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户登陆界面</title>
  <style type="text/css">
    div{
      margin: auto;
      border: gray 1px solid;
      width: 40%;
    }
  </style>
</head>
<body>
<div>
  <form action="login" method="post">
    <table>
      <tr>
        <td>用户名：<input type="text" name="userName" /></td>
      </tr>
      <tr>
        <td>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="提交" /></td>
        <td><input type="reset" value="重置" /></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
