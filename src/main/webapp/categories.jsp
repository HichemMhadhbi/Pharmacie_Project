<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Categories</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
    <div class="container">
        <h1>Categories</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.categoryId}</td>
                        <td>${category.name}</td>
                        <td>
                    <form action="categories" method="POST" style="display: inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="categoryId" value="${category.categoryId}">
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <hr>
        <h2>Add Category</h2>
        <form action="categories" method="POST">
            <div class="form-group">
                <label for="name">Category Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Category Name" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Category</button>
        </form>
    </div>
</body>
</html>