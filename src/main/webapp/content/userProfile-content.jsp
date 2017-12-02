<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" scope="request" value="Manage Your Account" />


<h1>${user.firstName}'s Profile</h1>
<div id="userdata">
    <p>Login: ${user.login}</p>
    <p>First Name: ${user.firstName}</p>
    <p>Last Name: ${user.lastName}</p>
    <p>Email address: ${user.email}</p>
    <p>Join Date: </p>
</div>

<div id="userrecipe">
    <h2>${user.firstName}'s Recipes</h2>


    <table>
        <tr>
            <th>Recipe Name</th>
            <th>Catagory</th>
            <th>Delete</th>


        </tr>

        <c:forEach var = "recipes" items="${recipes}">
            <tr>
                <td>${recipes.name}</td>
                <td>${recipes.catagory}</td>
                <td><a href='processProfile?id=${recipes.id}'>Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</div>