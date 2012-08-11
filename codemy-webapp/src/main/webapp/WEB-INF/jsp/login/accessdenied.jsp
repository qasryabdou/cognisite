<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<title><fmt:message key="error.title" /></title>
</head>
<body>
	<div class="span-24">
		<h2><fmt:message key="error.title" /></h2>
		<p class="error"><fmt:message key="error.access.denied" /></p>
	</div>
</body>
