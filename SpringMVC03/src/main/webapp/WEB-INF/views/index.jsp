<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		if(${not empty msgType}){
			if(${msgType eq "성공 메세지"}){
				$("#messageType").attr("class", "modal-content panel-success");
			}
			if(${msgType eq "로그아웃 메세지"}){
				$("#messageType").attr("class", "modal-content panel-primary");
			}
			$("#myMessage").modal("show");
		}
	});
	</script>
</head>
<body style="background-color: #324061;">

	<div class="container">
	<jsp:include page="common/header.jsp"></jsp:include>
	
	  <h3 style="color: #dfe6f7;">Spring MVC 03🌺</h3>
	  
  	  	<div class="panel panel-default">
	    	<div>
	    		<img alt="" src="${contextPath}/resources/images/main1.jpg" style="width: 100%; height: 540px;">
	    	</div>
	    	<div class="panel-body">
				    <!-- 탭 시작 -->		
				  <ul class="nav nav-tabs">
				    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
				    <li><a data-toggle="tab" href="#menu1">게시판</a></li>
				    <li><a data-toggle="tab" href="#menu2">공지사항</a></li>
				  </ul>
				
				  <div class="tab-content">
				  
				    <div id="home" class="tab-pane fade in active">
				      <h3>HOME</h3>
				      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				    </div>
				    
				    <!-- 게시판 탭 시작 -->
				    <div id="menu1" class="tab-pane fade">
				      <h3>게시판</h3>
				      	<div class="panel panel-default">
					    <div class="panel-heading">board</div>
					    <div class="panel-body" id="view"></div>
					    	
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
								      
				      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
				      
				    </div>
				    
				    <!-- 게시판 탭 끝 -->
				    
				    
				    <div id="menu2" class="tab-pane fade">
				      <h3>공지사항</h3>
				      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
				    </div>
		
				  </div>
	    			<!--  탭 끝 -->
	    	</div>
	    	<div class="panel-footer">스프링게시판-ㅂㅎㅇ</div>
	  	</div>
	  
	  <p style="color: #dfe6f7;">In this example, the navigation bar is hidden on small screens and replaced by a button in the top right corner (try to re-size this window).
	  <p style="color: #dfe6f7;">Only when the button is clicked, the navigation bar will be displayed.</p>
	</div>

	
	
	
	
	  <!-- 다이얼로그창(모달) :회원가입  성공시 나올 창 -->
	  <!-- join check Modal -->
	  <div class="modal fade" id="myMessage" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div id="messageType" class="modal-content panel-info">
	        <div class="modal-header panel-heading">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">${msgType }</h4>
	        </div>
	        <div class="modal-body">
	          <p id="">${msg }</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	
	
	<script type="text/javascript" src="resources/main.js"></script>
</body>
</html>
