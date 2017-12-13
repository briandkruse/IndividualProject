$(document).ready(function() {
    $(".sortable").sortable({
        grid:[60,30]
    })

    $("#newitem").on("click", function() {
        $(".sortingredient").append('<li id="newlabel"><input type="text" name="label" class="label"><input type="button" name="save" value="save" class="save"></li>');

        $(".save").on("click", function(){
            var value = $(".label").val();

            $("#newlabel").replaceWith("<li>" + value + "</li>");
        })
    })
})