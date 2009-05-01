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
			<jsp:include page="inc/menu-tooltip.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:panel id="panel" header="Tooltip default">
						<h:panelGrid columns="2">
							<h:outputLabel for="link" value="Anchor link: " />
							<h:outputLink id="link" value="#roma"><h:outputText value="Roma" />
								<jq:tooltip id="tooltip2" showURL="false" onbodyHandler="bodyHandler();"></jq:tooltip>
							</h:outputLink>
						</h:panelGrid>
					</jq:panel>
					
					<jq:outputScript type="text/javascript" charset="utf-8">
							 	function bodyHandler() { 
							 		var id = $('#link').attr("href");
							 		alert(id);
							 		var html = $(id).html();
							 		alert(html);
									return html;
								}
					</jq:outputScript>
					
					<jq:div id="roma">
						Rome (pronounced /ro?m/; Italian: Roma, pronounced [?roma]; Latin: Roma) is the capital of Italy and the country's largest and most populous city, with over 2.7 million residents in a municipality of some 1,285.3 km2 (496.3 sq mi), while the population of the urban area is estimated by Eurostat to be 3.46 million.[2] The metropolitan area of Rome is estimated by OECD to have a population of 3.7 million[3]. It is located in the central-western portion of the Italian Peninsula, on the Tiber river.
					</jq:div>
					
					<jq:panel id="panelsource" header="Source">
						<jq:syntaxHighlighting type="xml">
														&lt;jq:panel id=&quot;panel&quot; header=&quot;Tooltip default&quot;&gt;
						&lt;h:panelGrid columns=&quot;2&quot;&gt;
							&lt;h:outputLabel for=&quot;link&quot; value=&quot;Anchor link: &quot; /&gt;
							&lt;h:outputLink id=&quot;link&quot; value=&quot;#roma&quot;&gt;&lt;h:outputText value=&quot;Roma&quot; /&gt;
								&lt;jq:tooltip id=&quot;tooltip2&quot; showURL=&quot;false&quot; onbodyHandler=&quot;bodyHandler();&quot;&gt;&lt;/jq:tooltip&gt;
							&lt;/h:outputLink&gt;
						&lt;/h:panelGrid&gt;
					&lt;/jq:panel&gt;
					
					&lt;jq:outputScript type=&quot;text/javascript&quot; charset=&quot;utf-8&quot;&gt;
							 	function bodyHandler() { 
									 return $($(&#39;#link&#39;).attr(&quot;href&quot;)).html(); 
								}
					&lt;/jq:outputScript&gt;
						</jq:syntaxHighlighting>
					</jq:panel>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>