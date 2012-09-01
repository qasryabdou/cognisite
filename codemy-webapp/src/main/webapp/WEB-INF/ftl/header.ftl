<#assign
security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign contextPath=springMacroRequestContext.getContextPath()>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><@spring.message "layout.welcome"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Cognicap Team">
<meta name="Description"
	content="Apprendre le JAVA facilement et rapidement. Cognicap vous permets de booster votre carri&egrave;re. Essayez-nous!" />
<meta name="keywords"
	content="Rabat, Maroc, Casablanca, Fromation Java, Spring, Hibernate, Linux, Struts, PIC, Sonar, Hudson, Certification, SCJP, SJWCD, web site management, wcms, open source, java, java cms" />
<meta name="viewport" content="width=device-width">
<meta name="creator" content="Cognicap Team" />
<meta name="format" content="text/html" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta name="google-site-verification"
	content="aYbWg3grOwIlNwiznAS3waq2tCkuA4JuGZ39T9ShVYU" />

<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
      <script src="${contextPath}/static/3rdparty/bootstrap/html5.js"></script>
    <![endif]-->
<!--[if IE]>
	<link rel="stylesheet" type="text/css" href="css/custom-theme/jquery.ui.1.8.16.ie.css"/>
<![endif]-->
<!-- Le styles -->
<link
	href="${contextPath}/static/css/custom-theme/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link href="${contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/static/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="${contextPath}/static/css/docs.css" rel="stylesheet">
<link href="${contextPath}/static/css/codemy.css"
	rel="stylesheet" />
<link rel="stylesheet" href="${contextPath}/static/css/demo_page.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}/static/css/demo_table.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}/static/css/demo_table_jui.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}/static/css/smoothness/jquery-ui-1.8.21.custom.css"  type="text/css" />
<link rel="stylesheet" href="${contextPath}/static/media/css/TableTools_JUI.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}/static/css/defaultOverride.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}/static/css/validationEngine.jquery.css" type="text/css" />
</head>

<body class="preview" data-offset="50" data-target=".subnav"
	data-spy="scroll">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="${contextPath}/">Cognicap</a>
				<div class="btn-group pull-right">
					<@security.authorize ifNotGranted="ROLE_USER"> <a
						class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<@spring.message "layout.getin"/> </a>
					<ul class="dropdown-menu">
						<li><a href="${contextPath}/login/"><@spring.message
								"layout.login"/></a></li>
						<li><a href="${contextPath}/Registration/"><@spring.message
								"layout.register"/></a></li>
					</ul>
					</@security.authorize> <@security.authorize
					ifAllGranted="ROLE_USER"> <a class="btn dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="icon-user"></i>
						${userContext.username} <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li class="divider"></li>
						<li><a href="#"><a href="${contextPath}/logout"><@spring.message
									"layout.logout"/></a></a></li>
					</ul>
					</@security.authorize>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="${contextPath}/Trainings"><@spring.message
								"nav-menu.alltraining"/></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><@spring.message "nav-menu.about"/><b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${contextPath}/About#values">Nos Valeurs</a></li>
								<li><a href="${contextPath}/About#mission">Notre
										mission</a></li>
								<li><a href="${contextPath}/Contact">Contactez-nous!</a></li>
								<li class="divider"></li>
								<li><a href="${contextPath}/Ourstudio">Comment venir?</a></li>
							</ul></li>
						<li class="active"><a href="${contextPath}/Registration"><@spring.message
								"nav-menu.registration"/></a></li>
						<li class="active">&nbsp;</li>
						<li class="active">&nbsp;</li>
						<form class="navbar-search pull-left" action="">
							<input id="global-search-input" class="span3"
								style="margin: 0 auto;" type="text"
								placeholder="<@spring.message "nav-menu.searchfieldlabel"/>">
						</form>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>