var userid;
var original_score;
$(document).ready(function() {	
	userid = $("#userid").val();
	var shoppingCartTable = $('#shoppingCartTable').dataTable({
		destroy: true,
		ajax : "/euphony/rest/shoppingcart/allshoppingcartitems/"+userid,
		columns : [{
			"data" : "trackid"
		},{
			"data" : "albumid"
		}],
		fnDrawCallback : function(oSettings) {
			
		},
		fnRowCallback: function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
			
			}
		}
	);

});