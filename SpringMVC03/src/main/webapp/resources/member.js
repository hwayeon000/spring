/**
 * 비동기  
 */

/*$(document).ready(function(){
	if(${not empty msgType}){
		if(${msgType eq "실패 메세지"}){
			$("#messageType").attr("class", "modal-content panel-warning");
		}
		$("#myMessage").modal("show");
	}
});*/


function registerCheck(){
	// 아이디 중복 체그
	console.log("아이디 중복 체크")
	var memID = $("#memID").val();
	// 문제. MemberController에서 registerChec.do 비동기 요청이 들어올 시
	// 해당 아이디가 존재하면 0을 돌려주고 없으면 1을 돌려준다
	
	// 체크하는 방법
	// 객체 있으면 반환 없으면 null
	
	// 힌트
	// MemberMapper.java, MemberMapper.xml, rootContext.xml에 추가
	
	
	$.ajax({
		url:"registerCheck.do",
		type:"GET",
		data:{"memID":memID},
		success:function(data){
			// 중복 유무 출력 (data==1:가능, data ==0:불가능/중복
			console.log(data);
			if(data==1){
				$("#checkMessage").text("사용할 수 있는 아이디 입니다.");
				$("#checkType").attr("class","modal-content panel-success");
			}else{
				$("#checkMessage").text("사용할 수 없는 아이디 입니다.");
				$("#checkType").attr("class","modal-content panel-warning");
			}
			
			$("#myModal").modal("show");
			
		},
		error:function(){ alert("Error"); }
	});
}


function passwordCheck(){
	// 비번일치 확인 기능
	var memPassword1 = $("#memPassword1").val();
	var memPassword2 = $("#memPassword2").val();
	
	
	if (memPassword1 != memPassword2){
		$("#passMessage").text("비밀번호가 일치하지 않습니다.")
	} else {
		$("#passMessage").text("")
		$("#memPassword").val(memPassword1);
	}
}


















