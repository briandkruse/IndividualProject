<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Failed Login" />
<%@include file="partials/head.jsp"%>
<script src="./javascript/failedlogin.js" type="text/javascript"></script>

<html>
<body>
<div id="dialog" title="Login Error">
    <p>Username or Password is Incorrect</p>
    <input id="button" type="button" value="Return Home" name="home">
</div>

</div>
</body>
</html>