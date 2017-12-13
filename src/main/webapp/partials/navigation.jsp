<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="navigation">
    <c:if test="${sessionScope.currentUser != null}">
        <div id="navigationloggedin"><a href="./home">
            <div id="home">Home</div>
        </a><a href="./newRecipe.jsp">
            <div id="newrecipe">Create A New Recipe</div>
        </a><a href="./profile">
            <div id="profile">Account Management</div>
        </a><a href="./newPlan">
            <div id="newplan">Start A New List</div>
        </a><a href="./logOut">
            <div id="logout">Log Out</div>
        </a></div>
    </c:if>
    <c:if test="${sessionScope.currentUser == null}">
        <div id="navigationloggedout"><a href="./signUp">
            <div id="signup">Sign Up</div>
        </a><a href="./profile">
            <div id="login">Log In</div>
        </a></div>
    </c:if>
</div>