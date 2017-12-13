<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="./javascript/profile.js"></script>




<div id="userdata" class="content">
    <h1>${currentUser.firstName}'s Profile</h1>
    <p>Login: ${currentUser.login}</p>
    <p>First Name: ${currentUser.firstName}</p>
    <p>Last Name: ${currentUser.lastName}</p>
    <p>Email address: ${currentUser.email}</p>
</div>
<div id="edamam">
    <h2>Search the Edamam API for recipes to add to your own collection</h2>
    <form action="./edamam" method="GET">
        <input type="text" name="searchterm">
        <input type="submit" value="Search" id="edamamsubmit">
    </form>
</div>

<div id="userrecipe" class="content">
    <h2>${currentUser.firstName}'s Recipes</h2>


    <table id="datatable" class="display">
        <thead>
            <tr>
                <th>Recipe Name</th>
                <th>Catagory</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var = "recipe" items="${recipes}">
                <tr>
                    <td>${recipe.name}</td>
                    <td>${recipe.catagory}</td>
                    <td><a href='processProfile?id=${recipe.id}'>Delete</a></td>
                    <td><input type="button" name="${recipe.id}" value="Update" class="update"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <div id="updaterecipe" class="formcontent">

    </div>
${confirm}
</div>