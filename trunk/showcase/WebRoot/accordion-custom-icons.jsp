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
			<jsp:include page="inc/menu-accordion.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<div class="demo">
						<jq:accordionPanel id="accordion"
							icons="{
    						header: 'ui-icon-circle-arrow-e',
   							headerSelected: 'ui-icon-circle-arrow-s'}">
							<jq:accordionSubPanel panelName="Section 1">
								<jq:div id="section1">
									<p>

										Mauris mauris ante, blandit et, ultrices a, suscipit eget,
										quam. Integer ut neque. Vivamus nisi metus, molestie vel,
										gravida in, condimentum sit amet, nunc. Nam a nibh. Donec
										suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur
										malesuada. Vestibulum a velit eu ante scelerisque vulputate.
									</p>
								</jq:div>
							</jq:accordionSubPanel>
							<jq:accordionSubPanel panelName="Section 2">
								<jq:div id="section2">
									<p>
										Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum
										sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet,
										mauris turpis porttitor velit, faucibus interdum tellus libero
										ac justo. Vivamus non quam. In suscipit faucibus urna.
									</p>
								</jq:div>
							</jq:accordionSubPanel>
							<jq:accordionSubPanel panelName="Section 3">
								<jq:div id="section3">
									<p>
										Nam enim risus, molestie et, porta ac, aliquam ac, risus.
										Quisque lobortis. Phasellus pellentesque purus in massa.
										Aenean in pede. Phasellus ac libero ac tellus pellentesque
										semper. Sed ac felis. Sed commodo, magna quis lacinia ornare,
										quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
									</p>
									<ul>
										<li>
											List item one
										</li>
										<li>
											List item two
										</li>

										<li>
											List item three
										</li>
									</ul>
								</jq:div>
							</jq:accordionSubPanel>
							<jq:accordionSubPanel panelName="Section 4">
								<jq:div id="section4">
									<p>
										Cras dictum. Pellentesque habitant morbi tristique senectus et
										netus et malesuada fames ac turpis egestas. Vestibulum ante
										ipsum primis in faucibus orci luctus et ultrices posuere
										cubilia Curae; Aenean lacinia mauris vel est.
									</p>

									<p>
										Suspendisse eu nisl. Nullam ut libero. Integer dignissim
										consequat lectus. Class aptent taciti sociosqu ad litora
										torquent per conubia nostra, per inceptos himenaeos.
									</p>
								</jq:div>
							</jq:accordionSubPanel>
						</jq:accordionPanel>

					</div>
					<!-- End demo -->
					<div class="ui-widget-content">
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