<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<spring:form commandName="formHello">
    Hello ${formHello.name}
</spring:form>
