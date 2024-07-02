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
	<h1>Item List</h1>
  <div class="container">
	<table>
        <tr>
            <th>ID</th>
            <th>Item Name</th>
            <th>Description</th>
            <th>Starting Price</th>
            <th>Condition</th>
            <th>Duration (hours)</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${listItem}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.itemName}</td>
                <td>${item.description}</td>
                <td>$ ${item.startingPrice}</td>
                <td>${item.condition}</td>
                <td>${item.duration}</td>
                <td><a href = "<%=request.getContextPath()%>/view"><i class="fa-regular fa-thumbs-up fa-xl" style="color: #134e25;"></i></a> <a href="item_edit?id=<c:out value='${item.id}' />"><i class="fa-regular fa-pen-to-square fa-xl" style="color: #113f8d;"></i></a> <a href="item_delete?id=<c:out value='${item.id}' />"><i class="fa fa-trash fa-xl" style="color: #5c0a0a;"></i></a></td>
					
            </tr>
        </c:forEach>
    </table>
</div>

<img alt="" src="images/logo1.png" width = "400px" class="img1">
<img alt="" src="images/logo2.png" width = "500px" class="img2">
  
  
</body>
</html>
