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
	});
})