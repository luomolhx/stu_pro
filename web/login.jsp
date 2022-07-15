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

</head>
<body>
    <div id="main">
        <div id="inner">
            <form>
                用户：&nbsp<input type="text" id="u_id"/>
                <br><br>
                密码：&nbsp<input type="password" id="u_pwd"/>
                <br><br>
                <table>
                    <tr>
                        <td><button id="btn01">重置</button></td>
                        <td><button id="btn02">登录</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
