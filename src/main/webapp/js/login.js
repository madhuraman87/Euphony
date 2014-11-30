$(document).ready(function() {	
	$('#login').bind('click', function() {
		if ($('#loginForm').valid()) {
			var user = {};
			user.userid=$("#userid").val();
			user.password=$("#password").val();
			signin(user);
		}
		
	});
	$('#register').bind('click', function() {		
		var url = "/euphony/jsp/Register.jsp";    
		$(location).attr('href',url);		
	});
	$('#signup').bind('click', function() {	
		if ($('#registerForm').valid()) {
			var user = {};
			user.userid = $("#userid").val();			
			user.password = $("#password").val();			
			signup(user);
		}
	});
	
	validator =  $('#registerForm').validate({    	
		rules:{		
			userid:{required:true},
			password:{required:true}		   
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
	
	
//	validator =  $('#registerForm').validate({    	
//		rules:{		
//			email:{required:true,email: true},
//			password:{required:true}, 
//			fname:{required:true},
//			lname:{required:true}
//		},
//		highlight: function(label) {
//			$(label).closest('.control-group').addClass('error');
//		},
//		unhighlight:function(label){
//			$(label).closest('.control-group').removeClass('error');
//		},
//		success: function(label) {
//			$(label).closest('.control-group').addClass('success');
//		}
//	});	
	
});

function signin(userDetails){				
    var uri='/euphony/rest/user/signin';
    $.ajax({
	    	type:'POST',	
	    	contentType:'application/json',	
	    	url:uri,
	    	data: JSON.stringify(userDetails),
	    	success:userSignIn
    	});
}

function signup(userDetails){    		
    var uri='/euphony/rest/user/signup';
    $.ajax({
	    	type:'POST',	
	    	contentType:'application/json',	
	    	url:uri,
	    	data: JSON.stringify(userDetails),
	    	success:userSignUp
    	});
}

function userSignIn(data, textStatus, jqXHR){
	console.log("Data: "+data.message);
	$("#result").html(data.message);
	if(data.user != null){
		var url = "/euphony/jsp/Album.jsp";    
		$(location).attr('href',url);	
	}
}

function userSignUp(data, textStatus, jqXHR){
	console.log("Data: "+data.message);
	$("#result").html(data.message);
}