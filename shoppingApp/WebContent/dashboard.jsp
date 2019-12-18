<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
<%@ page import="com.demo.model.*"%>
<%@ page import="com.demo.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enjoy Your Shopping Here!</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Welcome to the store!</h2>
	<p><a href="cart.jsp">My Cart</a></p>
	<p><a href="wishlist.jsp">My Wish List</a></p>
	<p><a href="LogoutServlet">Logout</a></p>
	<form>
	<table class="table table-striped table-bordered table-hover">
	<tr class="table-primary">
		<!-- <th>ID</th> -->
		<th>Image</th>
		<th>Name</th>
		<th>Price</th>
		<th>Add to Cart</th>
		<th>Like it!</th>
	</tr>
<%
	try {
		ProductService service = new ProductService();
		List<Product> list = service.viewAll();
		for (Product pro : list) {
%>
			<tr>
				<%-- <td><%=pro.getId()%></td> --%>
				<td><img src=<%=pro.getImage()%> width="100" height="100"></td>
				<td><%=pro.getName()%></td>
				<td><%=pro.getPrice()%></td>
				<td>
					<form method="post" action="ShopServlet">
						<input type="hidden" name="product_id" value=<%=pro.getId()%> />
						<input type="hidden" name="product_image" value=<%=pro.getImage()%> />
						<label>QUANTITY
							<input name="quantity" />
						</label><br>
						<input type="submit" value="add to cart" />
					</form>
				</td>
				<td>
					<form method="get" action="WishlistServlet">
						<input type="hidden" name="product_id" value=<%=pro.getId()%> />
						<input type="hidden" name="product_image" value=<%=pro.getImage()%> />
						<button type="submit"><img src="images/love.png" width="30" height="30"></button>
					</form>
				</td>
			</tr>
<%
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
	</table>
	</form>
<%
	Integer uid = (Integer) request.getSession().getAttribute("userID");
	System.out.println("SessionID:" + uid);
%>
</body>
</html>