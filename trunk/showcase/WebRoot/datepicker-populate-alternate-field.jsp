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
								Date:
								<jq:datePicker id="datapicker" altField="datapickeralt"
									altFormat="DD, d MM, yy" size="12" />
								&nbsp;
								<h:inputText id="datapickeralt" size="30" />
							</p>

						</div>
						<!-- End demo -->

						<div class="ui-widget-content">

							<p>
								Populate an alternate field with its own date format whenever a
								date is selected using the
								<code>
									altField
								</code>
								and
								<code>
									altFormat
								</code>
								options. This feature could be used to present a human-friendly
								date for user selection, while passing a more computer-friendly
								date through for further processing.
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