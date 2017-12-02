<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results" />
<%@include file="partials/head.jsp"%>


<html><body>

<div class="wrapper">
    <h2>Recipe: </h2>
    <table class="table table-bordered">
        <tr>
            <th>Recipe Name</th>
            <th>Catagory</th>
        </tr>
        <tr>
            <td>${recipe.name}</td>
            <td>${recipe.catagory}</td>
        </tr>
    </table>
    <h3>Ingredients:</h3>
    <table class=table table-bordered">
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Unit of Measure</th>
        </tr>
        <c:forEach var = "ingredient" items="${recipe.ingredients}">

            <tr>
                <th>${ingredient.name}</th>
                <td>${ingredient.amount}</td>
                <td>${ingredient.unitMeasure}</td>

            </tr>
        </c:forEach>

    </table>
    <a href="index.jsp">Search Again</a>
</div>

</body>
</html>
