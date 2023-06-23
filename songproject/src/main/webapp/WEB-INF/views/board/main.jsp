<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	// Ajax에서 csrf 토큰을 사용하기 위한 변수 설정
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}"
	
	
	
	$(document).ready(function() {
		// HTML이 다 로딩되고 작동하는 함수 구조가 다 완성된 다음에 데이터를 뿌려야한다
		loadList();
	});

	function loadList() {
		// BoardController에서 게시글 전체 목록을 가져오는 기능
		// JavaScript에서 객체 표현법 {key:value}
		$.ajax({
			url : "board/all",
			type : "get",
			dataType : "json",
			success : makeView, /* callback 함수 요청되고나서 실행하는 함수*/
			error : function() {
				alert("error");
			}
		});
	}
						    	//             0         1        2
	function makeView(data) { // data = [{       }, {      },{    }]
		console.log(data);
		var listHtml = "<table class='table table-bordered'>";
		listHtml += "<tr>";
		listHtml += "<td>번호</td>";
		listHtml += "<td>제목</td>";
		listHtml += "<td>작성자</td>";
		listHtml += "<td>작성일</td>";
		listHtml += "<td>조회수</td>";
		listHtml += "</tr>";

		// 게시글을 반복문을 통해 만들어주는 부분
		$.each(data, function(index, obj) {
			listHtml += "<tr>";
			listHtml += "<td>" + (index + 1) + "</td>";
			listHtml += "<td id='t"+obj.idx+"'><a href='javascript:goContent("+obj.idx+")'>" + obj.title + "</a></td>";
			listHtml += "<td>" + obj.writer + "</td>";
			listHtml += "<td>" + obj.indate + "</td>";
			listHtml += "<td>" + obj.count + "</td>";
			listHtml += "</tr>";
			
			// 상세 게시글 보여주기
			listHtml +="<tr id='c"+obj.idx+"' style='display:none;'>"
			listHtml +="<td>내용</td>";
			listHtml +="<td colspan='4'>";
			listHtml +="<textarea id='ta"+obj.idx+"' readonly row='7' class='form-control'>";
			listHtml +="</textarea>";
			
			// 수정 삭제 버튼 추가
			if("${mvo.memID}" == obj.memID){
			listHtml += "<br>";
			listHtml += "<span id='ub"+obj.idx+"'>"
			listHtml += "<button class='btn btn-sm btn-success' onclick='goUpdateForm("+obj.idx+")'>수정</button></span>&nbsp;";
			listHtml += "<button class='btn btn-sm btn-warning' onclick='goDelete("+obj.idx+")'>삭제</button>";
			}else{
			listHtml += "<button disabled class='btn btn-sm btn-success' onclick='goUpdateForm("+obj.idx+")'>수정</button></span>&nbsp;";
			listHtml += "<button disabled class='btn btn-sm btn-warning' onclick='goDelete("+obj.idx+")'>삭제</button>";
			}
			listHtml +="</td>";
			listHtml +="</tr>";
			
			
		});
		// 글쓰기 버튼 추가
		if(${not empty mvo}){
		listHtml +="<tr>";
		listHtml +="<td colspan='5'>";
		listHtml +="<button class='btn btn-primary btn-sm' onclick='goForm()'>"
		listHtml +="글쓰기"
		listHtml +="</button>"
		listHtml +="</td>"
		listHtml +="</tr>"
		}
		
		listHtml += "</table>";

		$("#view").html(listHtml);
		goList();
	}
	
	// 글쓰기 버튼 눌렀을때 글 작성 부분 보여주는 함수
	function goForm(){
		$("#view").css("display","none");
		$("#wform").css("display","block");
	}

	// 리스트 다시 보여주기
	function goList(){
		$("#view").css("display","block");
		$("#wform").css("display","none");
	}

	// 게시글 입력 기능
	function goInsert(){
		// 제목, 내용, 작성자를 DB에 입력
		var fData = $("#frm").serialize(); /* frm을 한꺼번에 불러와서 나열해줌 */
		console.log(fData);
		
		$.ajax({
			url : "board/new",
			type : "post",
			data : fData,
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			},
			success : loadList, /* success 다음에는 괄호 딱히 안해도 됨 */
			error : function(){alert("error");}
		});
		
