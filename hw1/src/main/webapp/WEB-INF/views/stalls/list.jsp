<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<ul>
    <c:forEach items="${stalls}" var="stall">
        <li>
            <p>Type: ${stall.type}</p>
            <p>Owner: ${stall.owner}</p>
            <p>Products: ${stall.products}</p>
            <p>Hours: ${stall.hours}</p>
        </li>
    </c:forEach>

    <br>
    <a href="/newStall?market=${marketID}"/>Add a new stall</a>
</ul>


</body>
</html>