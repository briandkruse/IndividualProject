<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content">
    <p>Recipe Name: <a href="${url}">${recipename}</a></p>
    <c:forEach var="ingredient" items="${ingredients}">
        <p>${ingredient}</p>
    </c:forEach>


</div>