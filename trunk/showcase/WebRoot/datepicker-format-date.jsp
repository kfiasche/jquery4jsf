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
			<jsp:include page="inc/menu-datepicker.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<h:form id="form1">
						<div class="demo">
							<p>
								Format options:
								<br />
								<h:panelGrid columns="1" id="panelFormat">
									<h:outputText value="Default - mm/dd/yy" />
									<jq:datePicker id="datapicker1" size="30" dateFormat="mm/dd/yy" />
									<h:outputText value="ISO 8601 - yy-mm-dd" />
									<jq:datePicker id="datapicker2" size="30" dateFormat="yy-mm-dd" />
									<h:outputText value="Short - d M, yy" />
									<jq:datePicker id="datapicker3" size="30" dateFormat="d M, y" />
									<h:outputText value="Medium - d MM, yy" />
									<jq:datePicker id="datapicker4" size="30" dateFormat="d MM, y" />
									<h:outputText value="Full - DD, d MM, yy" />
									<jq:datePicker id="datapicker5" size="30"
										dateFormat="DD, d MM, yy" />
								</h:panelGrid>
							</p>
						</div>
						<!-- End demo -->
						<div class="ui-widget-content">
							<p>
								Display date feedback in a variety of ways. Choose a date format
								from the dropdown, then click on the input and select a date to
								see it in that format.
							</p>
						</div>
						<!-- End demo-description -->
					</h:form>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>