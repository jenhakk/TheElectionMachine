<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< Updated upstream
<%@ page import= "java.util.ArrayList" %>
=======
<%@ page import="java.util.ArrayList"%>
>>>>>>> Stashed changes
<%@ page import="data.Answers"%>

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

	<div class="col"><a href="index.html" class="btnhome">HOME</a></div>
		<div class="row" id="row-ansque">

			<div class="col-6">
<<<<<<< Updated upstream
				<form action="/GetCandId" method="post" class="candform">
=======
				<form action="/SaveValueButtons" method="post" class="candform">
>>>>>>> Stashed changes

					<div class="row" style="margin-bottom: 5px;">
						<div class="col">
							<label for="candi">Candidate</label>
						</div>
						<div class="col">
							<input type="text" id="name" name="name"
								value="${answers.get(0).getLastname()} ${answers.get(0).getFirstname()}"
								disabled="disabled">
						</div>
					</div>

					<div class="row">
						<div class="col">
							<label for="candi_id">Number</label>
						</div>
						<div class="col">
							<input type="text" id="candi_id" name="candi_id"
								value="${answers.get(0).getCandi_id()}" disabled="disabled">
						</div>

					</div>

				</form>

			</div>

			<div class="col-6">
				<a href="/GetCandId?id=${answers.get(0).getCandi_id()}"><div
						class="btn btn-primary" id="but-personal">PERSONAL
						INFORMATION</div></a>

			</div>
		</div>


		<h2 class="answer">Answer questions and submit</h2>
<<<<<<< Updated upstream
		
		<% 
			ArrayList<Answers> answers = (ArrayList<Answers>)request.getAttribute("answers");
		
			for (int i = 1; i < 11; i++)
		
			{
			%>
		<!-- Question element starts -->
		<form action="/SaveValueButtons" method="POST" class="forminfo">
			
			<input type="hidden" name="candidate" value="${candi.id}">
			
		
			

			<div>
				<input type="hidden" id="ques" name="quesid" value="<%=i%>"/>
=======



			<%
		
			
			ArrayList<Answers> ans = (ArrayList<Answers>)request.getAttribute("answers");
						
			for (int i = 0; ans!=null && i<ans.size(); i++) { 
			
				Answers a = ans.get(i);
				out.println(a.getQuess_id() + "<a href='/index.html'>Index</a>" + a.getQuestion());
				
			}
			%>
			
			<div class="ques">
			
						
			
			</div>
			
			<form action"SaveValueButtons" method="POST" id="quesform">
			
			
				<label>1</label><input type="radio" name="vastaus" value="1" />
                    <label>2</label><input type="radio" name="vastaus" value="2" />
                    <label>3</label><input type="radio" name="vastaus" value="3" checked="checked" />
                    <label>4</label><input type="radio" name="vastaus" value="4" />
                    <label>5</label><input type="radio" name="vastaus" value="5" />
                    
                    <input type="submit" id="submitnappi" value="Vastaa" />
			
			
			</form>
		
		
	
		<!-- Question element starts -->
		<form action="/SaveValueButtons" method="POST" class="forminfo">
		<c:forEach var="ques" items="${requestScope.answers}">
		
		<p class="question"><c:out value="${ques.quess_id}"/>. <c:out value="${ques.question}" /></p>
		
		<div class="card" id="ques-card">
			<div>
				<input type="radio" id="ques" name="answer<c:out value="${ques.quess_id}"/>"
					value="1"> <label for="strdis">Strongly disagree</label>

			</div>
			<div>
				<input type="radio" id="ques" name="<c:out value="${ques.quess_id}"/>"
					value="2"> <label for="dis">Disagree</label>
			</div>
			<div>
				<input type="radio" id="ques" name="<c:out value="${ques.quess_id}"/>"
					value="3" checked> <label for="ntrl">Neutral</label>
			</div>
			<div>
				<input type="radio" id="ques" name="<c:out value="${ques.quess_id}"/>"
					value="4"> <label for="agr">Agree</label>
			</div>
			<div>
				<input type="radio" id="ques" name="<c:out value="${ques.quess_id}"/>"
					value="5"> <label for="stragr">Strongly agree</label>
>>>>>>> Stashed changes
			</div>
				
				<p class="question"><%=i%>. ${oikea.get(0).getQuestion()}</p>

<<<<<<< Updated upstream
				<div class="card" id="ques-card">
				
					<div>
						<input type="radio" id="strdis"
							name="ques<%=i%>" value="1"> 
							<label for="strdis">Strongly disagree</label>

					</div>
					<div>
						<input type="radio" id="dis"
							name="ques<%=i%>" value="2">
							<label for="dis">Disagree</label>
					</div>
					<div>
						<input type="radio" id="ntrl"
							name="ques<%=i%>" value="3" checked> 
							<label for="ntrl">Neutral</label>
					</div>
					<div>
						<input type="radio" id="agr"
							name="ques<%=i%>" value="4"> 
							<label for="agr">Agree</label>
					</div>
					<div>
						<input type="radio" id="stragr"
							name="ques<%=i%>" value="5"> 
							<label for="stragr">Strongly agree</label>
					</div>

				</div>
				<br>

				<% } 
									
		 		%>

			<button class="btn btn-primary" type="submit">SUBMIT</button>
		</form>

=======
		</div>
		<br>
		
		</c:forEach>
		
		<button class="btn btn-primary" type="submit">SUBMIT</button>
		</form>
		
>>>>>>> Stashed changes
		<!-- Question element ends -->

<<<<<<< Updated upstream

		<div class="row justify-content-center">


			<!--<div>
				<a href="/SaveValueButton?id=${answers.get(0).getQuess_id()}&id2=${answers.get(0).getCandi_id()}">SAVE</a>
			</div> -->
			<div class="col">
				<a href="/GetCandId?id=${candform.candi_id}" class="btn btn-primary">BACK</a>
			
			
=======
		<div class="row justify-content-end">
			 
			
			<!--<div>
				<a href="/SaveValueButton?id=${answers.get(0).getQuess_id()}&id2=${answers.get(0).getCandi_id()}">SAVE</a>
			</div> -->
>>>>>>> Stashed changes
			<button class="btn btn-primary" type="delete">DELETE</button>
		</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>
</body>

</html>