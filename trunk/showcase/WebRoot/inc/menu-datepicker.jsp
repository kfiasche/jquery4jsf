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
		Date Picker
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>datepicker.faces">Default functionality</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-format-date.faces">Format date</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-min-max.faces">Restrict date range</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker.faces">Localize calendar</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-populate-alternate-field.faces">Alternate
				field</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-button-bar.faces">Button bar</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-month-and-year.faces">Month and year menus</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-multiple-month.faces">Multiple months</a>
		</li>
		<li>
			<a href="<%=basePath%>datepicker-icon-trigger.faces">Icon trigger</a>
		</li>
	</ul>
	<p></p>
</div>
<!--left side end -->