<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign contextPath=springMacroRequestContext.getContextPath()>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta
        name="Description"
        content="Apprendre le JAVA facilement et rapidement. Cognicap vous permets de booster votre carri&egrave;re. Essayez-nous!" />
    <meta
        name="keywords"
        content="Rabat, Maroc, Casablanca, Fromation Java, Spring, Hibernate, Linux, Struts, PIC, Sonar, Hudson, Certification, SCJP, SJWCD, web site management, wcms, open source, java, java cms" />
    <meta name="viewport" content="width=device-width">
    <meta name="creator" content="Cognicap" />
    <meta name="format" content="text/html" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="expires" content="0" />
	<meta name="google-site-verification" content="aYbWg3grOwIlNwiznAS3waq2tCkuA4JuGZ39T9ShVYU" />
	
	<link rel="stylesheet" href="${contextPath}/static/css/styles.css" />
	
	<script type="text/javascript" src="${contextPath}/static/3rdparty/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${contextPath}/static/3rdparty/jquery-ui-1.8.5.custom.min.js"></script>
	
	<!-- scripts concatenated and minified via build script -->
	<script type="text/javascript" src="${contextPath}/static/js/codemy.js"></script>
	<script>
	    var _gaq=[['_setAccount','UA-22247116-1'],['_trackPageview']];
	    (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
	    g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
	    s.parentNode.insertBefore(g,s)}(document,'script'));
	</script>
	<!-- end scripts -->	
    <title>Formation pour booster votre carriere - Cognicap</title>
</head>
<body>
    <!--[if lt IE 7]><p class="chromeframe">Your browser is Upgrade to a different browser <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->
    <div id="siteContainer">
        <div id="headerWrap">
            <div class="tagline">
            <a href="http://www.cognicap.com/" style="text-decoration: none;">
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Booste ta carri&egrave;re avec une formation <span class="contact">JAVA</span> chez des professionnels!&nbsp;&nbsp;</h2>
            </a>
            </div>
            <div id="navWrap">
                <ul>
                    <li class="parent">
                    	<a
                            href="Trainings"
                            title="Booste ta carrcarri&egrave;re avec Cognicap"
                            id="navFeatures"
                            class=""
                            name="navFeatures">Formations</a>
                        <ul>
                            <li class="sub"><a
                                    href="java-debutant.ftl"
                                    title="Formation pour d&eacute;butant">Java niveau
                                    Confirm&eacute;</a></li>
                            <li class="sub"><a
                                    href="java-intermediaire.ftl"
                                    title="Formation avanc&eacute;e">Java niveau
                                    S&eacute;nior</a></li>
                            <li class="sub"><a
                                    href="java-scjp5.ftl"
                                    title="Pr&eacute;paration &agrave; la certification">Certification
                                    JAVA 5</a></li>
                            <li class="sub"><a
                                    href="formations.ftl"
                                    title="Toutes les Formations!"
                                    class="">Liste compl&egrave;te formations</a></li>
                        </ul>
                    </li>
                    <li class="parent"><a
                            href="About"
                            title="&Agrave;propos Cognicap"
                            id="navAbout"
                            class=""
                            name="navAbout">Cognicap</a>
                        <ul>
                            <li class="sub"><a
                                    href="About#values"
                                    title="Les valeurs Cognicap">Nos valeurs</a></li>
                            <li class="sub"><a
                                    href="About#mission"
                                    title="La mission Cognicap">Mission</a></li>
                            <li class="sub"><a
                                    href="contact.ftl"
                                    title="Contactez-nous"
                                    class="">Contactez-nous</a></li>
                            <li class="sub"><a
                                    href="ourstudio.ftl"
                                    title="Bureaux"
                                    class="">Comment venir?</a></li>
                        </ul>
                    </li>
                    <li><a
                            href="Registration"
                            title="Reserve Ton cours"
                            id="navLogin"
                            class="green"
                            name="navLogin">Inscription</a>

                    </li>
                    <li>
						<@security.authorize ifNotGranted="ROLE_USER">
							<a href="${contextPath}/login/"><@spring.message "layout.login"/></a>
						</@security.authorize>
						<@security.authorize ifAllGranted="ROLE_USER">
							${userContext.username} (<a href="${contextPath}/logout"><@spring.message "layout.logout"/>)</a>
						</@security.authorize>
                    </li>
                </ul>
            </div>
            <!-- FIN MENU -->