<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medicament Management System - Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container">
        <h1>Medicament Management System</h1>
        <form action="chercher.do" method="GET">
            <div class="form-group">
                <label for="keyword">Search</label>
                <input type="text" class="form-control" name="keyword" id="keyword" placeholder="Keyword">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
        <hr>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Medicament ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Prix</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="medicament" items="${medicamentModel.medicaments}">
                    <tr>
                        <td>${medicament.medicamentId}</td>
                        <td>${medicament.name}</td>
                        <td>${medicament.quantity}</td>
                        <td>${medicament.prix}</td>
                        <td>
                            <a href="supprimer.do?id=${medicament.medicamentId}" class="btn btn-danger">Delete</a>
                            <a href="editer.do?id=${medicament.medicamentId}" class="btn btn-primary">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="saisie.do" class="btn btn-success">Add Medicament</a>
    </div>
</body>
</html>
