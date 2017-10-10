function init() {
    //get elements
    var options = document.getElementById("options")
    var addNewIngredientButton = document.getElementById("addnewingredient");
    var addNewOptionButton = document.getElementById("addnewoption");
    //set event handler
    addNewIngredientButton.onclick=createIngredient;
    addNewOptionButton.onclick=createOption;
    var increment = 2; //for attribute names
    function createIngredient() {
        //create elements
        var newIngredient = document.createElement("input");
        var newIngredientText = document.createTextNode("Ingredient: ");
        var lineBreak = document.createElement("br");
        //set attributes
        newIngredient.type="text";
        newIngredient.name="ingredient" + increment;
        //position elements
        options.appendChild(newIngredientText);
        options.appendChild(newIngredient);
        options.appendChild(lineBreak);
        increment++;
    }
    function createOption() {

    }
}
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