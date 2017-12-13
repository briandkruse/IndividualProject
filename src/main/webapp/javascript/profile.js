$(document).ready(function() {
    var increment = 2;

    $(".update").on("click", function() {
        var recipeId = $(this).attr("name");

        $.get("updateRecipe", "id=" + recipeId , function() {
             /*$("#hideme").removeAttr('hidden');*/
             $("#updaterecipe").append(
             '<hr />' +
             '<label for name="name">Recipe Name:</label>' +
             '<input type="text" name="name" id="recipename">' +
             '<label for name="catagory">Catagory:</label>' +
             '<input type="text" name="catagory" id="catagory">' +
             '<br /><hr />' +
             '<div id="ingredients">' +
             '<div id="1" class="ingredientdiv">' +
             '<label for name="ingredient">Ingredient:</label>' +
             '<input type="text" name="ingredient" class="ingredient">' +
             '<label for name="ingredientamount">Quantity:</label>' +
             '<input type="text" name="amount" class="amount">' +
             '<label for name="unitmeasure">Unit of Measure:</label>' +
             '<input type="text" name="unitmeasure" class="unitmeasure"><br />' +
             '</div></div>' +
             '<input type="button" id="addnewingredient" value="Add Another Ingredient">' +
             '<input type="button" value="Submit" name="submit" id="submit">' +
             '</form>'
            )

            $("#addnewingredient").on("click", function() {
                $("#ingredients").append("<div id='" + increment +
                    "' class='ingredientdiv'><label for name='ingredient'>Ingredient: </label>" +
                    "<input type='text' class='ingredient'>" +
                    "<label for name='amount'>Quantity:</label>" +
                    "<input type='text' class='amount'>" +
                    "<label for name='unitmeasure'>Unit of Measure:</label>" +
                    "<input type='text' class='unitmeasure'><br /></div>");
                increment++;
             })

            //UPDATE FOR STRINGIFY
            $("#submit").on("click", function() {
                var recipeName = $("#recipename").val();
                var catagory = $("#catagory").val();
                var jsonString = "{\"name\": \"" + recipeName
                    + "\" ,\"catagory\": \"" + catagory + "\", "
                    + "\"id\": " + recipeId + ", "
                    + "\"ingredients\": [ ";
                //todo add error handling
                $(".ingredientdiv").each(function(i){
                    var length = $(".ingredient").length;
                    var ingredientName = $(this).find(".ingredient").val();
                    var amount = $(this).find(".amount").val();
                    var unitMeasure = $(this).find(".unitmeasure").val();
                    jsonString += "{\"name\": \"" + ingredientName + "\", "
                        + "\"amount\": " + amount + ", ";
                    if (i == (length - 1)) {
                        jsonString += "\"unitMeasure\": \"" + unitMeasure + "\"}";
                    }  else {
                        jsonString += "\"unitMeasure\": \"" + unitMeasure + "\"},";
                    }
                })
                $.post("updateRecipe", jsonString, function() {
                    $("#updaterecipe").html("<p>sucessfully added " + recipeName + "to your account</p>");
                })
            })
        })

    })
    $("#datatable").DataTable();

})