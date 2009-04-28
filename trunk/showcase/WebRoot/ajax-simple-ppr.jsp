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
		<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%><link
			href="<%=basePath%>style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-ajax.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<h:form id="form1">
						<jq:panel header="Partial Page Rendering - Basic">
							<h:panelGrid columns="2" style="margin-bottom:10px">
								<h:outputLabel for="firstname" value="Firstname:" />
								<h:inputText id="firstname" value="#{ajaxBean.nome}" />
								<h:outputLabel for="surname" value="Surname" />
								<h:inputText id="surname" value="#{ajaxBean.cognome}" />
								<jq:button id="button1"  onsuccess="alert('Thanks for your comment!');" target="displayOl" value="Ok"></jq:button>
								<jq:button id="button2" value="Reset" type="reset"></jq:button>
							</h:panelGrid>
							<h:panelGrid id="displayOl" columns="2">
								<h:outputLabel value="Firstname:" for="nome"/>
								<h:outputText id="nome" value="#{ajaxBean.nome}" />
								<h:outputLabel value="Surname:" for="cognome"/>
								<h:outputText id="cognome" value="#{ajaxBean.cognome}" />
							</h:panelGrid>
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