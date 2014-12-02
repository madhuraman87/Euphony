var userid;
var original_score;
$(document).ready(function() {	
	userid = $("#userid").val();
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
		} ,{
			"targets" : [ 5 ],
			"visible" : true,
			"searchable" : false,
			bVisible : true,
			sTitle : 'Action',
			sWidth : '6%',
			mRender : function(data, type, row) {
				return '<a href="#" class="btn btn-primary addbutton">Add to Cart</a>';
			}
		} ],fnDrawCallback : function(oSettings) {
			$('#trackTable tbody a.modbutton').click(addFeedback);
			$('#trackTable tbody a.addbutton').click(addToCart);
		},
		fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
			var oTable = $("#trackTable").dataTable();
			var aData = oTable.fnGetData(nRow);	
			$('td:eq(0)', nRow).html('<a href="#"  onclick="openTrackDetails(\''+aData.trackid+'\')"><strong>'+aData.trackid+'</strong></a>');
			}
		}
	);

	$('#feedback_save').bind('click', function(){	
		if ($('#feedbackForm').valid()) {
			onSubmit();
		}
	});
});

function openTrackDetails(arg0){	
	var url=encodeURIComponent(arg0);	
	window.open('/euphony/jsp/TrackDetails.jsp?trackid=' + url, 'trackdetails');
}

function addFeedback(){
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#trackTable").dataTable();
	var aData = oTable.fnGetData(nTr);		
	var id = aData.trackid;
	getFeedbackScore(userid,id);
	getTrackByID(id);
	
}

function addToCart(){
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#trackTable").dataTable();
	var aData = oTable.fnGetData(nTr);		
	var id = aData.trackid;
	var shoppingCart = {};
	shoppingCart.userid = userid;
	shoppingCart.trackid = id;
	shoppingCart.albumid= aData.albumid;
	insertItem(shoppingCart);
	
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


function insertItem(shoppingcart){				
    var uri='/euphony/rest/shoppingcart/add';
    $.ajax({
	    	type:'POST',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	data: JSON.stringify(shoppingcart),
    	});
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
