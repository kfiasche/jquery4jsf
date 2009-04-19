<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://www.jquery4jsf.org/jsf" prefix="jf"%>
<jf:accordionPanel id="accordianPanel" active="1" autoHeight="true"
	clearStyle="false" navigation="true" event="mouseover">
	<jf:accordionSubPanel id="a" panelName="#{accordionBean.panelName}">
		<h:outputText id="testoa" value="testo a"></h:outputText>
	</jf:accordionSubPanel>
	<jf:accordionSubPanel id="b" panelName="Auto Complete">
		<h:outputLink id="link1" value="/simple/faces/autocomplete.jsp">
			<h:outputText id="text2" value="Auto complete simple"></h:outputText>
		</h:outputLink>
	</jf:accordionSubPanel>
	<jf:accordionSubPanel id="datePikerPanel" panelName="Date Picker">
		<h:panelGrid columns="1" id="panelGridDatePiker">
			<h:outputLink id="linkDatepiker1"
				value="/simple/faces/datepicker-default.jsp">
				<h:outputText id="text2Datepiker" value="Date Picker Default"></h:outputText>
			</h:outputLink>
			<h:outputLink id="linkDatepiker2"
				value="/simple/faces/datepicker-format-date.jsp">
				<h:outputText id="text3Datepiker"
					value="Date Picker - Format Date"></h:outputText>
			</h:outputLink>
			<h:outputLink id="linkDatepiker3"
				value="/simple/faces/datepicker-min-max.jsp">
				<h:outputText id="text4Datepiker"
					value="Date Picker - Rage Two Date"></h:outputText>
			</h:outputLink>
			<h:outputLink id="linkDatepiker4"
				value="/simple/faces/datepicker-populate-alternate-field.jsp">
				<h:outputText id="text5Datepiker"
					value="Date Picker - Populate alternate field"></h:outputText>
			</h:outputLink>
		</h:panelGrid>
	</jf:accordionSubPanel>
	<jf:accordionSubPanel id="calendarPanel" panelName="Calendar">
		<h:panelGrid columns="1" id="panelGridCalendar">
			<h:outputLink id="linkCalendar1"
				value="/simple/faces/calendar.jsp">
				<h:outputText id="text2Calendar" value="Calendar Default"></h:outputText>
			</h:outputLink>
		</h:panelGrid>
	</jf:accordionSubPanel>
	<jf:accordionSubPanel id="dialogPanel" panelName="Modal Dialog">
		<h:outputLink id="dialogPanelLink1" value="/simple/faces/dialog.jsp">
			<h:outputText id="dialogPanelText2" value="Modal"></h:outputText>
		</h:outputLink>
	</jf:accordionSubPanel>
	<jf:accordionSubPanel id="progressBarPanel" panelName="Progress Bar">
		<h:panelGrid columns="1" id="panelGridProgressBar">
			<h:outputLink id="progressBarPanelLink1" value="/simple/faces/progressbar.jsp">
				<h:outputText id="progressBarPanelText1" value="Progress Bar Simple"></h:outputText>
			</h:outputLink>
			<h:outputLink id="progressBarPanelLink2" value="/simple/faces/progressbar-resizeble.jsp">
				<h:outputText id="progressBarPanelText2" value="Progress Bar Resizeble"></h:outputText>
			</h:outputLink>
			<h:outputLink id="progressBarPanelLink3" value="/simple/faces/progressbar-animated.jsp">
				<h:outputText id="progressBarPanelText3" value="Progress Bar Animated"></h:outputText>
			</h:outputLink>
		</h:panelGrid>
	</jf:accordionSubPanel>
</jf:accordionPanel>