<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="navigation">

    <c:if test="${sessionScope.currentUser != null}">
        <a href="index.jsp">Home</a> | <a href="./newRecipe.jsp">Create A New Meal: Recipe</a> | <a href="./profile">Account Management</a> | <a href="./newPlan">Start A New List</a> |  <a href="./profile">Log Out(fixlink)</a>
    </c:if>
    <c:if test="${sessionScope.currentUser == null}">
        <a href="index.jsp">Home</a> | <a href="./newUser.jsp">Sign Up</a> |  <a href="./profile">Log In</a>
    </c:if>
</div>