<%@ page contentType="text/html;charset=UTF-8"
         language="java"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet"
        href="/css/bootstrap.css" />
  <style>
    table td{
      vertical-align: middle!important;
    }
    #queryForm input{
      width: 150px;
    }
  </style>
</head>
<body>
<h1>欢迎您，【${user.username}】,<a href="">退出</a> </h1>
<table style="width: 650px;height: 400px;text-align: center"
       align="center"
       class="table table-bordered table-hover">
  <caption><h3 style="text-align: center">学生管理系统</h3></caption>
  <tr>
    <td colspan="7">
      <form action="/mvc/studentServlet?method=studentList"
            id="queryForm" class="form-inline" method="post">
        <div class="form-group">
          <input type="text"
                 class="form-control"
                 id="exampleInputEmail3"
                 name="sname" value="${sname}"
                 placeholder="请输入姓名">
        </div>
        <div class="form-group">
          <input type="text"
                 class="form-control"
                 id="exampleInputPassword3"
                 name="age" value="${age}"
                 placeholder="请输入年龄">
        </div>
        <button type="submit" class="btn btn-primary">查询</button>
      </form>
    </td>
    <td>
      <button class="btn btn-warning">添加学生</button>
      <button onclick="deleteBatch()" class="btn btn-primary">批量删除</button>
    </td>
  </tr>
  <tr>
    <th>
      <input type="checkbox" >
    </th>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    <th>年级</th>
    <th>地址</th>
    <th>移动电话</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${students}" var="student">
    <tr>
      <td>
        <input class="son" value="${student.sid}" type="checkbox" >
      </td>
      <td>${student.sname}</td>
      <td>${student.gender}</td>
      <td>${student.age}</td>
      <td>${student.grade}</td>
      <td>${student.address}</td>
      <td>${student.mPhone}</td>
      <td>
        <button  class="btn btn-danger" onclick="deleteStu(${student.sid})">删除</button>
        <a href="/mvc/studentServlet?method=toUpdateView&sid=${student.sid}" class="btn btn-success">修改</a>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="8">
      <nav aria-label="Page navigation">
        <ul class="pagination">
          <c:choose>
            <c:when test="${pageNum > 1}">
              <li>
                <a href="/mvc/studentServlet?method=studentList&page=${pageNum-1}&sname=${sname}&age=${age}" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
            </c:when>
          </c:choose>

          <c:forEach begin="1" end="${pages}" var="page">
            <c:choose>
              <c:when test="${page == pageNum}">
                <li class="active">
                  <a href="/mvc/studentServlet?method=studentList&page=${page}&sname=${sname}&age=${age}">
                      ${page}
                  </a>
                </li>
              </c:when>
              <c:otherwise>
                <li>
                  <a href="/mvc/studentServlet?method=studentList&page=${page}&sname=${sname}&age=${age}">
                      ${page}
                  </a>
                </li>
              </c:otherwise>
            </c:choose>

          </c:forEach>
          <c:if test="${pageNum < pages}">
            <li>
              <a href="/mvc/studentServlet?method=studentList&page=${pageNum+1}&sname=${sname}&age=${age}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </c:if>

        </ul>
      </nav>
    </td>
  </tr>
</table>
</body>
</html>
<script src="/js/jquery.js"></script>
<script>
  function deleteStu(sid){
    let ok = confirm("确认删除该条数据吗？");
    if(ok){
      location.href = "/mvc/studentServlet?method=deleteStu&sid="+sid;
    }
  }

  function deleteBatch(){
    let sids = [];
    //获取勾中的son 1,2,3,4,5
    $('.son:checked').each(function (){
      sids.push($(this).val());
    });
    //发送删除请求
    //join:把数组中内容默认以,号形式拼接成字符串，也可以指定凤戈夫
    location.href = "/mvc/studentServlet?method=deleteBatch" +
            "&sid="+sids.join();
  }
</script>
