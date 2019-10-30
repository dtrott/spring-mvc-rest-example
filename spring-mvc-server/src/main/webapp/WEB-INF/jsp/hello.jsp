<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<spring:form modelAttribute="formHello">
    Hello ${formHello.name}
</spring:form>
