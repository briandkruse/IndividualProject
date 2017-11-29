<%@include file="head.jsp"%>
<html>
<body>
<div id="wrapper">
    <%@include file="navigation.jsp"%>
    <h1>Speedy Grocery Shopper</h1>
    <div>
        <form action="recipeServlet" method="POST">
            <label for name="name">Recipe Name: </label>
            <input type="text" name="name" id="recipename"/>
            <label for name="catagory">Catagory: </label>
            <input type="text" name="catagory" id="catagory">
            <br /><hr />
            <div id="ingredients">
                <div id="1" class="ingredientdiv">
                    <label for name="ingredient">Ingredient: </label>
                    <input type="text" name="ingredient" class="ingredient" />
                    <label for name="ingredientamount"> Amount: </label>
                    <input type="text" name="amount" class="amount"/>
                    <label for name="unitmeasure"> Unit of Measure: </label>
                    <input type="text" name="unitmeasure" class="unitmeasure"/><br />
                </div>
            </div>
            <input type="button" id="addnewingredient" value="Add Another Ingredient">
            <hr />
            <input type="button" value="Submit" id="submitbutton" />
        </form>
        <%--<a href ="recipeServlet">Search all recipes</a><br />--%>
        <div id="submitlinks">
            <a href="profile">Go to Account Management</a> <br />
            <a href="newPlan">Start a New Grocery List</a>
         </div>
    <%@include file="footer.jsp"%>
    </div>
</div>

</body>
</html>
