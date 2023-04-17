<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlets and JSP</title>
        <link rel="stylesheet" href="resources/css/styles.css" type="text/css"/>
    </head>
    
    <body>
        <h1>Request Headers</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <c:forEach var="headersMap" items="${headersMap}">
                <tr>
                    <td><c:out value="${headersMap.key}"/></td>
                    <td><c:out value="${headersMap.value}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>