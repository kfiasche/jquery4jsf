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
		Componenti
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>accordion.faces">Accordion</a>
		</li>
		<li>
			<a href="<%=basePath%>ajax.faces">Ajax</a>
		</li>
		<li>
			<a href="<%=basePath%>ajax-status.faces">Ajax status</a>
		</li>
		<li>
			<a href="<%=basePath%>autocomplete.faces">Autocomplete</a>
		</li>
		<li>
			<a href="<%=basePath%>button.faces">Button</a>
		</li>
		<li>
			<a href="<%=basePath%>calendar.faces">Calendar</a>
		</li>
		<li>
			<a href="<%=basePath%>carousel.faces">Carousel</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker.faces">Datepicker</a>
		</li>
		<li>
			<a href="<%=basePath%>dialog.faces">Dialog</a>
		</li>
		<li>
			<a href="<%=basePath%>draggable.faces">Draggable</a>
		</li>
		<li>
			<a href="<%=basePath%>droppable.faces">Droppable</a>
		</li>
		<li>
			<a href="<%=basePath%>effect.faces">Effects</a>
		</li>
		<li>
			<a href="<%=basePath%>icons.faces">Icons</a>
		</li>
		<li>
			<a href="<%=basePath%>panel.faces">Panel</a>
		</li>
		<li>
			<a href="<%=basePath%>progressbar.faces">Progress bar</a>
		</li>
		<li>
			<a href="<%=basePath%>resizable.faces">Resizable</a>
		</li>
		<li>
			<a href="<%=basePath%>slider.faces">Slider</a>
		</li>
		<li>
			<a href="<%=basePath%>tabbedpanel.faces">Tabbed panel</a>
		</li>
	</ul>
	<p></p>
</div>
<!--left side end -->