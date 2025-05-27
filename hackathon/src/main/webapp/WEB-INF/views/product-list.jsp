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
        <a href="${pageContext.request.contextPath}/products/add">Thêm mới danh mục</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm </th>
                <th>Mô tả</th>
                <th>Giá sản phẩm</th>
                <th>Ảnh</th>
                <th>Ngày tạo</th>
                <th>Trạng thái</th>
            </tr>
            <c:forEach var="c" items="${products}">
                <tr>
                    <td>${c.product_id}</td>
                    <td>${c.product_name}</td>
                    <td>${c.description}</td>
                    <td>${c.price}</td>
                    <td>${c.image}</td>
                    <td>${c.created_at}</td>
                    <td>${c.status}</td>
                    <td>
                        <a href="/products/edit/${c.product_id}">Sửa</a>
                        <a href="/products/delete/${c.product_id}" onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

