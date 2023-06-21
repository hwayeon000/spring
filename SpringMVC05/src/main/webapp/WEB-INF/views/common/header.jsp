<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- scope (4가지 영역 ): page(명시하지 않으면 page기본) 영역, context  -->
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!--  navbar-default -> navbar 흰색으로, style="background-color: #223052; border: none;" -->
<nav class="navbar navbar-inverse" style="background-color: #223052; border: none;">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${contextPath}/"> 🌺Spring🌼🥀 </a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath}/">Home</a></li>
        <li><a href="boardMain.do">게시판</a></li>
        <li><a href="#">Page 2</a></li>
      </ul>
      
      <c:if test="${empty mvo}">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">접속하기<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${contextPath}/joinForm.do"><span class="glyphicon glyphicon-user"></span> &nbsp;회원가입 </a></li>
        	<li><a href="${contextPath}/loginForm.do"><span class="glyphicon glyphicon-log-in"></span> &nbsp;로그인 </a></li>
          </ul>
        </li>
      </ul>
	  </c:if>
	  
	  <c:if test="${not empty mvo}">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          
        	<c:if test="${mvo.memProfile eq ''}">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">	
	        	<img class="img-circle" src="${contextPath}/resources/images/root2.png" style="width: 35px; height: 35px;">
        	</c:if>
			<!-- 프사가 있다면 -->
        	<c:if test="${mvo.memProfile ne ''}">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	            <img class="img-circle" src="${contextPath}/resources/upload/${mvo.memProfile}" style="width: 35px; height: 35px;">
        	</c:if>
        	
	          (
	          <c:forEach var="auth" items="${mvo.authList}">
	          	<c:choose>
	          		<c:when test="${auth.auth eq 'ROLE_USER'}">
	          			U
	          		</c:when>
	          		<c:when test="${auth.auth eq 'ROLE_MANAGER'}">
	          			M
	          		</c:when>
	          		<c:when test="${auth.auth eq 'ROLE_ADMIN'}">
	          			A
	          		</c:when>
	          	</c:choose>
	          </c:forEach>
	          )
	          
	          ${mvo.memName}님 반갑습니다.<span class="caret"></span>
            </a>
          <ul class="dropdown-menu">
            <li><a href="${contextPath}/updateForm.do"><span class="glyphicon glyphicon-cog"></span> &nbsp;정보수정 </a></li>
            <li><a href="${contextPath}/imageForm.do"><span class="glyphicon glyphicon-picture"></span> &nbsp;프로필사진등록 </a></li>
        	<li><a href="${contextPath}/logout.do"><span class="glyphicon glyphicon-log-out"></span> &nbsp;로그아웃 </a></li>
        	
        	
          </ul>
        </li>
      </ul>
	  </c:if>
	
	
    </div>
  </div>
</nav>