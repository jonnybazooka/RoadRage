<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Road Rage Car Rental</title>
    <script src="jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#nav").load('nav.html');
        });
    </script>
</head>
<body>
<div id="nav" class="container"></div>
<div class="container">
    <div class="row">
        <p>Please complete car rental form and confirm your credentials.</p>
    </div>
    <div class="row">
        <form method="post" action="confirm">
            <% session.setAttribute("carId", request.getParameter("Id"));%>
            <div class="form-row">
                <div class="form-group">
                    <label for="startDate">Rent Start</label>
                    <input type="date" min="2019-07-01" max="2022-12-31" class="form-control" id="startDate" name="startDate">
                </div>
                <div class="form-group">
                    <label for="endDate">Return Date</label>
                    <input type="date" min="2019-07-01" max="2022-12-31" class="form-control" id="endDate" name="endDate">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="userEmail">Confirm Email</label>
                    <input type="email" class="form-control" id="userEmail" name="userEmail">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="userPassword">Confirm Password</label>
                    <input type="password" class="form-control" id="userPassword" name="userPassword">
                </div>
            </div>
            <button type="submit" class="btn btn-success">CONFIRM</button>
        </form>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
