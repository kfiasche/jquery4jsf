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
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-left.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<div class="demo">
					<f:view>
						<jq:tabbedPanel id="tabs" event="click">
							<jq:tabPanel id="tabs-1" tabName="Nunc tincidunt">
								ciao 3
							</jq:tabPanel>
							<jq:tabPanel id="tabs-2" tabName="Proin dolor">
								ciao 2
							</jq:tabPanel>
							<jq:tabPanel id="tabs-3" tabName="Aenean lacinia">
								ciao
							</jq:tabPanel>
						</jq:tabbedPanel>
					</f:view>
				</div>
				<!-- End demo -->
				<div class="demo-description">
					<p>
						Click tabs to swap between content that is broken into logical
						sections.
					</p>
				</div>
				<!-- End demo-description -->
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>