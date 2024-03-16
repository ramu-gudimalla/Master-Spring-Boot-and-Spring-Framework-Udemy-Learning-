<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Login</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
    <div class="container">
        <form method="post">
            Name: <input type="text" name="name"> <br>
            Password: <input type="password" name="password"><br>
            <input type="submit">
        </form>
        <pre>${errorMessage}</pre>
    </div>
    </body>
</html>
