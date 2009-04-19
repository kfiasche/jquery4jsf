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
						<jq:slider id="slider"></jq:slider>
					</div>
					<!-- End demo -->
					<div class="demo-description">
						<p>
							The basic slider is horizontal and has a single handle that can
							be moved with the mouse or by using the arrow keys.
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