<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>


<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class="table table-bordered">

        <p>Recipe Name:</p> ${recipe.name}
        <p>Recipe Catagory:</p> ${recipe.category}


        <tr>
            <th>Ingredient name</th>
            <th>Ingredient amount</th>
            <th>Unit of Measure</th>
        </tr>

        <c:forEach var = "${recipe}" items="${recipe.ingredients}">
            <tr>
                <td>${ingredients.name}</td>
                <td>${ingredients.amount}</td>
                <td>${ingredients.unitMeasure}</td>
            </tr>
        </c:forEach>

    </table>
    <a href="index.jsp">Search Again</a>
</div>

</body>
</html>
