<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:set var="title" value="Sign Up"/>
<%@include file="partials/head.jsp" %>
<script src="./javascript/newUser.js" type="text/javascript"></script>


<div id="dialog" title="Sign Up">

    <form action="./signUp" method="POST" id="newuser">
        <label for="login">Login: </label>
        <input type="text" name="login" id="login"><br/>
        <label for="firstname">First Name: </label>
        <input type="text" name="firstname" id="firstname"><br/>
        <label for="lastname">Last Name: </label>
        <input type="text" name="lastname" id="lastname"><br/>
        <label for="email">Email: </label>
        <input type="text" name="email" id="email"><br/>
        <label for="password1">Password: </label>
        <input type="password" name="password1" id="password1"><br/>
        <label for="password2">Repeat Password: </label>
        <input type="password" name="password2" id="password2"><br/>
        <input type="submit" value="Submit" name="usersubmit">
        <input type="button" value="Home" name="home" id="home">
    </form>
</div>
