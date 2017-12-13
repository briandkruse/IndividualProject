<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content formcontent">
    <script src="./javascript/newPlan.js" type="text/javascript"></script>

    <%--JAVASRIPT EMBED--%>
    <%--jstl does not process in an external javascript file--%>
    <%--workaround: script directly on jsp page--%>

    <form id="plan">

    </form>
    <div id="buttondiv">
        <input type="button" id="newmeal" value="Start new meal"><br />
        <input type="submit" id="submit" value="Submit">
    </div>

    <script>
        var mealNumber = 0;
        var choiceNumber = 1;

        appendMeal();

        $("#newmeal").on("click", appendMeal);
        $("#newmeal").on("click", realignElements);

        function realignElements() {
            $("#buttondiv").detach().appendTo(".content");
            $("#footer").detach().appendTo(".wrapper");
        }

        function appendMeal() {
            choiceNumber = 1;
            mealNumber++;
            $("#plan").append(
                '<div id="meal' + mealNumber + '">' +
                '<h3>Meal ' + mealNumber + '</h3>' +
                '<input type="button" class="newchoice" id="newchoice' + mealNumber + '" value="Add another item to the menu">' +
                '</div>' +
                '<hr />'
            )
            appendChoice();
            $(".newchoice").on("click", appendChoice);
        }

        function appendChoice() {
            $('#meal' + mealNumber).append(
                '<div id="mealchoice' + choiceNumber + '">' +
                appendSelectElement() +
                '</div>'
            )
            choiceNumber++;
            $('#newchoice' + mealNumber).detach().appendTo("#meal"  + mealNumber);
        }

        function appendSelectElement(){
            return '<label for="choice' + choiceNumber + '" >Choice ' + choiceNumber + ':</label>' +
                '<select id="choice' + choiceNumber + '" name="choice' + choiceNumber + '" class="choice">' +
                '<option value="all">Choose one</option>' +
                '<c:forEach var="recipe" items="${recipes}">'   +
                '<option value="${recipe.id}">${recipe.name}</option>' +
                '</c:forEach>' +
                '</select><br />';
        }


    </script>
</div>