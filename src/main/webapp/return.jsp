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
<%
    List<Car> rentedCars = (List<Car>) request.getAttribute("rentedCars");
%>
<div class="container">
    <h3>Car return form</h3>
    <form method="post" action="return">
        <div class="form-group row">
            <div class="col-sm-5">
                <label for="carSelect">Select a car</label>
                    <select class="form-control" id="carSelect" name="carSelect">
                        <%  if (rentedCars != null) {
                            for (Car car : rentedCars) {
                        %><option value="<%=car.getRent().getId()%>">
                        <%=car.getProducer()%> <%=car.getModel()%> Id:<%=car.getId()%> Customer:<%=car.getRent().getUser().getEmail()%>
                        </option><%
                                }
                            }  %>
                    </select>
            </div>
            <div class="col-sm-2">
                <button type="submit" class="btn btn-primary">RETURN</button>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-1">
                <label for="comments">Comments</label>
            </div>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="comments" id="comments">
            </div>
        </div>
    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
