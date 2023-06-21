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
 	<% pageContext.setAttribute("newLineChar", "\n"); %>
	<div class="container">
	  	<h2>Spring MVC01</h2>
	  	<div class="panel panel-default">
	    	<div class="panel-heading">Board</div>
	    	<div class="panel-body">
	    	<!-- pathValuable로 한번 더 들어왔기 떄문에 나가야 함 -->
	    		<form action="../boardUpdate.do" method="post">
		    		<table class="table">
    					<input name="idx" value="${vo.idx}" class="form-control" type="hidden">
		    			<tr>
		    				<td>제목</td>
		    				<td>
		    					<input name="title" value="${vo.title}" class="form-control" type="text">
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>내용</td>
		    				<td>
		    					<!-- textarea는 태그 사이 공간도 인식하므로 주의! -->
		    					<textarea name="content" class="form-control" row="7" cols="">${vo.content}</textarea>
		    					
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>작성자</td>
		    				<td>
		    					<input name="writer" value="${vo.writer}" class="form-control" type="text">
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td colspan="2" align="center">
		    					<button type="submit" class="btn btn-sm btn-warning">수정완료</button>
		    					<button type="reset" class="btn btn-sm btn-primary">초기화</button>
		    					<a href="/controller/boardList.do" class="btn btn-sm btn-info">목록</a>
		    				</td>
		    			</tr>
		    			
		    		</table>
	    		</form>
	    	</div>
	    	<div class="panel-footer">스프링게시판-ㅂㅎㅇ</div>
	  	</div>
	</div>
</body>
</html>
