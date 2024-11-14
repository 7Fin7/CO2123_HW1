<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<form:form modelAttribute="stall" action="/addStall">

    <form:label path="type">Type:</form:label>
    <form:input path="type"/><br/>

    <form:label path="owner">Owner:</form:label>
    <form:input path="owner"/><br/>

    <form:label path="products">Products:</form:label>
    <form:input path="products"/><br/>

    <form:label path="hours">Hours:</form:label>
    <form:input path="hours"/><br/>

    <label>marketId:</label>
    <input name="marketId"/>

    <input type="submit" value="Submit">
</form:form>


</body>
</html>