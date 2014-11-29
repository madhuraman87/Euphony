var rowID;
var isAdd = false;
var productCategory;
var userid;
var originalQty = null;
var originalPrice;
$(document).ready(function() {	
	userid = $("#userid").val();
	$('#addProduct').bind('click', function(){
		resetAll();
		isAdd = true;
		console.log("inside");
		catalogajax.getCatalogs(function(data, s, xph) {	
			console.log("inside1");
		    $('#productCategory').find("option:gt(0)").remove();		
		    for (var i=0; i< data.aaData.length; i++ ) {	    	
		    	 	var K=$('<option/>').append(data.aaData[i].name);				
				$('#productCategory').append(K);
		    }
		   
		});
	});
	

	
	
	$('a[data-dismiss],button[data-dismiss]').click((function(){
		  resetAll();
	  }));
	
	validator =  $('#productForm').validate({    	
		rules:{		
			name:{required:true},
		    quantity:{
                required:  {
                    depends:function(){
                        $(this).val($.trim($(this).val()));
                        return true;
                    }   
                },
            customqty: true},
		    price:{required:true}, 
		    description:{required:true},
		    productCategory:{required:true}
		},
		highlight: function(label) {
			$(label).closest('.control-group').addClass('error');
		},
		unhighlight:function(label){
			$(label).closest('.control-group').removeClass('error');
		},
		success: function(label) {
			$(label).closest('.control-group').addClass('success');
		}
	});	
	 $('a[data-dismiss],button[data-dismiss]').click((function(){
			validator.resetForm();
		  }));
	$('#product_save').bind('click', function(){	
		if ($('#productForm').valid()) {
			onSubmit();
		}
	});
	
	jQuery.validator.addMethod("customqty", function(value, element) {
		if(originalQty != null){
		      if(originalQty >=  value)
	               return true;
	        else
	                 return false;
			}else{
				return true;
			}
		}, "Please specify the quantity lesser than the available quantity");
	
	

	
});


function onSubmit(){	
    var product = {};
    product.name = $("#name").val();
    product.description = $("#description").val();
    product.quantity = $("#quantity").val();
    product.price = $("#price").val();
    product.productCategory = $("#productCategory").val();
	if(isAdd){		
		productajax.addProduct(product);
	}else{
		var shoppingCartItem = {};
		shoppingCartItem.userid = userid;
		shoppingCartItem.id = rowID;
		shoppingCartItem.name = $("#name").val();
		shoppingCartItem.description = $("#description").val();
		shoppingCartItem.quantity = $("#quantity").val();
		var price = originalPrice * shoppingCartItem.quantity;
		shoppingCartItem.price = price;
		shoppingCartItem.productCategory = productCategory;
		
		shoppingcartajax.addToCart(shoppingCartItem);
		
	}
}

function resetAll(){	
	$('#productModal').modal({backdrop:'static',show : true});
	$('#myModalLabel').text('Add Product');
	$('#productForm')[0].reset();	
	$("#name").removeAttr('disabled');
	$("#description").removeAttr('disabled');
	$("#price").removeAttr('disabled');
	$("#productCategory").removeAttr('disabled');
	isAdd = false;	
}

function addToCart(){
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#productTable").dataTable();
	var aData = oTable.fnGetData(nTr);		
	var id = aData.id;
	productCategory = aData.productCategory;
	rowID = id;
	originalQty = aData.quantity;
	originalPrice = aData.price;
	productajax.getProduct(rowID,productCategory);
}

function populateProduct(data, textStatus, jqXHR){
	$('#productModal').modal({
		show : true,
		keyboard : false,
		backdrop : 'static'
	});	
	
	$('#myModalLabel').text('Add To Cart');
	$("#name").val(data.name).attr({
		"disabled":"disabled"
	});
	
	$("#description").val(data.description).attr({
		"disabled":"disabled"
	});
	$("#quantity").val(data.quantity);
	$("#price").val(data.price).attr({
		"disabled":"disabled"
	});
	
	$('#productCategory').empty();
	var K=$('<option/>').append(data.productCategory);				
	$('#productCategory').append(K).attr({
		"disabled":"disabled"
	});;
	
}