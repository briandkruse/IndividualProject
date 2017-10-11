function init() {
    //get elements
    console.log("testing");
    var options = document.getElementById("options")
    var addNewIngredientButton = document.getElementById("addnewingredient");
    var addNewOptionButton = document.getElementById("addnewoption");
    var lineBreak = document.createElement("br");
    //set event handler
    addNewIngredientButton.onclick = createIngredient;
    addNewOptionButton.onclick = createOption;
    console.log("testing");
    //set increments
    var ingredientIncrement = 2; //for attribute names
    var foodGroupIncrement = 2; //for attribute names


    function createOption() {
        //reset ingredient increment
        ingredientIncrement = 1;


        //create elements
        var targetDiv = document.getElementById("foodgroup");
        var foodGroupText = document.createTextNode("Food Group Name:");
        var foodGroupInput = document.createElement("input");
        var groupIngredientText = document.createTextNode("Ingredient");
        var groupIngredientInput = document.createElement("input");

        //set attributes
        foodGroupInput.type = "text";
        foodGroupInput.name = "foodgroup" + foodGroupIncrement;
        groupIngredientInput.type = "text";
        groupIngredientInput.name = "ingredient" + ingredientIncrement;

        //create ingredient button
        var addIngredientButton = document.createElement("input");
        addIngredientButton.type = "button";
        addIngredientButton.id = "addnewingredient";
        addIngredientButton.value = "Add Another Ingredient";

        //remove elements
        options.removeChild(addNewIngredientButton);

        //append elements
        targetDiv.appendChild(foodGroupText);
        targetDiv.appendChild(foodGroupInput);
        targetDiv.appendChild(lineBreak);
        targetDiv.appendChild(groupIngredientText);
        targetDiv.appendChild(groupIngredientInput);
        targetDiv.appendChild(addIngredientButton);

        foodGroupIncrement++;

    }
    function createIngredient() {
        //create elements
        var newIngredient = document.createElement("input");
        var newIngredientText = document.createTextNode("Ingredient: ");
        //set attributes
        newIngredient.type="text";
        newIngredient.name="ingredient" + ingredientIncrement;
        //position elements
        options.appendChild(newIngredientText);
        options.appendChild(newIngredient);
        options.appendChild(lineBreak);
        ingredientIncrement++;
    }


}
