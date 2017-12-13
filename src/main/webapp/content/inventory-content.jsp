<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="./javascript/inventory.js" type="text/javascript"></script>
<div class="content">
    <h2>Check Your Fridge</h2>
    <p>Do you already have some of the ingredients in your meal plan? Check everything you need, leave the rest behind</p>

    <form>
        <c:forEach items="${recipes}" var="recipe">
            Recipe: ${recipe.name}<br />
            <c:forEach items="${recipe.ingredients}" var="ingredient">
                <label for name="checkbox"><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="2" value="${ingredient.amount}" /> ${ingredient.unitMeasure} ${ingredient.name} </label>
                <input type="checkbox" name="ingredient" class="checkbox" value="${ingredient.id}" /><br />
            </c:forEach>
        </c:forEach>
    </form>
    <input type="submit" name="submit" value="Continue to Shopping List" id="submit">
</div>
