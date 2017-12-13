$(document).ready(function () {
    $("#newuser").validate({
        rules: {
            login: "required",
            firstname: "required",
            lastname: "required",
            password1: "required",
            password2: "required"
        },
        messages: {
            firstname: "Enter First Name",
            lastname: "Enter First Name",
            login: "Enter your user login",
            password1: "Enter A Password",
            password2: "Repeat Password",
        },
        submitHandler: function (form) {
            form.submit();
        }
    });

    $("#dialog").dialog();
    $("#home").on("click", function () {
        window.location.href = "/IndividualProject/index.jsp";
    })
})