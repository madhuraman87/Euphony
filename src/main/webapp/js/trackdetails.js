var trackid;
$(document).ready(function() {
	console.log("inside: ");
	url= window.location.href;
	url = url.split("=");
	trackid = url[1];
	console.log("trackid: "+trackid);
	getTrackByID(trackid);
});

function getTrackByID(id){				
    var uri='/euphony/rest/track/gettrack/'+id;
    $.ajax({
	    	type:'GET',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	success:populateTrackFeedback
    	});
}   	

function populateTrackFeedback(data, textStatus, jqXHR){

	$("#album_id").val(data.albumid).attr({
		"disabled":"disabled"
	});
	
	$("#artist_id").val(data.artist).attr({
		"disabled":"disabled"
	});
	$("#genre_id").val(data.genre).attr({
		"disabled":"disabled"
	});
	$("#track_id").val(data.trackid).attr({
		"disabled":"disabled"
	});
	
}