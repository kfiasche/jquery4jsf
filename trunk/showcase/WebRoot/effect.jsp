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
				<f:view>
				<div class="demo">
					<div class="toggler">
						<jq:div id="effect" styleClass="ui-widget-content ui-corner-all">
							<h3 class="ui-widget-header ui-corner-all">
								Effect
							</h3>

							<p>
								Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
								Sed pede. Nulla lorem metus, adipiscing ut, luctus sed,
								hendrerit vitae, mi.
							</p>
						</jq:div>
						<jq:effect effect="blind" speed="1000" for="effect" callback="callback"></jq:effect>
						<jq:outputScript charset="utf-8" type="text/javascript">
		
		//callback function to bring a hidden box back
		function callback(){
			setTimeout(function(){
				$("#effect:hidden").removeAttr('style').hide().fadeIn();
			}, 1000);
		}
		
		</jq:outputScript>
					</div>
				</div>
				<!-- End demo -->
				<div class="demo-description">
					<p>
						Click the button above to show the effect.
						<a href="#" id="button">button</a>
					</p>
				</div>
				</f:view>
				<!-- End demo-description -->
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>