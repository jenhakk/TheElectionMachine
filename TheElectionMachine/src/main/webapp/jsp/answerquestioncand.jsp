<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Questions"%>

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
<link rel="stylesheet" href="css/style2.css">
<title>Candidates questions</title>
</head>


<body id="candque">

	<div class="container">

		<div class="row" id="row-ansque">

			<div class="col-6">
				<form action="" method="post" class="candform">

					<div class="row" style="margin-bottom: 5px;">
						<div class="col">
							<label for="candi">Candidate</label>
						</div>
						<div class="col">
							<input type="text" id="name" name="name" value="${answers.get(0).getLastname()} ${answers.get(0).getFirstname()}" disabled="disabled">
						</div>
					</div>

					<div class="row">
						<div class="col">
							<label for="candi_id">Number</label>
						</div>
						<div class="col">
							<input type="text" id="candi_id" name="candi_id" value="${answers.get(0).getCandi_id()}" disabled="disabled">
						</div>

					</div>

				</form>

			</div>

			<div class="col-6">
				<a href="/GetCandId?id=${answers.get(0).getCandi_id()}"><div class="btn btn-primary" id="but-personal">PERSONAL
					INFORMATION</div></a>

			</div>
		</div>


		<h2 class="answer">Answer questions and submit</h2>



	
		<!-- Question element starts -->
		<c:forEach var="ques" items="${requestScope.answers}">
		<form action="SaveValueButtons" method="POST" class="forminfo">
		<p class="question"><c:out value="${ques.quess_id}"/>. <c:out value="${ques.question}" /></p>
		
		<div class="card" id="ques-card">
			<div>
				<input type="radio" id="strdis" name="<c:out value="${ques.quess_id}"/>"
					value="1"> <label for="strdis">Strongly disagree</label>

			</div>
			<div>
				<input type="radio" id="dis" name="<c:out value="${ques.quess_id}"/>"
					value="2"> <label for="dis">Disagree</label>
			</div>
			<div>
				<input type="radio" id="ntrl" name="<c:out value="${ques.quess_id}"/>"
					value="3" checked> <label for="ntrl">Neutral</label>
			</div>
			<div>
				<input type="radio" id="agr" name="<c:out value="${ques.quess_id}"/>"
					value="4"> <label for="agr">Agree</label>
			</div>
			<div>
				<input type="radio" id="stragr" name="<c:out value="${ques.quess_id}"/>"
					value="5"> <label for="stragr">Strongly agree</label>
			</div>

		</div>
		<br>
		</form>
		</c:forEach>
		<!-- Question element ends -->
		

		<div class="row justify-content-end">
			<button class="btn btn-primary" id="submit-que" type="submit">SUBMIT</button>
			<button class="btn btn-primary" type="delete">DELETE</button>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>
</body>

</html>