<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <ul>
        <c:forEach items="${markets}" var="market">
            <li>
                <p>Name: ${market.name}</p>
                <p>Location: ${market.location}</p>
                <a href="/stalls?market=${market.getId()}"/>Go to market</a>
            </li>
        </c:forEach>
    </ul>


</body>
</html>