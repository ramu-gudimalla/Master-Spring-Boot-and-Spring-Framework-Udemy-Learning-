<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>List Todos</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
    <div class="container">
        <h1>Your todos </h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>done</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todos">
                    <tr>
                        <td>${todos.id}</td>
                        <td>${todos.description}</td>
                        <td>${todos.targetDate}</td>
                        <td>${todos.done}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class="btn btn-primary rounded-pill">Add Todo</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>
