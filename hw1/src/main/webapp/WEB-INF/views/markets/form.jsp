<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form:form modelAttribute="market" action="/addMarket">

        <form:label path="id">ID:</form:label>
        <form:input path="id"/>
        <form:errors path="id"/><br/>

        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name"/><br/>

        <form:label path="location">Location:</form:label>
        <form:input path="location"/>
        <form:errors path="location"/><br/>

        <input type="submit" value="Submit"/>
        <form:errors/>
    </form:form>


</body>
</html>