

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


















