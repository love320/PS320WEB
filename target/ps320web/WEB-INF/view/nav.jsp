<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>

<div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="http://www.love320.com" title="冰迪网络-出品">PS320 - WEB </a>
    <ul class="nav">
      <li <c:if test="${pagetype == 'status'}">class="active"</c:if> ><a href="${base}/status.do">系统状态</a></li>
      <li <c:if test="${pagetype == 'server'}">class="active"</c:if> ><a href="${base}/server.do">服务管理</a></li>
      <li <c:if test="${pagetype == 'connection'}">class="active"</c:if> ><a href="${base}/connection.do">连接管理</a></li>
    </ul>
  </div>
</div>
