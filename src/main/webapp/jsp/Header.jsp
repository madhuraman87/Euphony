<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.rest.model.UserView"
    import="com.rest.model.User"
    %>
    <%
    UserView userView= (UserView) request.getSession().getAttribute("user");
    User user = userView.getUser();
  
	%>

<div id='cssmenu'>
	<ul style="left: 20%;">
		<li><a href='/euphony/jsp/Album.jsp'>Euphony</a></li>

		<li><a href="/euphony/jsp/Track.jsp">Tracks</a></li>
		<li><a href="/euphony/jsp/Album.jsp">Albums</a></li>
		<li><a href="/euphony/jsp/ShoppingCart.jsp">Shopping Cart</a></li>
		<li><a href="/euphony/jsp/UserProfile.jsp">User Profile</a></li>
		<li><a href='#' style="left: 30%;">Welcome <%=user.getUserid()%> !</a></li>
		<li><a href='/euphony/jsp/Login.jsp' style="left: 120%">Logout</a></li>

	</ul>
</div>
