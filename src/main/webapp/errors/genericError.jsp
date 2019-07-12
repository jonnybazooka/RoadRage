<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/errors/errorStyle.css">
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
<div class="container" style="background-image: url('${pageContext.request.contextPath}/graphics/error.jpg'); width: 100%; height: 100%; background-repeat: no-repeat">
    <div class="row">
        <h2>We are sorry. An error has occurred.</h2>
    </div>
    <div class="row">
        <ul>
            <%
                Integer statusCode = (Integer) request.getAttribute("statusCode");
                Throwable throwable = (Throwable) request.getAttribute("throwable");
                String requestURI = (String) request.getAttribute("requestUri");
                String servletName = (String) request.getAttribute("servletName");
                if (statusCode != null) {
                    %><li>Status code: <%=statusCode.toString()%></li><%
                    %><li>Request URI: <%=requestURI%></li><%
                }
                if (throwable != null) {
                    %><li>Exception Name: <%=throwable.getClass().getName()%></li><%
                    %><li>Exception Message: <%=throwable.getMessage()%></li><%
                    %><li>Servlet: <%=servletName%></li><%
                    %><li>Request URI: <%=requestURI%></li><%
                }
            %>
        </ul>

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
