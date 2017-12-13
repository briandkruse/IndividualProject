<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Sign Up" />
<%@include file="partials/head.jsp"%>
<script src="./javascript/newUser.js" type="text/javascript"></script>


<div id="dialog" title="Log In">

    <form action="./signUp" method="POST">
        <label for name="login">Login: </label>
        <input type="text" name="login"><br />
        <label for name="firstname">First Name: </label>
        <input type="text" name="firstname"><br />
        <label for name="lastname">Last Name: </label>
        <input type="text" name="lastname"><br />
        <label for name="email">Email: </label>
        <input type="text" name="email"><br />
        <label for name="password1">Password: </label>
        <input type="text" name="password1"><br />
        <label for name="password2">Repeat Password: </label>
        <input type="text" name="password2"><br />
        <input type="submit" value="Submit" name="usersubmit">
        <input type="button" value="Home" name="home" id="home">
    </form>
</div>
