<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.demo.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WISHLIST PAGE</title>
</head>
<body>
	<p><a href="index.jsp">GO BACK HOME PAGE</a></p>
	<p><a href="cart.jsp">My Cart</a></p>
	<p><a href="LogoutServlet">Logout</a></p>
	<jsp:useBean id="wishlistService" class="com.demo.service.WishlistService" />
	<table class="table table-striped table-bordered table-hover">
		<tr class="table-primary">
			<th>Image</th>
			<th>Product_id</th>
			<th>Delete</th>
			<th>add to Cart</th>
		</tr>
		<%
			try {
				String uid = String.valueOf(session.getAttribute("userID"));
				if (uid.equals("null")){
					out.println("PLEASE LOGIN TO SEE WISHLIST!!!");
				} else {
					List<Item> itemList = wishlistService.viewAll(uid);
					for (Item item : itemList) {
		%>
		<tr>
			<td><img src=<%=item.getImage()%> width="100" height="100"></td>
			<td><%=item.getProduct_id()%></td>
			<td>
				<form action="WishListServlet?action=delete" method="post">
					<input type="hidden" name="product_id" value=<%=item.getProduct_id()%> />
					<input type="submit" value="delete" />
				</form>

			</td>
			<td>
				<form action="WishListServlet?action=move" method="post">
					<input type="hidden" name="product_id" value=<%=item.getProduct_id()%> />
					<input type="hidden" name="product_image" value=<%=item.getImage()%> />
					<input type="submit" value="add to cart" />
				</form>
			</td>
		</tr>
		<%
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
</table>
</body>
</html>