<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="./javascript/inventory.js" type="text/javascript"></script>

<h1>Inventory</h1>
<p>Check the food items you need, leave the others behind</p>

<form>
    <c:forEach items="${recipes}" var="recipe">
        Recipe: ${recipe.name}<br />
        <c:forEach items="${recipe.ingredients}" var="ingredient">
            <label for name="checkbox">${ingredient.name} : ${ingredient.amount}</label>
            <input type="checkbox" name="ingredient" class="checkbox" value="${ingredient.id}"><br />
        </c:forEach>
    </c:forEach>
</form>
<input type="submit" name="submit" value="Continue to Shopping List" id="submit">
