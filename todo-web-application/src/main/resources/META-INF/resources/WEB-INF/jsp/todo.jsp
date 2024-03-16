<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Add Todo</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo" acceptCharset="UTF-8">
            <fieldset>
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-danger"/>
            </fieldset>
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-primary rounded-pill">
            </form:form>
        </div>
    </body>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</html>