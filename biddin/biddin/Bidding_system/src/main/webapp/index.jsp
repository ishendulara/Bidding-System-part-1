<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<style>
/* Style for the "View Items" button */
html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }

   body {
    display: flex;
    
    background: url('images/bg.jpg') no-repeat center center fixed;
    background-size: cover;
  }

  /* Style for the "View Items" button */
  .view-items-button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #3498db;
    color: #fff;
    border: none;
    border-radius: 5px;
    text-align: center;
    text-decoration: none;
    font-size: 30px;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.2s;
    margin-top: 500px;
    margin-left:100px;
    
  }

  .view-items-button:hover {
    background-color: #2078b2;
    transform: scale(1.05);
  }

  
/* You can customize the button's hover effect by changing the background color and scaling factor. */

</style>
</head>
<body>
<a href = "<%=request.getContextPath()%>/item_list">
<button class="view-items-button">Product Bid Report</button></a>


</body>
</html>