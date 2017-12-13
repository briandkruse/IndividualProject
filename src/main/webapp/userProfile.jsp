<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Profile"/>
<%@include file="partials/head.jsp" %>

<html>
<body>
<div class="wrapper">
    <%@include file="partials/navigation.jsp" %>
    <%@include file="content/userProfile-content.jsp" %>
    <%@include file="partials/footer.jsp" %>
</div>
</body>
</html>
