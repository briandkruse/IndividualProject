<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" scope="request" value="Welcome!"/>
<%@include file="partials/head.jsp" %>
<html>
<body>

<div class="wrapper">
    <%@include file="partials/navigation.jsp" %>
    <%@include file="content/index-content.jsp" %>
    <%@include file="partials/footer.jsp" %>
</div>
</body>
</html>
