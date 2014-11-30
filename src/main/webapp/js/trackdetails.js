var userid;
var trackid;
$(document).ready(function() {	
	userid = $("#userid").val();
	console.log("userid: "+userid);
	url= window.location.href;
	url = url.split("=");
	trackid = url[1];
	getTrackByID(trackid);
	getFeedbackScore(userid,trackid);
	getAllItemRecommendationByID(userid);
	getAllUserRecommendationByID(userid);
	getAllPersonalizeRecommendationByID(userid);
	
});

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

function getAllItemRecommendationByID(userid){				
    var uri='/euphony/rest/recommendation/getAllItemRecommendation/'+userid;
    $.ajax({
	    	type:'GET',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	success:populateItemRecommendation
    });
} 

function populateItemRecommendation(data, textStatus, jqXHR){
	
	var trackid = "#item_trackid_";
	var scoreid = "#item_score_";
	
	for(var i=0;i < data.length;i++){
		
		$(trackid+i).val(data[i].trackid).attr({
			"disabled":"disabled"
		});
		
		$(scoreid+i).val(data[i].score).attr({
			"disabled":"disabled"
		});
	}
	
	
}

function getAllUserRecommendationByID(userid){				
    var uri='/euphony/rest/recommendation/getAllUserRecommendation/'+userid;
    $.ajax({
	    	type:'GET',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	success:populateUserRecommendation
    });
} 

function populateUserRecommendation(data, textStatus, jqXHR){
	
	var trackid = "#user_trackid_";
	var scoreid = "#user_score_";

	for(var i=0;i < data.length;i++){
		
		$(trackid+i).val(data[i].trackid).attr({
			"disabled":"disabled"
		});
		
		$(scoreid+i).val(data[i].score).attr({
			"disabled":"disabled"
		});
	}	
	
}


function getAllPersonalizeRecommendationByID(userid){				
    var uri='/euphony/rest/recommendation/getAllPersonalizeRecommendation/'+userid;
    $.ajax({
	    	type:'GET',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	success:populatePersonalizeRecommendation
    });
} 

function populatePersonalizeRecommendation(data, textStatus, jqXHR){
	
	var trackid = "#personal_trackid_";
	var scoreid = "#personal_score_";

	for(var i=0;i < data.length;i++){
		
		$(trackid+i).val(data[i].trackid).attr({
			"disabled":"disabled"
		});
		
		$(scoreid+i).val(data[i].score).attr({
			"disabled":"disabled"
		});
	}	
	
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