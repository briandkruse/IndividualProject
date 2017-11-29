 $(document).ready(function() {
     var increment = 2;
     $("#addnewingredient").on("click", function() {
         $("#ingredients").append("<div id='" + increment +
              "' class='ingredientdiv'><label for name='ingredient'>Ingredient: </label>" +
              "<input type='text' class='ingredient'>" +
              "<label for name='amount'> Amount: </label>" +
              "<input type='text' class='amount'>" +
              "<label for name='unitmeasure'> Unit of Measure: </label>" +
              "<input type='text' class='unitmeasure'><br /></div>");
              increment++;
     })

     $("#submitbutton").on("click", function() {

         var recipeName = $("#recipename").val();
         var catagory = $("#catagory").val();
         var jsonString = "{\"name\": \"" + recipeName
                          + "\" ,\"catagory\": \"" + catagory + "\", "
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
             //https://www.w3schools.com/js/tryit.asp?filename=tryjson_stringify
         })
         jsonString += '] }';
         console.log(jsonString);

         $.post("recipeServlet", jsonString, function() {

            $("#submitlinks").append(
                "<a href=\"profile\">Go to Account Management</a> <br />" +
                "<a href=\"newPlan\">Start a New Grocery List</a>"
            );

         })
     })



})