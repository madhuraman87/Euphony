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
</style>

</head>
<body>
	<%@include file="../jsp/Header.jsp"%>
	<%@include file="../jsp/Script.jsp"%>
	<div class="container-fluid" id="container" style="margin-top: 2%;">
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

		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
		<div class="control-group">
			<div class="controls">
				<div class="col-xs-2">
					<label class="required" for="type" style="display: inline;">Feedback</label>
				</div>
				<div class="col-xs-5">
					<input id="feedback" name="feedback" type="number"
						class="form-control " placeholder="Feedback Score"
						style="display: inline;" required>
				
				</div>
		<div class="col-xs-2">
				 <input id="feedback_save" class="button btn-primary"  type="submit" value="Submit Feedback" style="display: inline;"/>
				 </div>
			</div>
		</div>

</div>
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

		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
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
		<br>
		<br>
		<br>
		<div class="control-group">
			<div class="controls">
				<div class="col-xs-2">
					<label class="required" for="type" style="display: inline;">Feedback</label>
				</div>
				<div class="col-xs-5">
					<input id="feedback" name="feedback" type="number"
						class="form-control " placeholder="Feedback Score"
						style="display: inline;" required>

				</div>

			</div>
		</div>

</div>
	</div>
<script type="text/javascript" charset="utf-8"
	src="/euphony/js/trackdetails.js"></script>

</body>
</html>