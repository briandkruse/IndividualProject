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
