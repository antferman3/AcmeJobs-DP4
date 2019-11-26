<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-moment code="employer.job.form.label.title" path ="title"/>
	<acme:form-textarea code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-money code="employer.job.form.label.moreInfo" path=moreInfo/>
	<acme:form-textbox code="employer.job.form.label.description" path="description"/>
 
	<acme:form-return code="consumer.offer.form.button.return"/>  
	
</acme:form>