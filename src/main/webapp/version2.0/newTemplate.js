function init() {
    //get elements
    var addNewIngredientButton = document.getElementById("addnewingredient");
    var addNewFoodGroupButton = document.getElementById("addnewfoodgroup");
    var lineBreak = document.createElement("br");

    //set event handler
    addNewIngredientButton.onclick = createIngredient;
    addNewFoodGroupButton.onclick = createFoodGroup;


    //set increments
    var ingredientIncrement = 2; //for attribute names
    var foodGroupIncrement = 2; //for attribute names


    function createFoodGroup() {
        addNewIngredientButton = document.getElementById("addnewingredient");
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

        addNewIngredientButton.parentNode.removeChild(addNewIngredientButton);

        //create ingredient button
        var newIngredientButton = document.createElement("input");
        newIngredientButton.type = "button";
        newIngredientButton.id = "addnewingredient";
        newIngredientButton.value = "Add Another Ingredient";
        newIngredientButton.onclick = createIngredient;


        //remove elements


        //append elements
        targetDiv.appendChild(foodGroupText);
        targetDiv.appendChild(foodGroupInput);
        targetDiv.appendChild(lineBreak);
        targetDiv.appendChild(groupIngredientText);
        targetDiv.appendChild(groupIngredientInput);
        targetDiv.appendChild(lineBreak.cloneNode());
        targetDiv.appendChild(newIngredientButton);

        foodGroupIncrement++;
        addNewIngredientButton = document.getElementById("addnewingredient");
    }
    function createIngredient() {
        //create elements
        var newIngredient = document.createElement("input");
        var newIngredientText = document.createTextNode("Ingredient: ");
        //set attributes
        newIngredient.type="text";
        newIngredient.name="ingredient" + ingredientIncrement;
        //position elements
        addNewIngredientButton = document.getElementById("addnewingredient");
        addNewIngredientButton.parentNode.appendChild(newIngredientText);
        addNewIngredientButton.parentNode.appendChild(newIngredient);
        addNewIngredientButton.parentNode.appendChild(lineBreak.cloneNode());

        ingredientIncrement++;
    }



}
