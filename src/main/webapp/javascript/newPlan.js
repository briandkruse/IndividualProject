$(document).ready(function() {

    var jsonString = '[';
    $("#submit").on("click", function() {
        $(".choice option:selected").each(function (i) {
            var length = $(".choice option:selected").length;

            if (i == (length - 1)) {
                jsonString += $(this).val();
            } else {
                jsonString += $(this).val() + ',';
            }
        })
        jsonString += "]";
        console.log(jsonString);


    $.post("inventory", jsonString, function() {
        window.location.href = "/IndividualProject/inventory.jsp";
    })
    })


})

