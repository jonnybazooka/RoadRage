<%@ page import="org.tgieralt.models.Rent" %>
<%@ page import="java.util.List" %>
<%@ page import="org.tgieralt.models.FinishedRent" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Road Rage Admin Panel</title>
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
        <div class="col-md-auto">
            <h3>New Car Form</h3>
            <form method="post" action="admin">
                <div class="form-group">
                    <label for="carProducer">Car's Producer</label>
                    <input type="text" class="form-control" id="carProducer" name="carProducer">
                </div>
                <div class="form-group">
                    <label for="carModel">Car's Model</label>
                    <input type="text" class="form-control" id="carModel" name="carModel">
                </div>
                <div class="form-group">
                    <label for="carProdYear">Car's Production Date</label>
                    <input type="date" class="form-control" id="carProdYear" name="carProdDate">
                </div>
                <button type="submit" class="btn btn-primary">Add a new car</button>
            </form>
        </div>
        <div class="col">
            <%
                List<Rent> rentList = (List<Rent>) request.getAttribute("rentList");
                int count = 1;
            %>
            <h3>Current Rentals</h3>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Customer</th>
                    <th scope="col">Car</th>
                    <th scope="col">Start Date</th>
                    <th scope="col">Return Date</th>
                </tr>
                </thead>
                <tbody>
                <% if (rentList != null) {
                    for (Rent rent : rentList) {
                %><tr>
                    <th><%=count++%></th>
                    <th><%=rent.getUser().getEmail()%></th>
                    <th><%=rent.getCar().getProducer()%> <%=rent.getCar().getModel()%></th>
                    <th><%=rent.getStartDate()%></th>
                    <th><%=rent.getEndDate()%></th>
                </tr>
                <%  }
                }  %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-auto">
            <%
                List<FinishedRent> finishedRents = (List<FinishedRent>) request.getAttribute("finishedRents");
                int count2 = 1;
            %>
            <h3>Finished Rents</h3>
            <table class="table table-hover table-sm">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Producer</th>
                    <th scope="col">Model</th>
                    <th scope="col">Customer</th>
                    <th scope="col">Started</th>
                    <th scope="col">Finished</th>
                    <th scope="col">Comments</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (finishedRents != null) {
                        for (FinishedRent fRent : finishedRents) {
                        %><tr>
                            <th><%=count2++%></th>
                            <th><%=fRent.getProducer()%></th>
                            <th><%=fRent.getModel()%></th>
                            <th><%=fRent.getCustomer()%></th>
                            <th><%=fRent.getStartDate()%></th>
                            <th><%=fRent.getEndDate()%></th>
                            <th><%=fRent.getComments()%></th>
                        </tr><%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
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
