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
		<link href="/simple/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-dialog.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:dialog id="dialog" title="Download complete" bgiframe="true"
						autoOpen="true" modal="true"
						buttons="{Ok: function() { $(this).dialog('close');}}">
						<f:verbatim escape="false">
							<p>
								<span class="ui-icon ui-icon-circle-check"
									style="float: left; margin: 0 7px 50px 0;"></span> Your files
								have downloaded successfully into the My Downloads folder.
							</p>
							<p>
								Currently using
								<b>36% of your storage space</b>.
							</p>
						</f:verbatim>
					</jq:dialog>
					<h:form id="form1">
						<div class="demo">

							<!-- Sample page content to illustrate the layering of the dialog -->
							<div class="hiddenInViewSource" style="padding: 20px;">
								<p>
									Sed vel diam id libero
									<a href="http://example.com">rutrum convallis</a>. Donec
									aliquet leo vel magna. Phasellus rhoncus faucibus ante. Etiam
									bibendum, enim faucibus aliquet rhoncus, arcu felis ultricies
									neque, sit amet auctor elit eros a lectus.
								</p>
								<input value="text input" />
								<br />
								<input type="checkbox" />
								checkbox
								<br />
								<input type="radio" />
								radio
								<br />
								<select>
									<option>
										select
									</option>
								</select>
								<br />
								<br />
								<textarea>textarea</textarea>
								<br />
							</div>
							<!-- End sample page content -->
							<div class="ui-widget-content">
								<p>
									Use a modal dialog to explicitly acknowledge information or an
									action before continuing their work. Set the
									<code>
										modal
									</code>
									option to true, and specify a primary action (Ok) with the
									<code>
										buttons
									</code>
									option.
								</p>
							</div>
							<!-- End demo-description -->
						</div>
						<!-- End demo -->
					</h:form>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>