<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>
<html>
<body>
<div id="wrapper">
    <%@include file="navigation.jsp"%>
    <h1>${user.firstName}'s Profile</h1>
    <div id="userdata">
        <p>Login: ${user.login}</p>
        <p>First Name: ${user.firstName}</p>
        <p>Last Name: ${user.lastName}</p>
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

            </table>--%>
    </div>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
