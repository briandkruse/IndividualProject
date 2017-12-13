$(document).ready(function () {
    $("#newrecipe").validate({
        rules: {
            name: "required",
            catagory: "required",
            ingredient: "required",
            ingredientamount: "required",
            unitmeasure: "required"
        },
        messages: {
            name: "Enter First Name",
            catagory: "Enter First Name",
            ingredient: "Enter your user login",
            ingredientamount: "Enter A Password",
            unitmeasure: "Repeat Password"
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
    var increment = 2;
    $("#addnewingredient").on("click", function () {
        $("#ingredients").append("<div id='" + increment +
            "' class='ingredientdiv'><label for='ingredient" + increment + "'>Ingredient: </label>" +
            "<input type='text' class='ingredient' id='ingredient" + increment + "'>" +
            "<label for='ingredientamount" + increment + "'>Quantity:</label>" +
            "<input type='text' class='amount' id='ingredientamount" + increment + "'>" +
            "<label for='unitmeasure" + increment + "'>Unit of Measure:</label>" +
            "<input type='text' class='unitmeasure' id='unitmeasure" + increment + "'><br /></div>");
        increment++;
    })

    $("#submit").on("click", function () {

        var recipeName = $("#name").val();
        var catagory = $("#catagory").val();
        var jsonString = "{\"name\": \"" + recipeName
            + "\" ,\"catagory\": \"" + catagory + "\", "
            + "\"ingredients\": [ ";

        $(".ingredientdiv").each(function (i) {
            var length = $(".ingredient").length;
            var ingredientName = $(this).find(".ingredient").val();
            var amount = $(this).find(".amount").val();
            var unitMeasure = $(this).find(".unitmeasure").val();
            jsonString += "{\"name\": \"" + ingredientName + "\", "
                + "\"amount\": " + amount + ", ";
            if (i == (length - 1)) {
                jsonString += "\"unitMeasure\": \"" + unitMeasure + "\"}";
            } else {
                jsonString += "\"unitMeasure\": \"" + unitMeasure + "\"},";
            }
        })
        jsonString += '] }';
        $.post("recipeServlet", jsonString, function () {

            $(".dialog").remove();
            $(".content").append('<p class="dialog">Sucessfully added Recipe ' + recipeName + '</p>');
            $(".dialog").dialog();
        })
        this.form.reset();

    })

})