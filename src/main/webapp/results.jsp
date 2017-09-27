<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>


<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>

        </tr>

        <c:forEach var = "users" items="${users}">
            <tr>
                <td>${users.id}</td>
                <td>${users.firstname}</td>
                <td>${users.lastname}</td>
            </tr>
        </c:forEach>

    </table>
    <a href="index.jsp">Search Again</a>
</div>

</body>
</html>
