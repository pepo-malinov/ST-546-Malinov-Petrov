$("#login-button").on("click", function() {

	var email = $("#email").val();
	var password = $("#password").val();

	$.ajax({
		method : "POST",
		url : "LoginServlet",
		data : {
			email : email,
			password : password
		}
	}).done(function(response) {
		console.log(response);
		window.location = response;
	});
})


$("#confirm-register").on("click", function(e){
	$("#register-form").submit();
})