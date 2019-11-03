<%@page import="uni.fmi.st.models.User"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="user" scope="session" class="uni.fmi.st.models.User"></jsp:useBean>
<%
	User user2 = new User();
	// add user to session
	//session.setAttribute("user", user2);
	User currentUser = (User)session.getAttribute("currentUser");
 	// redirect to index.html if login user does not exist.
	/* if(null == currentUser){
		response.sendRedirect("index.html");
		return;
	} */
%>
<%-- set email to user --%>
<%-- <jsp:setProperty property="email" name="user" value="email@tst.com" /> --%>

<%-- set user properties from request --%>
<jsp:setProperty property="*"  name="user"/>
<% user2.setEmail("email@tst.com"); %>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Weather App</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap&subset=cyrillic"
	rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">

</head>

<body>




	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="container">

			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">Начало <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Приятели</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Известия</a>
					</li>
					<li class="nav-item active"><a class="nav-link" href="#">Профил</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Изход</a></li>
				</ul>
			</div>

		</div>

	</nav>

	<div class="container mt-5">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-header">
						Профил
						<%=new Date()%>
						||
						<%
						out.print(new Date());
					%>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="user">Потребител</label> <input type="text"
										class="form-control" id="user" placeholder="Въведи потребител"
										<%-- set value from session currentUser --%>
										<%-- value="<%=((User) session.getAttribute("currentUser")).getUsername()%>"> --%>
										value='<jsp:getProperty property="username" name="user"/>'>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Email</label> <input type="email"
										class="form-control" id="email" placeholder="Въведи email"
										value="<jsp:getProperty property="email" name="user"/>">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="password">Парола</label> <input type="password"
										class="form-control" id="password" placeholder="Въведи парола"
										value="<jsp:getProperty property="password" name="user"/>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="repeat-password">Повтори парола</label> <input
										type="password" class="form-control" id="repeat-password"
										placeholder="Повтори парола" value="<jsp:getProperty property="password" name="user"/>">
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer d-flex justify-content-end">
						<button id="publish" type="button" class="btn btn-primary">Запази</button>
					</div>
				</div>
			</div>

		</div>




	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="js/login.js"></script>
</body>


</html>