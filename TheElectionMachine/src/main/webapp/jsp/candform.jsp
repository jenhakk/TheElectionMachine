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
    <title>Edit info</title>
</head>

<body id="profile">

    <main class="main_profile">

        <h2 class="h2prof">Your profile</h2>

        <div class="container">
			
            <div class="rowcan1">
                <div class="col">
                
          	
                    <image><img class="profile_cand" src="${requestScope.candform.pic}"></image>
                        <p class="candnumber">${requestScope.candform.candi_id}</p>
                        <h2 class="candnameprof">${requestScope.candform.firstname} ${requestScope.candform.lastname}</h2>
                </div>
            </div>

            <div class="row" id="rowprof-info">

                <div class="col-12">
                <form action="ReadFormToUpdate" method="POST" class="forminfo">	
                
                <div class="form-group">
             
                    <input type="hidden" class="infoper" id="pic" name="pic" value="${requestScope.candform.pic}">
                </div>
                <div class="form-group">
                    <label for="id" id="label">Number</label><br>
                    <input type="text" class="infoper" id="id" name="id" value="${requestScope.candform.candi_id}" readonly>
                </div>
            
                <div class="form-group">
                    <label for="fname" id="label">First name</label><br>
                    <input type="text" class="infoper" id="fname" name="fname" value="${requestScope.candform.firstname}" required>
                </div>

                <div class="form-group">
                    <label for="lname" id="label">Last name</label><br>
                    <input type="text" class="infoper" id="lname" name="lname" value="${requestScope.candform.lastname}" required>
                </div>

                <div class="form-group">
                    <label for="party" id="label">Party</label><br>
                    <input type="text" class="infoper" id="party" name="party" value="${requestScope.candform.party}" required>
                </div>

                <div class="form-group">
                    <label for="munic" id="label">Municipality</label><br>
                    <input type="text" class="infoper" id="munic" name="munic" value="${requestScope.candform.municipality}" required>
                </div>

                <div class="form-group">
                    <label for="age" id="label">Age</label><br>
                    <input type="text" class="infoper" id="age" name="age" value="${requestScope.candform.age}" required>
                </div>
 
                <div class="form-group">
                    <label for="prof" id="label">Profession</label><br>
                    <input type="text" class="infoper" id="prof" name="prof" value="${requestScope.candform.profession}" required>
                </div>

                <div class="form-group">
                    <label for="promo" id="label">Promote</label><br>
                    <textarea type="text" class="infoperarea" id="promo" name="promo" required>${requestScope.candform.promo}</textarea>
                </div class="row">
              	<div class="col">
				<a href="/GetCandId?id=${candform.candi_id}" class="btn btn-primary">BACK</a>
			</div>
			<div class="col">
				<input type="submit" class="btn btn-primary" name="ok" value="SAVE">
			</div>
            </form>
                </div>
        </div>
				<div class="col-12"><a href="/showanswers.html" class="btnindex">CHECK YOUR ANSWERS</a></div>
				
			
				</div>
        </div>      
		
       


    </main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>