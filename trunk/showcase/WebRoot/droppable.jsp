<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.jquery4jsf.org/jsf" prefix="jq"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<f:view>
		<head>
			<meta http-equiv="Content-Type"
				content="text/html; charset=iso-8859-1" />
			<title>jQuery4jsf</title>
			<style type="text/css">
#draggable {
	width: 100px;
	height: 100px;
	padding: 0.5em;
	float: left;
	margin: 10px 10px 10px 0;
	background-color: white;
}

#droppable {
	width: 150px;
	height: 150px;
	padding: 0.5em;
	float: left;
	margin: 10px;
	background-color: white;
}
</style>
			<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%><link
				href="<%=basePath%>style.css" rel="stylesheet" type="text/css" />
			<jq:outputScript charset="utf-8" type="text/javascript">
function _onDrop(event, ui, thisObject){
$(thisObject).addClass('ui-state-highlight').find('span').html('Dropped!');
}
</jq:outputScript>
		</head>
		<body>
			<jsp:include page="inc/header.jsp"></jsp:include>
			<!--body part start -->
			<div id="mainBody">
				<jsp:include page="inc/menu-left.jsp"></jsp:include>
				<!--right side start -->
				<div id="rightPan">

					<div class="demo">
						<jq:draggable id="draggable">
							<span style="background-color: white;"> Drag me around </span>
						</jq:draggable>
						<jq:droppable id="droppable" ondrop="_onDrop(event, ui, $(this));">
							<span style="background-color: white;">Drop here</span>
						</jq:droppable>
					</div>
					<!-- End demo -->
					<div>
						<p>
							Enable draggable functionality on any DOM element. Move the
							draggable object by clicking on it with the mouse and dragging it
							anywhere within the viewport.
						</p>
					</div>

					<!-- End demo-description -->
				</div>
				<br class="blank" />
			</div>
			<!--body part end -->
			<jsp:include page="inc/footer.jsp"></jsp:include>
		</body>
	</f:view>
</html>