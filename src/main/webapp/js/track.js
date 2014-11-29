
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
	//$("#trackdiv").show();
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
