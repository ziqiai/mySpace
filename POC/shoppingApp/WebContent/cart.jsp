<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.demo.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CART PAGE</title>
</head>
<body>
	<p><a href="index.jsp">GO BACK HOME PAGE</a></p>
	<p><a href="wishlist.jsp">My Wish List</a></p>
	<p><a href="LogoutServlet">Logout</a></p>

	<jsp:useBean id="cService" class="com.demo.service.CartService" />

	<table class="table table-striped table-bordered table-hover">
		<tr class="table-primary">
			<th>Image</th>
			<th>Product_id</th>
			<th>Quantity</th>
			<th>Modify</th>
			<th>Delete</th>
			<th>Add to Wish List</th>
		</tr>
		<%
			try {
				String uid = String.valueOf(request.getSession().getAttribute("userID"));
				List<Item> itemList = new ArrayList<>();
				itemList = cService.view(uid);
				for (Item item : itemList) {
		%>
		<tr>
			<td><img src=<%=item.getImage()%> width="100" height="100"></td>
			<td><%=item.getProduct_id()%></td>
			<td><%=item.getQuantity()%></td>
			<td>
				<form method="post" action="UpdateCartServlet">
					<div class="form-group">
						<label for="sel">Select list (select quantity):</label> 
						<select	class="form-control" id="sel" name="quantity">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						<input type="hidden" name="product_id" value=<%=item.getProduct_id()%> />
						<input type="submit" value="confirm" /><br>
					</div>
				</form>
			</td>
			<td>
				<form method="post" action="DeleteServlet">
					<input type="hidden" name="product_id" value=<%=item.getProduct_id()%> />
					<input type="submit" value="delete" />
				</form>
			</td>
			<td>
				<form method="post" action="CartServlet">
					<input type="hidden" name="product_id" value=<%=item.getProduct_id()%>>
					<input type="hidden" name="product_image" value=<%=item.getImage()%>>
					<input type="submit" value="add to wishList">
				</form>
			</td>
		</tr>
		<%
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
</body>
</html>
