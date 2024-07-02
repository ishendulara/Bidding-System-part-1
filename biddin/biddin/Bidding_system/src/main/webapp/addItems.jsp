<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item - Online Bidding System</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- You can link your custom CSS here -->
</head>
<body>
    <div class="container">
    
        <h1>
        	<c:if test="${item != null}">
            	<span>Edit</span> Details
			</c:if>
			<c:if test="${item == null}">
			 	<span>Add</span> Item
        	</c:if>
        </h1>
        
        <c:if test="${item != null}">
             <form action="item_update" method="post" >
        </c:if>
        <c:if test="${item == null}">
			  <form action="item_insert" method="post" >
		</c:if>
        	
        	<c:if test="${item != null}">
              <input type="hidden" name="id" value="<c:out value='${item.id}' />" />
        	</c:if>
        
            <label for="itemName">Item Name :</label>
            <input type="text" id="itemName" name="itemName" value="<c:out value='${item.itemName}' />"required>
            
            <label for="description">Description :</label>
            <textarea id="description" name="description" rows="4"  required> <c:out value='${item.description}' /> </textarea>
            
            <label for="startingPrice">Starting Price :</label>
            <input type="number" id="startingPrice" name="startingPrice" value="<c:out value='${item.startingPrice}' />" required>
            
            
            <label for="name">Item Condition :</label>
          	<select class="box" name ="condition">
            <option selected>
              <c:if test="${item != null}">
                    <c:out value='${item.condition}' />
			  </c:if>
              <c:if test="${item == null}">
                     Choose Condition
              </c:if>
            </option>
            <option value="Brand New">Brand New</option>
            <option value="Used">Used</option>
          	</select>
            
            <label for="duration">Auction Duration (In Hours):</label>
            <input type="number" id="duration" name="duration" value="<c:out value='${item.duration}' />" required>
            
 			<button type="submit"> <c:if test="${item != null}">  Update Details </c:if> <c:if test="${item == null}"> Add Now </c:if> </button>        
        </form>
    </div>
</body>
</html>
