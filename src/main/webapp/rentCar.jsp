<%@ page import="org.tgieralt.models.Car" %>
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
        <%
            Car car = (Car) request.getAttribute("pickedCar");
        %>
        <h2><%=car.getProducer()%> <%=car.getModel()%></h2>
    </div>
    <p>Production date: <%=car.getYearOfProduction()%></p>
    <p>Database Id: <%=car.getId()%></p>
    <p>Status: <% if(car.isAvailableForRent()) {
    %>Available<%
    } else {
    %>Not Available<%
        } %></p>
    <div class="row">
        <% String confirm = "confirm?Id=" + car.getId();%>
        <a role="button" class="btn btn-success" href=<%="\""+confirm+"\""%>>RENT</a>
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
