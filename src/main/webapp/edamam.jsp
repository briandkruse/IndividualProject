<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" scope="request" value="Search Edamam"/>
<%@include file="partials/head.jsp" %>
<html>
<body>

<div class="wrapper">
    <%@include file="partials/navigation.jsp" %>
    <%@include file="content/edamam-content.jsp" %>
    <%@include file="partials/footer.jsp" %>
</div>
</body>
</html>
