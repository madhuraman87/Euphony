<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Track Details</title>
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

*,*:before,*:after {
	box-sizing: border-box !important;
}

.row {
	-moz-column-width: 18em;
	-webkit-column-width: 18em;
	-moz-column-gap: 1em;
	-webkit-column-gap: 1em;
}

.item {
	display: inline-block;
	padding: .25rem;
	width: 100%;
}

.well {
	position: relative;
	display: block;
}
</style>

</head>
<body>
	<%@include file="../jsp/Header.jsp"%>
	<%@include file="../jsp/Script.jsp"%>
	<div class="container-fluid" id="container" style="margin-top: 2%;">
		<input type="hidden" id="userid" value="<%=user.getUserid()%>">
		<div class="col-xs-6">
			<!-- Text input-->
			<div class="control-group ">
				<div class="controls">
					<div class="col-xs-2">
						<label class="required" for="album_id" style="display: inline;">Album
							ID:</label>
					</div>
					<div class="col-xs-5">
						<input id="album_id" name="album_id" class="form-control "
							type="text" placeholder="Album ID" style="display: inline;"
							required>
					</div>
				</div>
			</div>

			<br> <br> <br>
			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<div class="col-xs-2">
						<label class="required" for="artist_id" style="display: inline;">Artist
							ID:</label>
					</div>
					<div class="col-xs-5">
						<input id="artist_id" name="artist_id" type="number"
							class="form-control" placeholder="Artist Id"
							style="display: inline;">
					</div>

				</div>
			</div>
			<br> <br> <br>
			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<div class="col-xs-2">
						<label class="required" for="genre_id" style="display: inline;">Genre:</label>
					</div>
					<div class="col-xs-5">
						<input id="genre_id" name="genre_id" type="text"
							class="form-control" placeholder="Genre" style="display: inline;">
					</div>

				</div>
			</div>
			<br> <br> <br>
			<div class="control-group" id="trackdiv">
				<div class="controls">
					<div class="col-xs-2">
						<label class="required" for="track_id" style="display: inline;">Track
							ID:</label>
					</div>
					<div class="col-xs-5">
						<input id="track_id" name="track_id" type="text"
							class="form-control " placeholder="Track ID"
							style="display: inline;" required>
					</div>

				</div>
			</div>
			<br> <br> <br>
			<div class="control-group" id="trackdiv">
				<div class="controls">
					<div class="col-xs-2">
						<label class="required" for="track_id" style="display: inline;">Score:</label>
					</div>
					<div class="col-xs-5">
						<input id="score" name="score" type="text" class="form-control "
							placeholder="Score" style="display: inline;" required>
					</div>

				</div>
			</div>
			<br> <br> <br>


		</div>
		<div class="col-xs-6">
			<!-- Item-->
			<h3 style="text-align: center; color: #1f97c7;">Item
				Recommendations</h3>
			<div class="row">
				<div class="item">
					<div class="well">
						Track ID : <input id="item_trackid_0" name="item_trackid_0"
							class="form-control " style="display: inline;"> <br>
						Score : <input id="item_score_0" name="item_score_0"
							class="form-control " style="display: inline;">
					</div>
				</div>
				<div class="item">
					<div class="well">
						Track ID : <input id="item_trackid_1" name="item_trackid_"
							class="form-control " style="display: inline;"> <br>
						Score : <input id="item_score_1" name="item_score_1"
							class="form-control " style="display: inline;">
					</div>
				</div>
				<div class="item">
					<div class="well">
						Track ID : <input id="item_trackid_2" name="item_trackid_2"
							class="form-control " style="display: inline;"> <br>
						Score : <input id="item_score_2" name="item_score_2"
							class="form-control " style="display: inline;">
					</div>
				</div>
				<div class="item">
					<div class="well">
						Track ID : <input id="item_trackid_3" name="item_trackid_3"
							class="form-control " style="display: inline;"> <br>
						Score : <input id="item_score_3" name="item_score_3"
							class="form-control " style="display: inline;">
					</div>
				</div>
				<div class="item">
					<div class="well">
						Track ID : <input id="item_trackid_4" name="item_trackid_4"
							class="form-control " style="display: inline;"> <br>
						Score : <input id="item_score_4" name="item_score_4"
							class="form-control " style="display: inline;">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="container-fluid" id="container1" style="margin-top: 2%;"> -->
	<div class="col-xs-6">
		<!-- User -->
		<h3 style="text-align: center; color: #1f97c7;">User
			Recommendations</h3>
		<div class="row">
			<div class="item">
				<div class="well">
					Track ID : <input id="user_trackid_0" name="user_trackid_0"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="user_score_0" name="user_score_0"
						class="form-control " style="display: inline;">
				</div>
			</div>
			<div class="item">
				<div class="well">
					Track ID : <input id="user_trackid_1" name="user_trackid_1"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="user_score_1" name="user_score_1"
						class="form-control " style="display: inline;">
				</div>
			</div>

			<div class="item">
				<div class="well">
					Track ID : <input id="user_trackid_2" name="user_trackid_2"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="user_score_2" name="user_score_2"
						class="form-control " style="display: inline;">
				</div>
			</div>

		</div>
	</div>
	<div class="col-xs-6">
		<!-- Personalize -->
		<h3 style="text-align: center; color: #1f97c7;">Personalized
			Recommendations</h3>
		<div class="row">
			<div class="item">
				<div class="well">
					Track ID : <input id="personal_trackid_0" name="personal_trackid_0"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="personal_score_0" name="personal_score_0"
						class="form-control " style="display: inline;">
				</div>
			</div>
			<div class="item">
				<div class="well">
					Track ID : <input id="personal_trackid_1" name="personal_trackid_1"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="personal_score_1" name="personal_score_1"
						class="form-control " style="display: inline;">
				</div>
			</div>
			<div class="item">
				<div class="well">
					Track ID : <input id="personal_trackid_2" name="personal_trackid_2"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="personal_score_2" name="personal_score_2"
						class="form-control " style="display: inline;">
				</div>
			</div>
			<div class="item">
				<div class="well">
					Track ID : <input id="personal_trackid_3" name="personal_trackid_3"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="personal_score_3" name="personal_score_3"
						class="form-control " style="display: inline;">
				</div>
			</div>
			<div class="item">
				<div class="well">
					Track ID : <input id="personal_trackid_4" name="personal_trackid_4"
						class="form-control " style="display: inline;"> <br>
					Score : <input id="personal_score_4" name="personal_score_4"
						class="form-control " style="display: inline;">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf-8"
		src="/euphony/js/trackdetails.js"></script>
</body>
</html>