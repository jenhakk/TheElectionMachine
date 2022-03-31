<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
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
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Browse Candidates</title>
</head>
<body id="browse">

	<main class="main_browse">
		<h1>Candidates</h1>

		<div class="container-fluid">

			

			<c:forEach var="cand" items="${requestScope.candilist}">
			<li>${cand.id }:${cand.fname }<a href='/ShowSpesificCandidate?id=${cand.id}'>PLAAPLAA</a>
				<!-- -------Candidate element starts---------- -->
				<div class="card" id="card-cand"><a href="/ShowSpesificCandidate?id=${cand.id}">

					<div class="row no-gutters">
						<div class="col-4">

							<div class="image">
								<img class="profile" src="<c:out value="${cand.pic}"/>">
							</div>
							<p class="candnum">
								<c:out value="${cand.id}" />
							</p>
						</div>
						<div class="col-7">
							<div class="card-body">
								<h5 class="card-title">
									<c:out value="${cand.name}" />
									<c:out value="${cand.fname}" />
								</h5>
								<p class="card-text">
									"
									<c:out value="${cand.promo}" />
									"
								</p>
							</div>

						</div>
						<div class="col-1">
							<img class="arrow" src="/pics/chevron-right.svg"></img>
						</div>


					</div>

					</a>
				</div>
				<br>	

				<!-- -------Candidate element ends---------- -->
			</c:forEach>


		</div>



	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>

</body>

</html>
