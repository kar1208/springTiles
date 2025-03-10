<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>nav.jsp</title>
</head>
<body>
<div class="p-2" style="background-color:green;">
  <a href="${ctp}/main/memberMain">홈으로</a> |
  <a href="${ctp}/tiles/guestList">방명록</a> |
  <a href="${ctp}/tiles/boardList">게시판</a> |
  <a href="${ctp}/tiles/pdsList">자료실</a> |
  <a href="${ctp}/tiles/myPage">MyPage</a> |
  <a href="${ctp}/tiles/memberLogout">로그아웃</a>
</div>
</body>
</html>