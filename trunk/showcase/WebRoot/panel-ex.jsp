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
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%><link href="<%=basePath%>style.css" rel="stylesheet" type="text/css" />
		<style>
body {
	font-size: 62.5%;
	font-family: "Trebuchet MS", "Helvetica", "Arial", "Verdana",
		"sans-serif";
}

.panel {
	margin-top: 2em;
}
</style>
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-panel.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:outputScript type="text/javascript" charset="utf-8">
							function unfold() { alert(' \'unfold\' callback executed '); }
							function fold() { alert(' \'fold\' callback executed '); }
					</jq:outputScript>
					<div align="right" style="width:50%">
					<jq:panelEx collapseType="slide-right" header="Slide right example"
						id="panel1" styleClass="panel" style="width: 80%;">
							Slide right panel
					</jq:panelEx>
					</div>
					<jq:panelEx header="Slide left example" id="panel3"
						onfold="fold();" onunfold="unfold();" collapseType="slide-left"
						collapseSpeed="1000" styleClass="panel" style="width: 45%;">
							This panel slides to the left. Collapse speed set to 1000.
							<br />
							It also has 'fold' and 'unfold' callback functions defined.
					</jq:panelEx>
					<jq:panelEx header="Default collapsible panel example" id="panel2"
						collapsed="true" styleClass="panel"
						style="width: 25%; margin-left: 5%;">
						<jq:draggable id="panel2drag" for="panel2" />
							This is a default collapsible panel initially collapsed.
							<br />
						<b>Note:</b> It's draggable ;)
					</jq:panelEx>
					<jq:panelEx header="Simple panel example" id="panel4"
						collapsible="false" styleClass="panel" style="width: 32%;">
							This is a simple panel example width collapsibility turned off.
							<br />
						<div style="margin: .5em 0 0 1em; color: navy; cursor: pointer;"
							onclick="$('#panel4').panel('destroy');">
							Destroy this panel.
						</div>
					</jq:panelEx>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>