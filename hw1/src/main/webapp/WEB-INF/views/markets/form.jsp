<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form:form modelAttribute="market" action="/addMarket">

        ID:
        <form:input path="id"/><br/>

        Name:
        <form:input path="name"/><br/>

        Location:
        <form:input path="location"/><br/>

        <input type="submit" value="Submit">
    </form:form>


</body>
</html>