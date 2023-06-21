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
	  	<h2>보유 도서 현황</h2>
	  	<div class="panel panel-default">
	    	<div class="panel-heading">보유 도서 현황을 확인하세요</div>
	    	<div class="panel-body">
				<table class="table table-bordered table-hover">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작가</td>
						<td>출판사</td>
						<td>ISBN</td>
						<td>보유도서수</td>
					</tr>
					
					<c:forEach var="vo" items="${list}" varStatus="s">
						<tr>
							<td>${s.count }</td>
							<td>${vo.title }</td>
							<td>${vo.author }</td>
							<td>${vo.company }</td>
							<td>${vo.isbn }</td>
							<td>${vo.count }</td>
						</tr>
					</c:forEach>
					
				</table>
				
	    	</div>
	    	<div class="panel-footer">스프링게시판-ㅂㅎㅇ</div>
	  	</div>
	</div>
	
	
	<div class="container">
	  	<h2>도서입력</h2>
	  	<div class="panel panel-default">
	    	<div class="panel-heading">등록을 원하는 도서 입력</div>
	    	<div class="panel-body">
				<form action="bookInsert.do" method="post">
		    		<table class="table">
		    			
		    			<tr>
		    				<td>제목</td>
		    				<td>
		    					<input class="form-control" type="text" name="title">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>작가</td>
		    				<td>
		    					<input class="form-control" type="text" name="author">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>출판사</td>
		    				<td>
		    					<input class="form-control" type="text" name="company">
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>ISBN</td>
		    				<td>
		    					<input class="form-control" type="text" name="isbn">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>보유도서 수</td>
		    				<td>
		    					<input class="form-control" type="number" name="count">
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td colspan="2" align="right">
		    					<button type="submit" class="btn btn-sm btn-success">등록</button>&nbsp;&nbsp;
		    					<button type="reset" class="btn btn-sm btn-warning">초기화</button>
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
