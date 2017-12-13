<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results"/>
<%@include file="partials/head.jsp" %>


<html>
<body>

<div class="wrapper">
    <h2>Search Results: </h2>
    <table class="table table-bordered">
        <tr>
            <th>Login</th>
            <th>First Name</th>
            <th>Last Name</th>

        </tr>

        <c:forEach var="users" items="${users}">
            <tr>
                <td>${users.login}</td>
                <td>${users.firstName}</td>
                <td>${users.lastName}</td>
            </tr>
        </c:forEach>

    </table>
    <a href="index.jsp">Search Again</a>
</div>

</body>
</html>
