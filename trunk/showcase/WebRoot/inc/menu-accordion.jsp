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