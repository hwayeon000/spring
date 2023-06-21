<%@page import="kr.board.entity.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Template</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
	<div class="container">
	  	<h2>Spring MVC01</h2>
	  	<div class="panel panel-default">
	    	<div class="panel-heading">Board</div>
	    	<div class="panel-body">
				<table class="table table-bordered table-hover">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
					
					<%-- <% // model은 request의 영역 안에 있음!! 똑같이 request로 불러온다.
					List<Board> list = (List<Board>)request.getAttribute("list");
					%>
					
					<%for(Board vo:list){ %>
					<tr>
						<td><%=vo.getIdx() %></td>
						<td><%=vo.getTitle() %></td>
						<td><%=vo.getWriter() %></td>
						<td><%=vo.getIndate() %></td>
						<td><%=vo.getCount() %></td>
					</tr>
					<%} %> --%>
					
					<!-- 게시글 출력 -->
					<!-- EL문법 , 혹시 세션과 리퀘스트 둘다 list 있다면-->
					<%-- <c:forEach items="${sessionScope.list}"> --%>
					
					<c:forEach var="vo" items="${list}" varStatus="s">
						<tr>
							<td>${s.count }</td>
							<%-- <td>${s.index }</td> <<0부터 시작 --%>
							<td><a href="boardContent.do?idx=${vo.idx}">${vo.title }</a></td>
							<td>${vo.writer }</td>
							<td>${fn:split(vo.indate," ")[0]}</td>
							<td>${vo.count }</td>
						</tr>
					</c:forEach>
					
				</table>
				
				<a href="boardForm.do" class="btn btn-info btn-sm">글쓰기</a>
	    	</div>
	    	<div class="panel-footer">스프링게시판-ㅂㅎㅇ</div>
	  	</div>
	</div>

</body>
</html>
