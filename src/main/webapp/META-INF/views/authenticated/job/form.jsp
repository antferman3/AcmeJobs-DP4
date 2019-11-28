<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path ="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="employer.job.form.label.description" path="description"/>
	
	<acme:form-textbox code = "employer.job.form.label.status" path ="status"/>
	<acme:form-textbox code ="employer.job.form.label.status" path ="descriptor.description"/>
	<acme:form-textbox code ="employer.job.form.label.status" path ="descriptor.duty.title"/>
	<acme:form-textbox code ="employer.job.form.label.status" path ="descriptor.duty.description"/>
	<acme:form-textbox code ="employer.job.form.label.status" path ="descriptor.duty.percentage"/>
 
	<acme:form-return code="employer.offer.form.button.return"/>  
	
</acme:form>