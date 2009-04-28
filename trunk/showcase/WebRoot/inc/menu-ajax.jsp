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
		Ajax
	</h2>
	<ul>
		<li>
			<a href="<%=basePath%>ajax.faces">Ajax content update</a>
		</li>
		<li>
			<a href="<%=basePath%>ajax-simple-ppr.faces">Ajax simple partial page render</a>
		</li>
	</ul>
	<p></p>
</div>
<!--left side end -->