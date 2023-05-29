function idCheck(){
	if( document.frm.ID.value==""){
		alert('아이디를 입력해 주세요.');
		document.frm.ID.focus();
		return;
	}
	var ID = document.frm.ID.value
	var opt = "toolbar=no,menubar=no,resizable=no,width=450,height=200";
	window.open("idcheck?ID=" + ID, "id check", opt);
} 


function idok(ID){
	opener.frm.ID.value = ID;
	opener.frm.REID.value = ID;
	self.close();
}

function open_win(url, name) {
	window.open(url, name, "toolbar=no, menubar=no, scrollbars=no, "
				+ " resizable=no, width=500, height=230");
}

/*function loginCheck(){
	if( document.frm.loginUser.ID.value==""){
		alert('로그인 해주세요.'); // 간단하게 alert으로 
		locaion.href="member/loginForm";
	}else{
		return;
	}
}*/





















