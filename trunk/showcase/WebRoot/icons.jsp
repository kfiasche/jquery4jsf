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
		<style>
			ul#icons {margin: 0; padding: 0;}
ul#icons li {margin: 2px; position: relative; padding: 4px 0; cursor: pointer; float: left;  list-style: none;}
ul#icons span.ui-icon {float: left; margin: 0 4px;}
			
		</style>
		<link href="/simple/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="inc/header.jsp"></jsp:include>
		<!--body part start -->
		<div id="mainBody">
			<jsp:include page="inc/menu-left.jsp"></jsp:include>
			<!--right side start -->
			<div id="rightPan">
				<f:view>
					<jq:panel header="jQuery Framework Icons">
						<f:verbatim escape="false">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<li class="ui-state-default ui-corner-all" title="carat-1-n">
									<jq:icon type="carat-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-ne">
									<jq:icon type="carat-1-ne"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-e">
									<jq:icon type="carat-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-se">
									<jq:icon type="carat-1-se"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-s">
									<jq:icon type="carat-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-sw">
									<jq:icon type="carat-1-sw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-w">
									<jq:icon type="carat-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-1-nw">
									<jq:icon type="carat-1-nw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-2-n-s">
									<jq:icon type="carat-2-n-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="carat-2-e-w">
									<jq:icon type="carat-2-e-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-n">
									<jq:icon type="triangle-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-ne">
									<jq:icon type="triangle-1-ne"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-e">
									<jq:icon type="triangle-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-se">
									<jq:icon type="triangle-1-se"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-s">
									<jq:icon type="triangle-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-sw">
									<jq:icon type="triangle-1-sw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-w">
									<jq:icon type="triangle-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="triangle-1-nw">
									<jq:icon type="triangle-1-nw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="triangle-2-n-s">
									<jq:icon type="triangle-2-n-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="triangle-2-e-w">
									<jq:icon type="triangle-2-e-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-n">
									<jq:icon type="arrow-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-ne">
									<jq:icon type="arrow-1-ne"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-e">
									<jq:icon type="arrow-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-se">
									<jq:icon type="arrow-1-se"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-s">
									<jq:icon type="arrow-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-sw">
									<jq:icon type="arrow-1-sw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-w">
									<jq:icon type="arrow-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-1-nw">
									<jq:icon type="arrow-1-nw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-2-n-s">
									<jq:icon type="arrow-2-n-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-2-ne-sw">
									<jq:icon type="arrow-2-ne-sw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-2-e-w">
									<jq:icon type="arrow-2-e-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-2-se-nw">
									<jq:icon type="arrow-2-se-nw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrowstop-1-n">
									<jq:icon type="arrowstop-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrowstop-1-e">
									<jq:icon type="arrowstop-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrowstop-1-s">
									<jq:icon type="arrowstop-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrowstop-1-w">
									<jq:icon type="arrowstop-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-n">
									<jq:icon type="arrowthick-1-n"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-ne">
									<jq:icon type="arrowthick-1-ne"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-e">
									<jq:icon type="arrowthick-1-e"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-se">
									<jq:icon type="arrowthick-1-se"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-s">
									<jq:icon type="arrowthick-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-sw">
									<jq:icon type="arrowthick-1-sw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-w">
									<jq:icon type="arrowthick-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-1-nw">
									<jq:icon type="arrowthick-1-nw"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-2-n-s">
									<jq:icon type="arrowthick-2-n-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-2-ne-sw">
									<jq:icon type="arrowthick-2-ne-sw"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="arrowthick-2-e-w">
									<jq:icon type="arrowthick-2-e-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthick-2-se-nw">
									<jq:icon type="arrowthick-2-se-nw"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="arrowthickstop-1-n">
									<jq:icon type="arrowthickstop-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthickstop-1-e">
									<jq:icon type="arrowthickstop-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthickstop-1-s">
									<jq:icon type="arrowthickstop-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowthickstop-1-w">
									<jq:icon type="arrowthickstop-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowreturnthick-1-w">
									<jq:icon type="arrowreturnthick-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowreturnthick-1-n">
									<jq:icon type="arrowreturnthick-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowreturnthick-1-e">
									<jq:icon type="arrowreturnthick-1-e"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="arrowreturnthick-1-s">
									<jq:icon type="arrowreturnthick-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowreturn-1-w">
									<jq:icon type="arrowreturn-1-w"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="arrowreturn-1-n">
									<jq:icon type="arrowreturn-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowreturn-1-e">
									<jq:icon type="arrowreturn-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowreturn-1-s">
									<jq:icon type="arrowreturn-1-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowrefresh-1-w">
									<jq:icon type="arrowrefresh-1-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowrefresh-1-n">
									<jq:icon type="arrowrefresh-1-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowrefresh-1-e">
									<jq:icon type="arrowrefresh-1-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="arrowrefresh-1-s">
									<jq:icon type="arrowrefresh-1-s"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="arrow-4">
									<jq:icon type="arrow-4"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="arrow-4-diag">
									<jq:icon type="arrow-4-diag"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="extlink">
									<jq:icon type="extlink"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="newwin">
									<jq:icon type="newwin"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="refresh">
									<jq:icon type="refresh"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="shuffle">
									<jq:icon type="shuffle"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="transfer-e-w">
									<jq:icon type="transfer-e-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="transferthick-e-w">
									<jq:icon type="transferthick-e-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="folder-collapsed">
									<jq:icon type="folder-collapsed"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="folder-open">
									<jq:icon type="folder-open"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="document">
									<jq:icon type="document"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="document-b">
									<jq:icon type="document-b"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="note">
									<jq:icon type="note"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="mail-closed">
									<jq:icon type="mail-closed"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="mail-open">
									<jq:icon type="mail-open"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="suitcase">
									<jq:icon type="suitcase"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="comment">
									<jq:icon type="comment"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="person">
									<jq:icon type="person"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="print">
									<jq:icon type="print"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="trash">
									<jq:icon type="trash"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="locked">
									<jq:icon type="locked"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="unlocked">
									<jq:icon type="unlocked"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="bookmark">
									<jq:icon type="bookmark"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="tag">
									<jq:icon type="tag"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="home">
									<jq:icon type="home"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="flag">
									<jq:icon type="flag"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="calculator">
									<jq:icon type="calculator"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="cart">
									<jq:icon type="cart"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="pencil">
									<jq:icon type="pencil"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="clock">
									<jq:icon type="clock"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="disk">
									<jq:icon type="disk"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="calendar">
									<jq:icon type="calendar"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="zoomin">
									<jq:icon type="zoomin"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="zoomout">
									<jq:icon type="zoomout"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="search">
									<jq:icon type="search"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="wrench">
									<jq:icon type="wrench"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="gear">
									<jq:icon type="gear"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="heart">
									<jq:icon type="heart"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="star">
									<jq:icon type="star"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="link">
									<jq:icon type="link"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="cancel">
									<jq:icon type="cancel"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="plus">
									<jq:icon type="plus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="plusthick">
									<jq:icon type="plusthick"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="minus">
									<jq:icon type="minus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="minusthick">
									<jq:icon type="minusthick"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="close">
									<jq:icon type="close"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="closethick">
									<jq:icon type="closethick"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="key">
									<jq:icon type="key"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="lightbulb">
									<jq:icon type="lightbulb"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="scissors">
									<jq:icon type="scissors"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="clipboard">
									<jq:icon type="clipboard"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="copy">
									<jq:icon type="copy"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="contact">
									<jq:icon type="contact"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="image">
									<jq:icon type="image"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="video">
									<jq:icon type="video"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="script">
									<jq:icon type="script"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="alert">
									<jq:icon type="alert"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="info">
									<jq:icon type="info"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="notice">
									<jq:icon type="notice"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="help">
									<jq:icon type="help"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="check">
									<jq:icon type="check"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="bullet">
									<jq:icon type="bullet"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="radio-off">
									<jq:icon type="radio-off"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="radio-on">
									<jq:icon type="radio-on"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="pin-w">
									<jq:icon type="pin-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="pin-s">
									<jq:icon type="pin-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="play">
									<jq:icon type="play"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="pause">
									<jq:icon type="pause"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="seek-next">
									<jq:icon type="seek-next"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="seek-prev">
									<jq:icon type="seek-prev"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="seek-end">
									<jq:icon type="seek-end"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="seek-first">
									<jq:icon type="seek-first"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="stop">
									<jq:icon type="stop"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="eject">
									<jq:icon type="eject"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="volume-off">
									<jq:icon type="volume-off"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="volume-on">
									<jq:icon type="volume-on"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="power">
									<jq:icon type="power"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="signal-diag">
									<jq:icon type="signal-diag"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="signal">
									<jq:icon type="signal"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="battery-0">
									<jq:icon type="battery-0"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="battery-1">
									<jq:icon type="battery-1"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all" title="battery-2">
									<jq:icon type="battery-2"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="battery-3">
									<jq:icon type="battery-3"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="circle-plus">
									<jq:icon type="circle-plus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="circle-minus">
									<jq:icon type="circle-minus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="circle-close">
									<jq:icon type="circle-close"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="circle-triangle-e">
									<jq:icon type="circle-triangle-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-triangle-s">
									<jq:icon type="circle-triangle-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-triangle-w">
									<jq:icon type="circle-triangle-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-triangle-n">
									<jq:icon type="circle-triangle-n"></jq:icon>
								</li>

								<li class="ui-state-default ui-corner-all"
									title="circle-arrow-e">
									<jq:icon type="circle-arrow-e"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-arrow-s">
									<jq:icon type="circle-arrow-s"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-arrow-w">
									<jq:icon type="circle-arrow-w"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-arrow-n">
									<jq:icon type="circle-arrow-n"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="circle-zoomin">
									<jq:icon type="circle-zoomin"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circle-zoomout">
									<jq:icon type="circle-zoomout"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all" title="circle-check">
									<jq:icon type="circle-check"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circlesmall-plus">
									<jq:icon type="circlesmall-plus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circlesmall-minus">
									<jq:icon type="circlesmall-minus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="circlesmall-close">
									<jq:icon type="circlesmall-close"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="squaresmall-plus">
									<jq:icon type="squaresmall-plus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="squaresmall-minus">
									<jq:icon type="squaresmall-minus"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="squaresmall-close">
									<jq:icon type="squaresmall-close"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="grip-dotted-vertical">
									<jq:icon type="grip-dotted-vertical"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="grip-dotted-horizontal">
									<jq:icon type="grip-dotted-horizontal"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="grip-solid-vertical">
									<jq:icon type="grip-solid-vertical"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="grip-solid-horizontal">
									<jq:icon type="grip-solid-horizontal"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="gripsmall-diagonal-se">
									<jq:icon type="gripsmall-diagonal-se"></jq:icon>
								</li>
								<li class="ui-state-default ui-corner-all"
									title="grip-diagonal-se">
									<jq:icon type="grip-diagonal-se"></jq:icon>
								</li>
							</ul>
						</f:verbatim>
					</jq:panel>
				</f:view>
			</div>
			<br class="blank" />
		</div>
		<!--body part end -->
		<jsp:include page="inc/footer.jsp"></jsp:include>
	</body>
</html>