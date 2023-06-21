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
	  	<h2>Spring MVC02</h2>
	  	<div class="panel panel-default">
	    	<div class="panel-heading">board</div>
	    	<div class="panel-body" id="view">
	    		
	    	</div>
	    	
	    	
	    	<!-- 글 쓰기 form -->
			<div class="panel-body" style="display: none;" id="wform">
			<!-- action은 페이지를 이동하여 처리하고 돌아옴(동기방식) -->
				<form id="frm">
					<table class="table">
					
						<tr>
							<td>제목</td>
							<td><input id="title" name="title" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input id="writer" name="writer" type="text" class="form-control"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea id="content" name="content" rows="7" cols="" class="form-control"></textarea> </td>
						</tr>
						<tr align="center"> 
							<td colspan="2">
								<button type="button" class="btn btn-sm btn-success" onclick="goInsert()">등록</button>
								<button type="reset" class="btn btn-sm btn-warning" id="fclear">초기화</button>
								<button type="button" class="btn btn-sm btn-info" onclick="goList()">돌아가기</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
	    	<div class="panel-footer">스프링게시판-ㅂㅎㅇ</div>
	  	</div>
	</div>

<script type="text/javascript" src="resources/main.js"></script>
</body>
</html>
