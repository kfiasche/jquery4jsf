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
<!--left side start -->
<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<div id="leftPan">
	<h2 style="font-size: 15px;">
		Menu
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>index.faces">Home</a>
		</li>
	</ul>
	<h2 style="font-size: 15px;">
		Accordion
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>accordion.faces">Default functionality</a>
		</li>
		<li>
			<a href="<%=basePath%>accordion-fill-space.faces">Fill space</a>
		</li>
		<li>
			<a href="<%=basePath%>accordion-no-auto-height.faces">No auto height</a>
		</li>
		<li>
			<a href="<%=basePath%>accordion-collapse-content.faces">Collapse content</a>
		</li>
		<li>
			<a href="<%=basePath%>accordion-open-mouseover.faces">Open on mouseover</a>
		</li>
		<li>
			<a href="<%=basePath%>accordion-custom-icons.faces">Customize icons</a>
		</li>
	</ul>
	<p></p>
</div>
<!--left side end -->