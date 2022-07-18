<%--
  Created by IntelliJ IDEA.
  User: 李杭潇
  Date: 2022/7/15
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录页面</title>
    <style>
        #main{
            width: 400px;
            height: 300px;
            margin-top: 200px;
            margin-left: auto;
            margin-right: auto;
            background-color: #31b0d5;
            border: black solid 2px;
        }
        #inner{
            width: 200px;
            height: auto;
            margin-left: 100px;
            margin-top: 50px;
        }
    </style>

    <script src="js/jquery.js"></script>

</head>
<body>
    <div id="main">
        <div id="inner">
            <form action="/stu_pro/loginServlet" method="post">
                用户：&nbsp<input name="username" type="text" id="u_id"/>
                <br><br>
                密码：&nbsp<input name="password" type="password" id="u_pwd"/>
                <br><br>
                <table>
                    <tr>
                        <td><button id="btn01">重置</button></td>
                        <td><input type="submit" id="btn02" value="登录"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>

</html>
