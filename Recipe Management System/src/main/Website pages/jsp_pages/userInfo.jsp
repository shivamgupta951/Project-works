<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>User Information</h1>
    <table border="1">
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>Username</td>
            <td>${requestScope.username}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${requestScope.email}</td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>${requestScope.phone}</td>
        </tr>
        <tr>
            <td>State</td>
            <td>${requestScope.state}</td>
        </tr>
        <tr>
            <td>Premium Status</td>
            <td>${requestScope.premiumStatus}</td>
        </tr>
    </table>
    <a href="Home_page/home.html">Back to Home</a>
</body>
</html>
