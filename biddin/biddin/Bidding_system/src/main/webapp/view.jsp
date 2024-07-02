<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Item Details</title>
  
  
  
      <link rel="stylesheet" href="css/tablestyle.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

  
</head>

<body>
	<h1>Bidding List</h1>
  <div class="container">
	<table>
        <tr>
            <th>ID</th>
            <th>Item Name</th>
            <th>Description</th>
            <th>Starting Price</th>
            <th>Condition</th>
            <th>Duration (hours)</th>
            
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.itemName}</td>
                <td>${item.description}</td>
                <td>$ ${item.startingPrice}</td>
                <td>${item.condition}</td>
                <td>${item.duration}</td>
                	
            </tr>
        </c:forEach>
    </table>
</div>

<img alt="" src="images/logo1.png" width = "400px" class="img1">
<img alt="" src="images/logo2.png" width = "500px" class="img2">
  
  
</body>
</html>
