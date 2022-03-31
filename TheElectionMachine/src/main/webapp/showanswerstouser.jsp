<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
    <title>Show answers</title>
</head>

<body id="showans" style="background-image: url(/pics/minionsvertical.png); background-repeat: no-repeat;background-position: left 50px bottom 50px;background-size: 25vw;">

    <main class="main_show">

        <h2 class="h2show">Your answers</h2>
        <div class="container-fluid" id="showcon"></div>

        <table class="table table-bordered" id="tableshow">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Question</th>
                    <th scope="col">Your answer</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"> 1</th>
                    <td>Bananas are the greatest fruits.</td>
                    <td>Strongly agree</td>
                </tr>

                <tr>
                    <th scope="row"> 2</th>
                    <td>Yellow is the best color.</td>
                    <td>Strongly agree</td>
                </tr>
            </tbody>
        </table>

        <div class="row justify-content-end">
                
            <div class="col-3"><a href="" class="btn btn-primary">EDIT</a></div>
            <div class="col-3"><a href="" class="btn btn-primary">DELETE</a></div>
            <div class="col-3"><a href="/AnswerQuestionsCandidate" class="btn btn-primary">ANSWER<br>QUESTIONS</a></div>

        </div>
        </div>

    </main>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>