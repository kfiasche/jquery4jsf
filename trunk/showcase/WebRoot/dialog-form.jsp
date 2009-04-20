<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.jquery4jsf.org/jsf" prefix="jq"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=iso-8859-1" />
		<title>jQuery4jsf</title>
		<link href="/simple/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	font-size: 62.5%;
}

label,input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td,div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-button {
	outline: 0;
	margin: 0;
	padding: .4em 1em .5em;
	text-decoration: none; ! important;
	cursor: pointer;
	position: relative;
	text-align: center;
}

.ui-dialog .ui-state-highlight,.ui-dialog .ui-state-error {
	padding: .3em;
}
</style>
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-dialog.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:outputScript charset="utf-8" type="text/javascript">
						$(document).ready(function() { 
							$('#formUser\\:create-user').click(function() {
									$('#dialog').dialog('open');
									return false;
							});
							$('#formDialog\\:close-user').click(function() {
								$('#dialog').dialog('close');
									return false;
							});
						});
					</jq:outputScript>
					<jq:dialog id="dialog" title="Create new user" bgiframe="true"
						autoOpen="false" height="300" modal="true" resizable="true">
						<f:verbatim escape="false">
							<p id="validateTips">
								All form fields are required.
							</p>
						</f:verbatim>
						<h:form id="formDialog">
							<fieldset>
								<h:outputLabel for="name" value="Name" />
								<h:inputText value="#{user.name}" id="name"
									styleClass="text ui-widget-content ui-corner-all" />
								<h:outputLabel for="email" value="Email" />
								<h:inputText id="email" value="#{user.email}"
									styleClass="text ui-widget-content ui-corner-all" />
								<h:outputLabel for="password" value="Password" />
								<h:inputSecret id="password" value="#{user.password}"
									styleClass="text ui-widget-content ui-corner-all" />
							<h:commandButton id="create-user"
								styleClass="ui-button ui-state-default ui-corner-all"
								actionListener="#{dialogBean.doButtonDialog}"
								value="Create an account">
							</h:commandButton>
							<h:commandButton id="close-user"
								styleClass="ui-button ui-state-default ui-corner-all"
								value="close">
							</h:commandButton>
							</fieldset>
						</h:form>
					</jq:dialog>
					<h:form id="formUser">
					<div class="demo">
						<div id="users-contain" class="ui-widget">
							<h1>
								Existing Users:
							</h1>
							<h:dataTable id="users" styleClass="ui-widget ui-widget-content" headerClass="ui-widget-header "
								var="users" value="#{dialogBean.users}">
								<h:column>
									<f:facet name="header">
										<h:outputText value="Name"/>
									</f:facet>
									<h:outputText value="#{users.name}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Email"/>
									</f:facet>
									<h:outputText value="#{users.email}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Password"/>
									</f:facet>
									<h:outputText value="#{users.password}"/>
								</h:column>
							</h:dataTable>
						</div>
						<h:commandButton id="create-user"
							styleClass="ui-button ui-state-default ui-corner-all"
							value="Create new user">
						</h:commandButton>
					</div>
					</h:form>
					<!-- End demo -->
					<div class="ui-widget ui-widget-content ui-corner-all">
						<p>
							Use a modal dialog to require that the user enter data during a
							multi-step process. Embed form markup in the content area, set
							the
							<code>
								modal
							</code>
							option to true, and specify primary and secondary user actions
							with the
							<code>
								buttons
							</code>
							option.
						</p>
					</div>
					<!-- End demo-description -->
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>