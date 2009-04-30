<%--

     Copyright (c) 2009 Giuseppe Trisciuoglio

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.


--%>
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
		<style type="text/css">
			.ui-progressbar-value { background-image: url(images/pbar-ani.gif); }
		</style>
		<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%><link
			href="<%=basePath%>style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-ajax-status.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<h:form id="form1">
						<jq:ajaxStatus id="statusAjax">
							<f:facet name="start">
								<h:graphicImage value="/images/ajax-loader.gif"></h:graphicImage>
							</f:facet>
							<f:facet name="complete">
								<h:outputText value="Ajax Request complete"></h:outputText>
							</f:facet>
							<f:facet name="error">
								<jq:dialog title="Error" modal="true" id="dialogAjaxError" autoOpen="false">
									<jq:icon type="alert"></jq:icon>
									<h:outputText value="Ajax Request Error"></h:outputText>
								</jq:dialog>
							</f:facet>
						</jq:ajaxStatus>
						<jq:panel header="Ajax PPR">
							<h:panelGrid id="panelGrid" columns="2">
								<h:outputLabel value="Nome" for="nome"/>
								<h:inputText value="#{user.name}" id="nome"/>
								<h:outputLabel value="Cognome" for="cognome"/>
								<h:inputText value="#{user.lastname}" id="cognome"/>
								<h:outputLabel value="Email" for="email"/>
								<h:inputText value="#{user.email}" id="email"/>
								<jq:button id="ok" value="Salva" target="panelDatatable" actionListener="#{dialogBean.addUser}"/>
							</h:panelGrid>
							<h:panelGroup id="panelDatatable">
							<h:dataTable id="dataTable" 
								value="#{dialogBean.users}"
								var="element"
								cellspacing="0" cellpadding="0" 
								border="0" width="100%">
								<h:column>
									<f:facet name="header">
										<h:outputText value="Nome"/>
									</f:facet>
									<h:outputText value="#{element.name}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Cognome"/>
									</f:facet>
									<h:outputText value="#{element.lastname}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Email"/>
									</f:facet>
									<h:outputText value="#{element.email}"/>
								</h:column>
							</h:dataTable>
							</h:panelGroup>
						</jq:panel>
					</h:form>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>