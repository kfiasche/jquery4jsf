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
		Dialog
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>dialog.faces">Default functionality</a>
		</li>
		<li>
			<a href="<%=basePath%>dialog-modal.faces">Modal dialog</a>
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