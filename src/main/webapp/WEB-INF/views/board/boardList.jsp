<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>boardList.jsp</title>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>게 시 판 리 스 트......</h2>
  <hr/>
  <div><img src="${ctp}/resources/images/13.jpg" width="350px" /></div>
  <hr/>
  <div>게시판 연습 중입니다.1</div>
  <div>게시판 연습 중입니다.3</div>
  <div>게시판 연습 중입니다.5</div>
  <div>게시판 연습 중입니다.7</div>
  <div>게시판 연습 중입니다.2</div>
  <div>게시판 연습 중입니다.4</div>
  <div>게시판 연습 중입니다.6</div>
  <div>게시판 연습 중입니다.8</div>
</div>
<p><br/></p>
</body>
</html>