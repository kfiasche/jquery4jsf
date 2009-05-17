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
			<jsp:include page="inc/menu-colopicker.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<h:form id="form1">
						<jq:panel header="Color picker">
							<jq:paragraph>
								Append color picker an field
							</jq:paragraph>
							<h:outputLabel value="Color picker:" for="colopicker" id="lbColorpicker"/>
							<h:inputText id="inputColorPicker" maxlength="6">
								<jq:colorPicker id="colorpicker" />
							</h:inputText>	
						</jq:panel>
					</h:form>
					<jq:panel header="Color picker - Source">
						<jq:syntaxHighlighting type="xml">
							&lt;jq:panel header=&quot;Color picker&quot;&gt;
							&lt;jq:paragraph&gt;
							Append color picker an field.
							&lt;/jq:paragraph&gt;
							&lt;h:outputLabel value=&quot;Color picker:&quot; for=&quot;colopicker&quot; id=&quot;lbColorpicker&quot;/&gt;
							&lt;h:inputText id=&quot;inputColorPicker&quot; maxlength=&quot;6&quot;&gt;
							&lt;jq:colorPicker id=&quot;colorpicker&quot; /&gt;
							&lt;/h:inputText&gt;	
							&lt;/jq:panel&gt;
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