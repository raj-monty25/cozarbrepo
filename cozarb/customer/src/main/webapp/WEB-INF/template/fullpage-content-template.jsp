<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
	<!--<![endif]-->
	
	<!-- Mirrored from aaryaweb.info/html/shopstyle/sht001/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 20 Oct 2019 19:26:29 GMT -->
	<head>
		<!-- Basic Page Needs
		  ================================================== -->
		<meta charset="utf-8">
		<title><tiles:getAsString name="title"/></title>
		<!-- SEO Meta
		  ================================================== -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="description" content="">
		<meta name="keywords" content="">
		<meta name="distribution" content="global">
		<meta name="revisit-after" content="2 Days">
		<meta name="robots" content="ALL">
		<meta name="rating" content="8 YEARS">
		<meta name="Language" content="en-us">
		<meta name="GOOGLEBOT" content="NOARCHIVE">
		<!-- Mobile Specific Metas
		  ================================================== -->
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- CSS
		  ================================================== -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/font-awesome/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/jquery-ui/jquery-ui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/owl.carousel.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fotorama.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/magnific-popup.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png">
		<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/images/apple-touch-icon.html">
		<link rel="apple-touch-icon" sizes="72x72"
			href="${pageContext.request.contextPath}/images/apple-touch-icon-72x72.html">
		<link rel="apple-touch-icon" sizes="114x114"
			href="${pageContext.request.contextPath}/images/apple-touch-icon-114x114.html">
		<script src="${pageContext.request.contextPath}/webjars/jquery/jquery.min.js"></script>
		<script
			src="../../../../cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
		<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.downCount.js"></script>
		<script src="${pageContext.request.contextPath}/webjars/jquery-ui/jquery-ui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/fotorama.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.js"></script>
		<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/custom.js"></script>
		<script src="${pageContext.request.contextPath}/js/common.js"></script>
	</head>
	<body class="homepage">
		<div class="se-pre-con"></div>
		<div class="main">
	
			<header class="navbar navbar-custom container-full-sm" id="header">
				<div class="header-middle">
					<div class="container">
						<hr>
						<div class="row">
							<div class="col-xl-3 col-md-3 col-lgmd-20per">
								<div class="header-middle-left">
									<div class="navbar-header float-none-sm">
										<a class="navbar-brand page-scroll" href="index-2.html"> <img
											alt="Shopstyle" src="images/logo.png">
										</a>
									</div>
								</div>
							</div>
							<tiles:insertAttribute name="global-search"/>
							<tiles:insertAttribute name="cart-icon"/>
						</div>
					</div>
				</div>
				<tiles:insertAttribute name="header-bottom"/>
			</header>
	
			<!-- CONTAIN START -->
			<tiles:insertAttribute name="body"/>
			<!-- CONTAINER END -->
	
			<!-- NEWS Letter Start -->
			<tiles:insertAttribute name="news-letter"/>
			<!-- NEWS Letter End -->
			
			<!-- Footer START -->
			<tiles:insertAttribute name="footer"/>
			<!-- Footer END -->
		</div>
	</body>
	<!-- Mirrored from aaryaweb.info/html/shopstyle/sht001/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 20 Oct 2019 19:29:17 GMT -->
</html>
