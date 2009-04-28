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
					<div class="demo">
						<div class="toggler">
							<h:panelGrid columns="3">
								<jq:div id="Blind" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Blind
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="blind" speed="1000"
										for="Blind" callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Bounce" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Bounce
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="bounce" speed="1000"
										for="Bounce" callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Clip" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Clip
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="clip" speed="1000" for="Clip"
										callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Drop" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Drop
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="drop" speed="1000" for="Drop"
										callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Explode"
									styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Explode
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="explode" speed="1000"
										for="Explode" callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Fold" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Fold
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="fold" speed="1000" for="Fold"
										callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Highlight"
									styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Highlight
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="highlight" speed="1000"
										for="Highlight" callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Puff" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Puff
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="puff" speed="1000" for="Puff"
										callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Scale" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Scale
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="scale" speed="1000"
										for="Scale" options="percent: 0" callback="callback"></jq:effect>
								</jq:div>
								<jq:div id="Shake" styleClass="ui-widget-content ui-corner-all"
									style="width: 100px;">
									<h3 class="ui-widget-header ui-corner-all">
										Effect Shake
									</h3>
									<h:outputText value="click" />
									<jq:effect event="click" effect="shake" speed="1000"
										for="Shake" callback="callback"></jq:effect>
								</jq:div>
							</h:panelGrid>
							<jq:outputScript charset="utf-8" type="text/javascript">
						//callback function to bring a hidden box back
						function callback(){
							setTimeout(function(){
								$(".ui-widget-content:hidden").removeAttr('style').hide().fadeIn();
							}, 1000);
						}
						</jq:outputScript>
						</div>
					</div>
					<!-- End demo -->
					<div class="ui-widget-content">
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