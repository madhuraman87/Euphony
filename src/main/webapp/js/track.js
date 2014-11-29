var userid;
$(document).ready(function() {	
	
	var trackTable = $('#trackTable').dataTable({
		destroy: true,
		ajax : "/euphony/rest/track/all",
		columns : [{
			"data" : "trackid"
		},{
			"data" : "albumid"
		}, {
			"data" : "artist"
		},{
			"data" : "genre"
		}],
		columnDefs : [ {
			"targets" : [ 4 ],
			"visible" : true,
			"searchable" : false,
			bVisible : true,
			sTitle : 'Action',
			sWidth : '6%',
			mRender : function(data, type, row) {
				return '<a href="#" class="btn btn-primary modbutton">Feedback</a>';
			}
		} ],fnDrawCallback : function(oSettings) {
			$('#trackTable tbody a.modbutton').click(addToCart);
		},
		fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
			
			}
		}
	);

	
});

function addToCart(){
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#trackTable").dataTable();
	var aData = oTable.fnGetData(nTr);		
	var id = aData.trackid;
	getTrackByID(id);
}

function onSubmit(){	
	var feedback = {};
	feedback.userid = userid;
	feedback.trackid = $("#track_id").val();
	feedback.albumid = $("#album_id").val();
	feedback.artistid = $("#artist_id").val();
	feedback.genre = $("#genre_id").val();
	feedback.score = $("#score").val();
	
	console.log("User ID: "+userid);
	console.log("Track ID: "+feedback.trackid);
	console.log("Album ID: "+feedback.albumid);
	console.log("Artist ID: "+feedback.artistid);
	console.log("Genre ID: "+feedback.genre);
	console.log("Score: "+feedback.score);
	
//	addFeedback(feedback);

}

function addFeedback(feedback){				
    var uri='/euphony/rest/feedback/add';
    $.ajax({
	    	type:'POST',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	data: JSON.stringify(feedback),
    	});
}


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
	$('#feedbackModal').modal({
		show : true,
		keyboard : false,
		backdrop : 'static'
	});	
	
	$('#myModalLabel').text('Track Feedback');
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
