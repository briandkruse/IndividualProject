$(document).ready(function () {
    console.log("entered javascript");
    var jsonString = '[';
    $("#submit").on("click", function () {
        var length = $(".checkbox:checked").length;
        $(".checkbox:checked").each(function (i) {
            if (i == (length - 1)) {
                jsonString += $(this).val();
            } else {
                jsonString += $(this).val() + ',';
            }
        })
        jsonString += "]";
        console.log(jsonString);


        $.post("shoppingList", jsonString, function () {
            window.location.href = "/IndividualProject/shoppingList.jsp";
        })
    })


})

