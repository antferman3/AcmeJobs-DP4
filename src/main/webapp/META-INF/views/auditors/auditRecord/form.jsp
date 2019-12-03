<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="auditor.auditRecord.form.label.reference" path="status"/>
	<acme:form-textbox code="auditor.auditRecord.form.label.title" path ="title"/>
	<acme:form-moment code="auditor.auditRecord.form.label.deadline" path="moment"/>
	<acme:form-money code="auditor.auditRecord.form.label.salary" path="body"/>
	
	
	<acme:form-return code="auditor.offer.form.button.return"/>  
	
</acme:form>