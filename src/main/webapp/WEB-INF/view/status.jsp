<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PS320 - WEB 基础架构 -冰迪网络(出品)</title>
<link href="${base}/css/bootstrap.css" rel="stylesheet">
<link href="${base}/css/bootstrap-responsive.css" rel="stylesheet">
<body>

<c:import  url="nav.jsp" />

          <div class="container">
          <h5>
            <c:if test="${status == true}">
			<p class="text-center text-success"><i class="icon-signal"></i>.通信正常.</p>
			</c:if>
			<c:if test="${status == false}">
			<p class="text-center text-error"><i class="icon-remove"></i>.通信关闭.</p>
			</c:if>
          </h5>
          </div>

	<!-- javascript -->
	<script src="${base}/js/jquery.js"></script>
	<script src="${base}/js/bootstrap.js"></script>
</body>
</html>