/* 		$("#title").val(""); // 입력후에 전부 지워주는 기능
		$("#content").val("");
		$("#writer").val(""); */
		
		$("#fclear").trigger("click"); //취소 버튼을 누르게 만들어서 글 전부 삭제
	}
	
	// 게시글 상세보기 기능
	function goContent(idx){
		if($("#c"+idx).css("display")=="none"){
			
			$.ajax({
				url : "board/"+idx, // pathvariable
				type : "get",
				data : {"idx": idx},
				dataType : "json", // 받아올 데이터가 있다면 dataType을 명시해줘야함
				success : function(data){ //받아온 정보를 data로 받아온다
					$("#ta"+idx).val(data.content);
				},
				error: function(){alert("error");}
			});
			$("#c"+idx).css("display","table-row");// 안보이는 테이블 보이게 할 때 table-row로 바꿔야함
			$("#ta"+idx).attr("readonly",true);
		}else{
			$("#c"+idx).css("display","none");
			
			$.ajax({
				url : "board/count/"+idx, // 내가 했던 실수 : url과 idx값 사이에 /가 빠져있다.....
				type : "put",
				beforeSend : function(xhr){
					xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
				},
				/* data : {"idx":idx} pathvariable이기 때문에 필요 없다 */
				success : loadList,
				error : function(){alert("error");}
			});
		}
	}
	
	// 게시글 삭제 기능
	function goDelete(idx){
		// 문제.
		// boardDelete.do로 요청을 해서 idx가 일치하는 게시물을 삭제시키시오
		$.ajax({
			url : "board/"+idx,
			type : "delete", // get방식으로 보내면 상세보기 기능과 겹쳐서 상세보기 기능이 작동한다 그래서 delete방식으로 보낸다
			/* data : {"idx":idx}, // 항상 Json형식으로 보내줘야한다. */
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			},
			success : loadList,
			error : function(){alert("error");}
		});
	}
	
	// 게시글 수정화면 만들어주는 부분
	function goUpdateForm(idx){
		$("#ta"+idx).attr("readonly",false); //속성을 변경해주는 함수
		// 제목을 input태그로 변경하기
		var title = $("#t"+idx).text();
		var newInput = "<input id='nt"+idx+"'value='"+title+"'type='text' class='form-control'>";
		$("#t"+idx).html(newInput);
		
		// 수정하기 기능이 있는 버튼으로 변경
		var newButton = "<button onclick='goUpdate("+idx+")' class='btn btn-sm btn-primary'>수정하기</button>";
		$("#ub"+idx).html(newButton);
		
	}
	
	// 게시글 수정 기능
	function goUpdate(idx){
		// 제목에 입력한 글자와, 내용에 입력한 글자를 가져와서 수정
		// boardUpdate.do로 요청해서 게시글을 수정하시오
		var title = $("#nt"+idx).val();
		var content = $("#ta"+idx).val();
		// 내가 했던 실수 받아올 title, content를 변수 지정을 따로 안함
		
		$.ajax({
			url : "board/update",
			type : "put",
			contentType : "application/json;charset=utf-8", // put방식으로 보낼때는 데이터타입의 컨텐츠를 명시해주는 것
			data : JSON.stringify({"idx":idx, "title":title, "content":content}),
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			},
			success : loadList,
			error : function (){
				alert("error");
			}
		});
	}
	
	
</script>



</head>
<body>

	<div class="container">
			<jsp:include page="../common/header.jsp"></jsp:include>
			<!-- iframe은 그냥 보여주는 것이기 때문에 변수값같은걸 못가져옴 include는 융합시키는 것이니까 모든게 가능 -->
		<h2>Spring MVC03</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body" id="view"></div>

			<!-- 글쓰기 폼 -->
			<div class="panel-body" style="display: none;" id="wform">
				<form id="frm">
					<input type="hidden" name="memID" value="${mvo.memID}"
					<table class="table">
						<tr>
							<td>제목</td>
							<td><input id="title" type="text" name="title" class="form-control"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea id="content" name="content" rows="7" cols="" class="form-control"></textarea></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input readonly="readonly" value="${mvo.memName}" id="writer" type="text" name="writer" class="form-control"></td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<button class="btn btn-sm btn-success" type="button" onclick="goInsert()">등록</button>
								<button class="btn btn-sm btn-warning" type="reset" id="fclear">취소</button>
								<button class="btn btn-sm btn-info" type="button" onclick="goList()">목록</button>
							</td>
						</tr>
					</table>
				</form>


			</div>


			<div class="panel-footer">스프링게시판-김한송</div>
		</div>
	</div>

</body>
</html>
