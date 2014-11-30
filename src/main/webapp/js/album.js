var userid;
$(document).ready(function() {	
	
	
	var albumTable = $('#albumTable').dataTable({
		destroy: true,
		ajax : "/euphony/rest/album/all",
		columns : [{
			"data" : "albumid"
		}, {
			"data" : "artist"
		},{
			"data" : "genre"
		}]/*,
		columnDefs : [ {
			"targets" : [ 3 ],
			"visible" : true,
			"searchable" : false,
			bVisible : true,
			sTitle : 'Action',
			sWidth : '6%',
			mRender : function(data, type, row) {
				return '<a href="#" class="btn btn-primary modbutton">Feedback</a>';
			}
		} ],fnDrawCallback : function(oSettings) {
			$('#albumTable tbody a.modbutton').click(addToCart);
		}*/,
		fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
			// Row click
			$(nRow).on('click', function() {		
				
				var that = $(this);
				if (that.hasClass('selected') ) {
					that.removeClass('selected');
		        } else {
		        	albumTable.$('tr.selected').removeClass('selected');
		        	that.addClass('selected');
		        }
			});			
			}
		}
	);

	/*$('#feedback_save').bind('click', function(){	
		if ($('#feedbackForm').valid()) {
			onSubmit();
		}
	});*/
});

/*function addToCart(){
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#albumTable").dataTable();
	var aData = oTable.fnGetData(nTr);		
	var id = aData.albumid;
	getAlbumByID(id);
}

function onSubmit(){	
	console.log("hi");
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

}*/

/*function addFeedback(feedback){				
    var uri='/euphony/rest/feedback/add';
    $.ajax({
	    	type:'POST',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	data: JSON.stringify(feedback),
    	});
}
*/


/*function getAlbumByID(id){				
    var uri='/euphony/rest/album/getalbum/'+id;
    $.ajax({
	    	type:'GET',	
	    	contentType:'application/json',	
	    	url:uri,	    	    	
	    	success:populateAlbumFeedback
    	});
}   	

function populateAlbumFeedback(data, textStatus, jqXHR){
	$('#feedbackModal').modal({
		show : true,
		keyboard : false,
		backdrop : 'static'
	});	
	
	$('#myModalLabel').text('Album Feedback');
	$("#album_id").val(data.albumid).attr({
		"disabled":"disabled"
	});
	$("#trackdiv").hide();
	$("#artist_id").val(data.artist).attr({
		"disabled":"disabled"
	});
	$("#genre_id").val(data.genre).attr({
		"disabled":"disabled"
	});
	
}*/
	
