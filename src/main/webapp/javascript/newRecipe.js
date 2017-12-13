 $(document).ready(function() {
     $("#newrecipe").validate({

         rules: {
             name: {required: true},
             catagory: {required:true},
             ingredient:{required:true},
             ingredientamount:{required:true},
             unitmeasure:{required:true}
         }
     })
     var increment = 2;
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

     $("#submit").on("click", function() {

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
         })
         jsonString += '] }';
         $.post("recipeServlet", jsonString, function() {

             $(".dialog").remove();
             $(".content").append('<p class="dialog">Sucessfully added Recipe ' + recipeName + '</p>');
             $(".dialog").dialog();
         })
         this.form.reset();

     })

/*     function validateForm()  {
         console.log("in  validate form");

    }*/

})