<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Add Todo</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo" acceptCharset="UTF-8">
            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-danger"/>
            </fieldset>
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-danger"/>
                </fieldset>
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-primary rounded-pill">
            </form:form>
        </div>
    </body>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
    	$('#targetDate').datepicker({
        	    format: 'yyyy-mm-dd'
        	});
    </script>
</html>