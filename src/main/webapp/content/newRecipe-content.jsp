<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="title" scope="request" value="Create a New Recipe"/>

<div class="content formcontent">
    <h2>Create a new recipe</h2>
    <p>Enter your recipe name and catagory. Then enter each ingredient name, quantity, and how it is measured</p>
    <form id="newrecipe">
        <label for="name">Recipe Name:</label>
        <input type="text" name="name" id="name">
        <label for="catagory">Catagory:</label>
        <input type="text" name="catagory" id="catagory">
        <br/>
        <hr/>
        <div id="ingredients">
            <div id="1" class="ingredientdiv">
                <label for="ingredient1">Ingredient:</label>
                <input type="text" name="ingredient" class="ingredient" id="ingredient1">
                <label for="ingredientamount1">Quantity:</label>
                <input type="text" name="amount" class="amount" id="ingredientamount1">
                <label for="unitmeasure1">Unit of Measure:</label>
                <input type="text" name="unitmeasure" class="unitmeasure" id="unitmeasure1"><br/>
            </div>
        </div>
        <input type="button" id="addnewingredient" value="Add Another Ingredient">
        <input type="button" value="Submit" name="submit" id="submit">
    </form>

</div>
<script src="./javascript/newRecipe.js" type="text/javascript"></script>