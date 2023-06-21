<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
<script type="text/javascript">

$(document).ready(function(){
	if(${not empty msgType}){
		if(${msgType eq "실패 메세지"}){
			$("#messageType").attr("class", "modal-content panel-warning");
		}
		$("#myMessage").modal("show");
	}
});
</script>
<body style="background-color: #324061;">
 
	<div class="container">
	<jsp:include page="../common/header.jsp"></jsp:include>
	  	<h2 style="color: #dfe6f7;">Spring MVC 03</h2>
	  	<div class="panel panel-default">
	    	<div class="panel-heading">회원가입</div>
	    	<div class="panel-body">
	    		<form action="${contextPath}/join.do" method="post">
	    			<input type="hidden" id="memPassword" name="memPassword" value="">
		    		<table class="table table-bordered" style="text-align: center; border: 1px solid #dddddd;">
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">아이디</td>
		    				<td><input type="text" name="memID" id="memID" class="form-control" placeholder="아이디를 입력하세요" maxlength="20"></td>
		    				<td style="width: 110px;"> <button onclick="registerCheck()" type="button" class="btn btn-sm btn-primary">중복확인</button> </td>
		    			</tr>
		    			
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">비밀번호</td>
		    				<td colspan="2"><input onkeyup="passwordCheck()" type="password" name="memPassword1" id="memPassword1" class="form-control" placeholder="비밀번호를 입력하세요" maxlength="20"></td>
		    			</tr>
		    			
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">비밀번호 확인</td>
		    				<td colspan="2"><input onkeyup="passwordCheck()" type="password" name="memPassword2" id="memPassword2" class="form-control" placeholder="비밀번호를 입력하세요" maxlength="20"></td>
		    			</tr>
		    			
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">사용자 이름</td>
		    				<td colspan="2"><input type="text" name="memName" id="memName" class="form-control" placeholder="이름을 입력하세요" maxlength="20"></td>
		    			</tr>
		    			
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">나이</td>
		    				<td colspan="2"><input type="number" name="memAge" id="memAge" class="form-control" placeholder="나이를 입력하세요" maxlength="20"></td>
		    			</tr>
		    			
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">성별</td>
		    				<td colspan="2">
		    					<div class="form-group" style="text-align:center;margin: 0 auto;">
		    						<div class="btn-group" data-toggle="buttons">
		    							<label class="btn btn-info active">
		    								<input type="radio" id="memGender" name="memGender" autocomplete="off" value="남자" checked="checked">남자
		    							</label>
		    							<label class="btn btn-info">
		    								<input type="radio" id="memGender" name="memGender" autocomplete="off" value="여자">여자
		    							</label>
		    						</div>
		    					</div>
		    				</td>
		    			</tr>
		    					    			
		    			<tr>
		    				<td style="width: 110px; vertical-align: middle;">이메일</td>
		    				<td colspan="2"><input type="email"" name="memEmail" id="memEmail" class="form-control" placeholder="이메일 입력하세요" maxlength="50"></td>
		    			</tr>
		    			
		    			<tr>
		    				<td colspan="3" style="text-align:right;">
		    					<!-- 비번 일치 여부 -->
		    					<span id="passMessage" style="color: red;"></span>
		    					<input type="submit" class="btn btn-primary btn-sm" value="등록">
		    					&nbsp;&nbsp;
		    					<input type="reset" class="btn btn-warning btn-sm" value="초기화">
		    					&nbsp;&nbsp;
		    				</td>
		    			</tr>
		    			
		    		</table>
	    		</form>
	    	</div>
	    	<div class="panel-footer">스프링게시판-ㅂㅎㅇ</div>
	  	</div>
	</div>


	<!-- 다이얼로그창(모달) -->
	  <!-- id check Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div id="checkType" class="modal-content panel-info">
	        <div class="modal-header panel-heading">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">메세지 확인</h4>
	        </div>
	        <div class="modal-body">
	          <p id="checkMessage">확인</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>

	<!-- 다이얼로그창(모달) :회원가입 실패시 나올 창 -->
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


<script type="text/javascript" src="resources/member.js"></script>
</body>
</html>
