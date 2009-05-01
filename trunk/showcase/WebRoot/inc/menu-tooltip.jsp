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
		Tooltip
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>tooltip.faces">Default functionality</a>
		</li>
		<li>
			<a href="<%=basePath%>tooltip-read-a-reference.faces">Read a reference</a>
		</li>
		<li>
			<a href="<%=basePath%>dialog-message.faces">Modal message</a>
		</li>
		<li>
			<a href="<%=basePath%>dialog-confirmation.faces">Modal confirmation</a>
		</li>
		<li>
			<a href="<%=basePath%>dialog-form.faces">Modal form</a>
		</li>
	</ul>
	<p></p>
</div>
<!--left side end -->