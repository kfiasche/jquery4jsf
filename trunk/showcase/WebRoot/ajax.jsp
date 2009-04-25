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
			<jsp:include page="inc/menu-ajax.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<h:form id="form1">
						<jq:panel header="Ajax Request bind Component Event">
							<h:panelGrid columns="3">
								<h:outputText value="KeyUp" />
								<h:inputText id="firstname" value="#{ajaxBean.nome}">
									<jq:ajaxEvent event="keyup" reRender="out1" />
								</h:inputText>
								<h:outputText id="out1" value="#{ajaxBean.nome}" />
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputText value="Blur" />
								<h:inputText id="surname" value="#{ajaxBean.cognome}">
									<jq:ajaxEvent event="blur" reRender="out2" />
								</h:inputText>
								<h:outputText id="out2" value="#{ajaxBean.cognome}" />
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