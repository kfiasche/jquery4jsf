<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.jquery4jsf.org/jsf" prefix="jq"%>
<%@ taglib uri="http://facestrace.sourceforge.net" prefix="fc"%>
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
			<jsp:include page="inc/menu-button.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<h:form id="form1">
						<jq:panel header="Button">
							<h:panelGrid columns="2">
								<h:outputLabel id="label1" for="nome" value="Nome"></h:outputLabel>
								<h:inputText id="nome" value="#{buttonBean.nome}"></h:inputText>
								<h:outputLabel id="label2" for="cognome" value="Cognome"></h:outputLabel>
								<h:inputText id="cognome" value="#{buttonBean.cognome}"></h:inputText>
								<jq:button id="button1" target="panelUpdate" value="Ok"
									actionListener="#{buttonBean.provaActionListener}"
									onsuccess="var queryString = $('#form1').formSerialize(); alert(queryString); alert('Thanks for your comment!');"></jq:button>
								<jq:button id="button2" value="Reset" type="reset"></jq:button>
							</h:panelGrid>
						</jq:panel>
						<jq:panel id="panelUpdate" header="Button">
							<h:panelGrid columns="2">
								<h:outputLabel id="label3" for="nome_out" value="Nome"></h:outputLabel>
								<h:outputText id="nome_out" value="#{buttonBean.nome}"></h:outputText>
								<h:outputLabel id="label4" for="cognome_out" value="Cognome"></h:outputLabel>
								<h:outputText id="cognome_out" value="#{buttonBean.cognome}"></h:outputText>
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