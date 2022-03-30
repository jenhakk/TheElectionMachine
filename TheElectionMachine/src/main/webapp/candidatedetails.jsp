<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style2.css">
    <title>Candidate</title>
</head>
<body id="candidate">

    <main class="main_candidate">


        <div class="container">

			<!-- Testin this thing -->
			<c:forEach var="cand" items="${requestScope.candilist}">
            <div class="rowcan1">
                <div class="col">
                <image"><img class="profile_cand" src="/kevin2.png"></image>
                    <p class="candnumber"><c:out value="${cand.id}"/></p>
                    <h2 class="candname"><c:out value="${cand.name}"/> <c:out value="${cand.fname}"/></h2>
                </div>
            </div>
            <!--  just for testing for now -->
			</c:forEach>
			
            <div class="card">

                <div class="row-info">
                    <div class="col-12">
                        <div class="textbox">
                        <p><span class="party" style="">Minion Party</span></p>
                        <p class="age">Age: Unknown</p>
                        <p class="city">City: Villain Village</p>
                        <p class="profession">Profession: Minion</p>
                        
                    </div>
                    </div>

                    <div class="row-prom">
                        <div class="col-12">
                            <p class="promote">“I want to lead Minions into better life and find the best evil leader to follow.”</p>
                            
                        </div>
                        
                </div>
            </div>


        </div>

<!-- Not sure if we want to have this, can be deleted later -->
        <div class="col"><a href="/showanswers.html" class="btn btn-primary">CHECK CANDIDATES ANSWERS</a></div>

	</div>
    </main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>