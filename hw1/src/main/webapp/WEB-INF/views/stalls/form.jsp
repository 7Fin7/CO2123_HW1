<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<form:form modelAttribute="stall" action="/addStall">

    <form:label path="type">Type:</form:label>
    <form:input path="type"/>
    <form:errors path="type"/><br/>


    <form:label path="owner">Owner:</form:label>
    <form:input path="owner"/>
    <form:errors path="owner"/><br/>

    <form:label path="products">Products:</form:label>
    <form:input path="products"/>
    <form:errors path="products"/><br/>


    <form:label path="hours">Hours:</form:label>
    <form:input path="hours"/>
    <form:errors path="hours"/><br/>

    <label>marketId:</label>
    <input name="marketId"/>
    marketId: ${marketId}

    <input type="submit" value="Submit">
    <form:errors/>
</form:form>


</body>
</html>