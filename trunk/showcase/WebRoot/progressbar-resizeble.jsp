<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://www.jquery4jsf.org/jsf" prefix="jq" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
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
		<f:view>
			
				<div class="demo">
					<jq:progressBar id="progressBar" progressBarValue="30" resizable="true"></jq:progressBar>
				</div>
				<!-- End demo -->
				<div class="ui-widget-content">
					<p>
						The progress bar's widths are specified in percentages for
						flexible sizing so it will resize to fit its container. Try
						resizing the height and width of this bar to see how it maintains
						the correct proportions. (This is not necessarily a real-world
						example, but it's a good illustration of how flexibly all the
						plugins are coded.)
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