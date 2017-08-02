<%@tag body-content="empty" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${sessaoUsuario != null}">
        Sr(a) ${sessaoUsuario}.
    </c:when>
    <c:otherwise>
        Usuário não logado
    </c:otherwise>

</c:choose>