<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medicament Management System - Add Medicament</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container">
        <h1>Add Medicament</h1>
        <form action="save.do" method="POST">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Medicament Name">
            </div>
            <div class="form-group">
                <label for="department">Category</label>
                <select class="form-control" name="category" id="category">
                    <c:forEach var="category" items="${categoryModel.categories}">
                        <option value="${category.categoryId}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" name="quantity" id="quantity" placeholder="Quantity">
            </div>
            <div class="form-group">
                <label for="prix">Price</label>
                <input type="number" step="0.01" class="form-control" name="prix" id="prix" placeholder="Price">
            </div>
            <button type="submit" class="btn btn-primary">Save Medicament</button>
        </form>
    </div>
</body>
</html>
