<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style2.css">
<title>Candidate</title>
</head>
<body id="candidate">
	
	<main class="main_candidate">


		<div class="container">


			<div class="rowcan1">
				<div class="col">
					<img class="profile_cand" name="pic"
						src="${requestScope.candidate.pic}">



					<p class="candnumber">${requestScope.candidate.id}</p>
					<h2 class="candname">${requestScope.candidate.name}
						${requestScope.candidate.fname}</h2>
				</div>
			</div>
			<!--  just for testing for now -->
			<!--  this is just for testing -->
			<input type='text' name='name' value='${requestScope.candidate.name}'><br>
			<!--  it doesn't get the information some reason -->
			<div class="card">

				<div class="row-info">
					<div class="col-12">
						<div class="textbox">
							<p>
								<span class="party" style="">Minion Party</span>
							</p>
							<p class="age">Age: Unknown</p>
							<p class="city">City: Villain Village</p>
							<p class="profession">Profession: Minion</p>

						</div>
					</div>

					<div class="row-prom">
						<div class="col-12">
							<p class="promote">promoting</p>

						</div>

					</div>
				</div>


			</div>

			<!-- Not sure if we want to have this, can be deleted later -->
			<div class="col">
				<a href="/showanswers.html" class="btn btn-primary">CHECK
					CANDIDATES ANSWERS</a>
			</div>

		</div>
	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>
</body>

</html>