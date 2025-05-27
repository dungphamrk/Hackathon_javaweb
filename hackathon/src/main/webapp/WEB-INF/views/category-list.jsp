<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dungp
  Date: 5/27/2025
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Hệ thống quản lý danh mục</h1>
        <a href="${pageContext.request.contextPath}/categories/add">Thêm mới danh mục</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Mô tả</th>
                <th>Trạng thái</th>
            </tr>
            <c:forEach var="c" items="${categories}">
                <tr>
                    <td>${c.category_id}</td>
                    <td>${c.category_name}</td>
                    <td>${c.description}</td>
                    <td>${c.status}</td>
                    <td>
                        <a href="/categories/edit/${c.category_id}">Sửa</a>
                        <a href="/categories/delete/${c.category_id}" onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
