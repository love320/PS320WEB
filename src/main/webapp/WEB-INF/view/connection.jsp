<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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


          <div class="bs-docs-example">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th><i class="icon-retweet"></i> 状态</th>
                  <th>目标主机:端口 <span class="badge badge-info">${fn:length(list)}</span></th>
                  <th>启动时间</th>
                  <th>Key</th>
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${list}" var="xx">
                <tr>
                  <td>
                  <c:if test="${xx.status == false}"><span class="label label-success">正常</span></c:if>
                  <c:if test="${xx.status == true}"><span class="label ">关闭</span></c:if>
                  </td>
                  <td>${xx.ip}:${xx.port}</td>
                  <td><fmt:formatDate value="${xx.time}" type="both"/> </td>
                  <td>${xx.key}</td>
                </tr>
				</c:forEach>
              </tbody>
            </table>
          </div>
          
	<!-- javascript -->
	<script src="${base}/js/jquery.js"></script>
	<script src="${base}/js/bootstrap.js"></script>
</body>
</html>