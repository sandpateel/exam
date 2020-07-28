<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Security Example</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script></head>
<body>
<div>

		<form action="/logout" method="post" >
			<button type="submit" class="btn btn-danger" style="float:right">Log Out</button>
			<input type="hidden" name="${_csrf.parameterName}"
				   value="${_csrf.token}"/>
		</form>
<div class="container" style="margin:50px;border: 1px solid green;">
	<div>
			<h3>Welcome </h3>
	
    </div>
    

</div>

</div>
</body>
</html>