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
				<h2>
					jQuery for Java Server Faces
				</h2>
				<p>
					JQuery4JSF è una libreria open source per le Java Server Faces. Lo
					scopo di questa libreria è quello di mettere a disposizione dello
					svillupatore una suite di componenti contenente tencnologia RIA, e
					permettere allo sviluppatore di realizzare in maniera rapida le sue
					applicazioni. Questa libreria si basa sull'utilizzo di un altro
					framework open source molto famoso che è JQuery. JQuery è stato
					progettato per modificare il modo in cui si programma in
					JavaScript?. Questo è senza dubbio vero. Le principali funzioni
					JavaScript? (e i problemi ad esse associati) sono state sostituite
					da strutture più cross-browser che facilitano non di poco la vita
					di un coder. Quindi è nato lo scopo di realizzare una libreria jsf
					che facilizzi l'integrazione con JQuery e che mettesse allo
					sviluppatore una serie di componenti il + custom possibili.

				</p>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>