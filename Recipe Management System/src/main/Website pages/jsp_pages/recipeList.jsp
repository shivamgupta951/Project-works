<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Recipe List</title>
    <style>
        h1 {
    text-align: center;
    color: #333;
}

table {
    width: 90%;
    margin: 20px auto;
    border-collapse: collapse;
    background: #fff;
    border-radius: 5px;
}

td, th {
    border: 1px solid #ddd;
    padding: 10px;
}

th {
    background-color: #28a745;
    color: white;
    text-transform: uppercase;
}

a {
    display: block;
    text-align: center;
    margin: 20px auto;
    color: #007bff;
}

    </style>
</head>
<body>
    <h1>Available Recipes</h1>
    <table border="1">
        <tr>
            <th>Recipe ID</th>
            <th>Recipe Name</th>
            <th>Ingredients</th>
            <th>Process</th>
            <th>Type</th>
        </tr>
        <%
            // Example data; replace with dynamic data fetched from database
            List<String[]> recipes = (List<String[]>) request.getAttribute("recipes");
            if (recipes != null) {
                for (String[] recipe : recipes) {
                    out.println("<tr>");
                    out.println("<td>" + recipe[0] + "</td>");
                    out.println("<td>" + recipe[1] + "</td>");
                    out.println("<td>" + recipe[2] + "</td>");
                    out.println("<td>" + recipe[3] + "</td>");
                    out.println("<td>" + recipe[4] + "</td>");
                    out.println("</tr>");
                }
            }
        %>
    </table>
    <a href="Home_page/home.html">Back to Home</a>
</body>
</html>
