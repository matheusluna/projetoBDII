<%@tag body-content="empty" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${sessaoId != null}">
        ${sessaoId}.
    </c:when>

</c:choose>