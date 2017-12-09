<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="./javascript/shoppingList.js" type="text/javascript"></script>

<h1>Shopping List</h1>
<p>Make your list look the way YOU want</p>

<div class="sortable">
    <c:forEach items="${ingredients}" var="ingredient">
        <p>${ingredient.amount} ${ingredient.unitMeasure} ${ingredient.name}</p><br />
    </c:forEach>
</div>
