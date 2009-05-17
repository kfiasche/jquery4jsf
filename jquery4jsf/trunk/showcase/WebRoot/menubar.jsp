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
		<!-- style exceptions for IE 6 -->
<!--[if IE 6]>
<style type="text/css">
	.fg-menu-ipod .fg-menu li { width: 95%; }
	.fg-menu-ipod .ui-widget-content { border:0; }
</style>
<![endif]-->
		<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%><link
			href="<%=basePath%>style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-left.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:panel header="Menu Bar">
						<jq:menuBar id="menuBar" flyOut="true" crumbDefaultText=" " showSpeed="400" label="Flat">
							<f:facet name="icon">
								<jq:icon type="carat-1-s"></jq:icon>
							</f:facet>
							<jq:menuItem id="menu1" label="Google" ></jq:menuItem>
							<jq:menuItem id="menu2" label="Yahoo" >
							</jq:menuItem>
							<jq:menuItem id="menu5" label="Sub menu">
								<jq:menuItem id="menu3" label="Altavista" disabled="true"></jq:menuItem>
								<jq:menuItem id="menu4" label="jQuery4jsf.org" ></jq:menuItem>
							</jq:menuItem>
						</jq:menuBar>
					</jq:panel>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>