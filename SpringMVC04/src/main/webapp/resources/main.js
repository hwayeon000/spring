	
$(document).ready(function() {
	// HTML이 다 로딩되고 작동하는 함수
	loadList();
});

var memID =  $("#memID").val();

/* Ajax에서 csrf 토큰을 사용하기 위한 변수 설정*/
var csrfHeaderName = $("#name2").val();
var csrfTokenValue = $("#value2").val();


function loadList() {
	// BoardController에서 게시글 전체 목록을 가져오는 기능
	// JavaScript에서 객체 표현법 {key:value} -> JSON(Java Script Object Notation)
	// 실행에 따라 이뤄지는 함수, makeView => callBack함수
	$.ajax({
		url:"board/all",
		type:"GET",
		dataType:"JSON",
		success:makeView,
		error:function(){ alert("Error"); }
	});
};

function makeView(data) {
	// data=[{},{},{}, .. ,{}] // JSON Array
	console.log(data);
	let listHtml = "<table class='table table-bordered'>";
	listHtml += "<tr>";
	listHtml += "<td>번호</td>";
	listHtml += "<td>제목</td>";
	listHtml += "<td>작성자</td>";
	listHtml += "<td>작성일</td>";
	listHtml += "<td>조회수</td>";
	listHtml += "</tr>";
	var testID =  $("#memID").val();
	
	// index = for 문의 i, obj는 data[0]<
	// 반복문을 통해 게시글을 만들어 주는 부분
	$.each(data, function(index, obj){
		console.log(testID);
		listHtml += "<tr>";
		listHtml += "<td>" + (index + 1) + "</td>";
		listHtml += "<td id='t"+obj.idx+"'><a href='javascript:goContent("+obj.idx+")'>" + obj.title + "</a></td>";
		listHtml += "<td>" + obj.writer + "</td>";
		listHtml += "<td>" + obj.indate + "</td>";
		listHtml += "<td>" + obj.count + "</td>";
		listHtml += "</tr>";
		
		// 상세 게시글 보여주기
		listHtml += "<tr id='c"+obj.idx+"' style='display:none;'>";
		listHtml += "<td>내용</td>";
		listHtml += "<td colspan='4'><textarea id='ta"+obj.idx+"' rows='7' cols='' class='form-control' readonly>";
		/*listHtml += obj.content;*/
		listHtml += "</textarea>";
		
		/* 수정 삭제 버튼 추가 */
		if(testID == obj.memID){
			listHtml += "<br>"
			listHtml += "<span id='ub"+obj.idx+"'>"
			listHtml += "<button class='btn btn-sm btn-success' onclick='goUpdateForm("+obj.idx+")'>수정</button></span> &nbsp;";
			listHtml += "<button class='btn btn-sm btn-warning' onclick='goDelete("+obj.idx+")'>삭제</button>";
			listHtml += "</br>"
		} else {
			listHtml += "<br>"
			listHtml += "<span id='ub"+obj.idx+"'>"
			listHtml += "<button disabled class='btn btn-sm btn-success' onclick='goUpdateForm("+obj.idx+")'>수정</button></span> &nbsp;";
			listHtml += "<button disabled class='btn btn-sm btn-warning' onclick='goDelete("+obj.idx+")'>삭제</button>";
			listHtml += "</br>"
		}
		
		listHtml += "</td>";
		listHtml += "</tr>";
		
	});
	// 글쓰기 버튼 추가
	if(memID != ''){
		listHtml += "<tr align='right'><td colspan='5'>";
		listHtml += "<button class='btn btn-sm btn-primary' onclick='goForm()'>글쓰기</button>";
		listHtml += "</td></tr>";
	}
	listHtml += "</table>";
		
	$("#view").html(listHtml);
	goList();
}
	
	
// 글쓰기 버튼 눌렀을 때 글 작성 부분 보여주는 함수
function goForm() {
	$("#view").css("display", "none");
	$("#wform").css("display", "block");
}

// 게시글로 돌아가기
function goList() {
	$("#wform").css("display", "none");
	$("#view").css("display", "block");
}	

//게시글 등록 기능
function goInsert() {
	// 제목, 작성자, 내용 DB에 입력
	var fData = $("#frm").serialize();
	console.log(fData);
	
	$.ajax({
		url:"board/new",
		type:"POST",
		data:fData,
		beforeSend:function(xhr){
			xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
		},
		success:loadList,
		error:function(){ alert("Error"); }
	});
	
	$("#fclear").trigger("click");
	
}

// 게시글 상세 보기
function goContent(idx) {
	if($("#c"+idx).css("display") == "none"){
		$.ajax({
			url:"board/"+idx,
			type:"GET",
			dataType:"JSON",
			success:function(data){
				$("#ta"+idx).val(data.content);
			},
			error:function(){ alert("Error"); }
		});
		
		$("#c"+idx).css("display","table-row");
		$("#ta"+idx).attr("readonly",true);
	}else{
		$("#c"+idx).css("display","none");
		
		// 조회수
		$.ajax({
			url:"board/count/"+idx,
			type:"PUT",
			success:loadList,
			error:function(){ alert("Error"); }
		});
	}
	
}

// 게시글 삭제
function goDelete(idx) {
	$.ajax({
		url:"board/"+idx,
		type:"DELETE",
		success:loadList,
		error:function() { alert("Error"); }
	});
}

// 게시글 수정 화면 만들어 주는 부분
function goUpdateForm(idx) {
	$("#ta"+idx).attr("readonly",false);
	
	// 제목을 input 태그로 변경하기
	var title = $("#t"+idx).text();
	var newInput = "<input id='nt"+idx+"' value='"+title+"' type='text' class='form-control'>";
	$("#t"+idx).html(newInput);
	
	// 수정하기 기능 있는 버튼으로 변경
	var newButton="<button class='btn btn-sm btn-primary' onclick='goUpdate("+idx+")'>수정하기</button>"
	$("#ub"+idx).html(newButton);	
	
}	

// 게시글 찐찐 수정
function goUpdate(idx) {
	let title = $("#nt"+idx).val();
	let content = $("#ta"+idx).val();
	let board = {"idx":idx,"title":title,"content":content};
	
	// put 방식은 Json 이라 명시해줘야 함
	$.ajax({
		url:"board/update",
		type:"PUT",
		contentType:"application/json;charset=UTF-8",
		data:JSON.stringify(board),
		beforeSend:function(xhr){
			xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
		},
		success:loadList,
		error:function() { alert("Error"); }
	});
}



