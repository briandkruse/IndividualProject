<%@include file="head.jsp"%>
<html>
<body>
<div id="wrapper">
    <%@include file="navigation.jsp"%>
    <h1>Speedy Grocery Shopper</h1>
    <div>
        <form action="recipeServlet" method="POST">
            <label for name="name">Recipe Name: </label>
            <input type="text" name="name" />
            <label for name="catagory">Catagory: </label>
            <input type="text" name="catagory">
            <br /><hr />
            <div id="ingredients">
                <label for name="ingredient">Ingredient: </label>
                <input type="text" name="ingredient1" />
                <label for name="ingredientamount">Amount: </label>
                <input type="text" name="amount1" />
                <label for name="unitmeasure">Unit of Measure: </label>
                <input type="text" name="unitmeasure1" /><br />
            </div>
            <input type="button" id="addnewingredient" value="Add Another Ingredient">
            <hr />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <a href ="recipeServlet">Search all recipes</a><br />
    </div>
    <%@include file="footer.jsp"%>
</div>

</body>
</html>
<script src="javascript/newMeal.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
    init();
</script>