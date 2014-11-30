var userid;
var original_score;
$(document).ready(function() {	
	userid = $("#userid").val();
	var feedbackTable = $('#feedbackTable').dataTable({
		destroy: true,
		ajax : "/euphony/rest/feedback/all/"+userid,
		columns : [{
			"data" : "trackid"
		},{
			"data" : "score"
		}],
		columnDefs : [ {
			"targets" : [ 2 ],
			"visible" : true,
			"searchable" : false,
			bVisible : true,
			sTitle : 'Action',
			sWidth : '6%',
			mRender : function(data, type, row) {
				return '<a href="#" class="btn btn-primary modbutton">Feedback</a>';
			}
		} ],fnDrawCallback : function(oSettings) {
			$('#feedbackTable tbody a.modbutton').click(addFeedback);
		},
		fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
			
			}
		}
	);

	$('#feedback_save').bind('click', function(){	
		if ($('#feedbackForm').valid()) {
			onSubmit();
		}
	});
});


function addFeedback(){
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#feedbackTable").dataTable();
	var aData = oTable.fnGetData(nTr);		
	var id = aData.trackid;
	getFeedbackScore(userid,id);
	getTrackByID(id);
	
}

function onSubmit(){	
	var feedback = {};
	feedback.userid = userid;
	feedback.trackid = $("#track_id").val();	
	var new_feedback = $("#feedback").val();
	feedback.score = new_feedback;	
	console.log("User ID: "+userid);
	console.log("Track ID: "+feedback.trackid);	
	console.log("Score: "+feedback.score);
	if(original_score == 0 ){	
		console.log("add");
		insertFeedback(feedback);
	}else{
		console.log("update");
		updateFeedback(feedback);
	}


}

function insertFeedback(feedback){				
    var uri='/euphony/rest/feedback/add';
    $.ajax({
	    	type:'POST',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	data: JSON.stringify(feedback),
    	});
}

function updateFeedback(feedback){				
    var uri='/euphony/rest/feedback/update';
    $.ajax({
	    	type:'PUT',	
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

function getFeedbackScore(userid,trackid){				
    var uri='/euphony/rest/feedback/getfeedback/'+userid+"/"+trackid;
    $.ajax({
	    	type:'GET',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	success:populateFeedback
    	});  
}   

function populateFeedback(data, textStatus, jqXHR){
	original_score = data.score;
	console.log("Original Score: "+original_score);
	
	$("#score").val(data.score).attr({
		"disabled":"disabled"
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
