<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Log In"/>
<%@include file="partials/head.jsp" %>
<script src="./javascript/login.js" type="text/javascript"></script>


<html>
<body>
<div id="dialog" title="Log In">
    <FORM ACTION="j_security_check" METHOD="POST">
        <TABLE>
            <TR>
                <TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
            <TR>
                <TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
            <TR>
                <TH><INPUT TYPE="SUBMIT" VALUE="Log In">
        </TABLE>
        <input type="button" value="Home" id="home" name="home">
    </FORM>
</div>
</body>
</html>