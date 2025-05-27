<%--
  Created by IntelliJ IDEA.
  User: dungp
  Date: 5/27/2025
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><title>Thêm/Sửa danh mục</title></head>
    <body>
        <form:form method="POST" modelAttribute="category" enctype="multipart/form-data">
            <div>
                <label>Tên danh mục:</label>
                <form:input path="category_name"/>
                <form:errors path="category_name" cssClass="error"/>
            </div>
            <div>
                <label>Mô tả:</label>
                <form:input path="description"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <div>
                <label>Trạng thái:</label>
                <form:select path="status">
                    <form:option value="0">Không hoạt động</form:option>
                    <form:option value="1">Hoạt động</form:option>
                </form:select>
            </div>
            <button type="submit">Lưu</button>
        </form:form>
        <a href="${pageContext.request.contextPath}/categories">Quay lại danh sách</a>
    </body>
</html>

