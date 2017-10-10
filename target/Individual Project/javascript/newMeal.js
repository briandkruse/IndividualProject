function init() {
    //get elements
    var ingredients = document.getElementById("ingredients")
    var addNewIngredientButton = document.getElementById("addnewingredient");
    //set event handler
    addNewIngredientButton.onclick=createIngredient;
    var increment = 2; //for attribute names
    function createIngredient() {
        //create elements
        var newIngredient = document.createElement("input");
        var newAmount = document.createElement("input");
        var newUnitMeasure = document.createElement("input");
        var newIngredientText = document.createTextNode("Ingredient: ");
        var newAmountText = document.createTextNode("Amount: ");
        var newUnitMeasureText = document.createTextNode("Unit of Measure: ");
        var lineBreak = document.createElement("br");
        //set attributes
        newIngredient.type="text";
        newAmount.type="text";
        newUnitMeasure.type="text";
        newIngredient.name="ingredient" + increment;
        newAmount.name="amount" + increment;
        newUnitMeasure.name="unitmeasure" + increment;
        //position elements
        ingredients.appendChild(newIngredientText);
        ingredients.appendChild(newIngredient);
        ingredients.appendChild(newAmountText);
        ingredients.appendChild(newAmount);
        ingredients.appendChild(newUnitMeasureText);
        ingredients.appendChild(newUnitMeasure);
        ingredients.appendChild(lineBreak);
        increment++;

    }
}