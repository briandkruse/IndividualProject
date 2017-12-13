<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="./javascript/shoppingList.js" type="text/javascript"></script>

<div class="content shoppinglist">
    <h1>Shopping List</h1>

    <div class="content" id="print">
        <ul class="sortable sortingredient">
        <c:forEach items="${ingredients}" var="ingredient">
             <li><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="2" value="${ingredient.amount}" /> ${ingredient.unitMeasure} ${ingredient.name}</li>
        </c:forEach>
        </ul>
    </div>
    <input type="button" value="Add Note" name="newitem" id="newitem">
</div>
