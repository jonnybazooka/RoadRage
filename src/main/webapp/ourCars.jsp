<%@ page import="org.tgieralt.models.Car" %>
<%@ page import="java.util.List" %>
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
    <%
        List<Car> carList = (List<Car>) session.getAttribute("carList");
        int count = 1;
    %>
    <div class="row">
        <table class="table table-dark table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Producer</th>
                <th scope="col">Model</th>
                <th scope="col">Production Year</th>
                <th scope="col">For Rent?</th>
            </tr>
            </thead>
            <tbody>
            <% for (Car car : carList) {
            %><tr>
                <th><%=count++%></th>
                <th><%=car.getProducer()%></th>
                <th><%=car.getModel()%></th>
                <th><%=car.getYearOfProduction().getYear()%></th>
                <th><%
                    if (car.isAvailableForRent()) {
                        %><a href=<%="\"rentCar?Id="+car.getId()+"\""%> role="button" class="btn btn-success btn-sm">For Rent</a><%
                    } else {
                        %><button type="button" class="btn btn-warning btn-sm" disabled>Already Taken</button><%
                    }
                %></th>
            </tr>
            <%  }  %>
            </tbody>
        </table>
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
