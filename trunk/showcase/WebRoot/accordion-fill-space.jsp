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
			<jsp:include page="inc/menu-accordion.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
				<div class="demo">
				<h3 class="docs">Resize the outer container:</h3>
				<jq:div id="accordionResizer" style="padding:10px; width:350px; height:220px;" styleClass="ui-widget-content">
					<jq:accordionPanel id="accordion" fillSpace="true">
						<jq:accordionSubPanel panelName="Section 1">
							<h:outputText value="
								Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam.
								Integer ut neque. Vivamus nisi metus, molestie vel, gravida in,
								condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam
								mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a
								velit eu ante scelerisque vulputate.">
							</h:outputText>
						</jq:accordionSubPanel>
						<jq:accordionSubPanel panelName="Section 2">
							<h:outputText value="
								Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit
								amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris
								turpis porttitor velit, faucibus interdum tellus libero ac
								justo. Vivamus non quam. In suscipit faucibus urna.">
							</h:outputText>
						</jq:accordionSubPanel>
					</jq:accordionPanel>
					<span class="ui-icon ui-icon-grip-dotted-horizontal" style="margin:2px auto;"></span>
					<jq:resizable minHeight="140" onresize="$('#accordion').accordion('resize');"></jq:resizable>
					</jq:div>
					<jq:panel style="margin-top:7px; padding:10px; width:350px; height:50px;" header="I'm another panel">
						I'm another panel
					</jq:panel>
				</div>
				<!-- End demo -->
				<div class="demo-description">
					<p>
						Click headers to expand/collapse content that is broken into
						logical sections, much like tabs. Optionally, toggle sections
						open/closed on mouseover.
					</p>
					<p>
						The underlying HTML markup is a series of headers (H3 tags) and
						content divs so the content is usable without JavaScript.
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