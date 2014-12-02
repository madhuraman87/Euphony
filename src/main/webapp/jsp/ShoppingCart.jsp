<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<style type="text/css">
@media screen and (min-width: 768px) {
	.custom-class {
		width: 60%;
		/* either % (e.g. 60%) or px (400px) */
	}
	label.required:after {
		content: ' *';
		color: #b94a48;
		display: inline;
	}
}

.selected>td {
	border: 1px solid red;
	background-color: #b0bed9;
}

;
/* New styles below */
label.valid {
	width: 24px;
	height: 24px;
	background: url(../img/valid.png) center center no-repeat;
	display: inline-block;
	text-indent: -9999px;
	color: green;
}

label.error {
	font-weight: bold;
	color: red;
	padding: 2px 8px;
	margin-top: 2px;
}

.content {
	padding: 10px;
	border: 1px solid #eee;
}

tbody {
	font-size: 12px;
}

label.required:after {
	content: ' *';
	color: #b94a48;
	display: inline;
}

div.label_required:after {
	content: '* = Required';
	color: #b94a48;
	display: inline;
	margin-left: 20px;
}

div.error_msg {
	display: inline;
	color: #B94A48;
	margin-left: 20px;
}

table.table th {
	text-align: center;
}
</style>

</head>
<body>
	<%@include file="../jsp/Header.jsp"%>
	<%@include file="../jsp/Script.jsp"%>
	<div class="container-fluid" id="container">
	
		<div class="col-xs-12 row well">
			<h4 style="font-size: 20px; color: #317eac; text-align: center;"
				title="Tracks">Shopping Cart</h4>

			<input type="hidden" id="userid" value="<%=user.getUserid() %>">
			<table class="table table-bordered pretty" id="shoppingCartTable">
				<thead>
					<tr>
						<th style="text-align: center;">Track ID</th>
						<th style="text-align: center;">Album ID</th>
					
					</tr>
				</thead>
			</table>

		</div>
		
	</div>

	<script type="text/javascript" charset="utf-8"
		src="/euphony/js/shoppingcart.js"></script>

</body>
</html>