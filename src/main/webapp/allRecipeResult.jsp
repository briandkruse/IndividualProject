<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results"/>
<%@include file="partials/head.jsp" %>


<html>
<body>

<div class="wrapper">
    <h2>Recipe: </h2>
    <table class="table table-bordered">
        <tr>
            <th>Recipe Name</th>
            <th>Catagory</th>


        </tr>

        <c:forEach var="recipe" items="${recipe}">
            <tr>
                <td>${recipe.name}</td>
                <td>${recipe.catagory}</td>

            </tr>
        </c:forEach>

    </table>
    <a href="index.jsp">Search Again</a>
</div>

</body>
</html>
