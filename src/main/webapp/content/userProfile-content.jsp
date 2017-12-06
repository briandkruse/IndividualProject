<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>${currentUser.firstName}'s Profile</h1>
<div id="userdata">
    <p>Login: ${currentUser.login}</p>
    <p>First Name: ${currentUser.firstName}</p>
    <p>Last Name: ${currentUser.lastName}</p>
    <p>Email address: ${currentUser.email}</p>
    <p>Join Date: </p>
</div>

<div id="userrecipe">
    <h2>${currentUser.firstName}'s Recipes</h2>


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