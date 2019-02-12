  function signup(){
	  
	  var id=$("#id").val();
	  var password=$("#password").val();
	  var repassword=$("#repassword").val();
	  var name=$("#name").val();
	  var birth=$("#birth").val();
	  var postcode=$("#postcode").val();
	  var address=$("#address").val();
	  var address2=$("#address2").val();
	  var tel=$("#tel").val();
	  var email=$("#email").val();
	  var gender=$("input[name=gender]:checked").val();
	  var genre=$("#genre option:selected").val();
	  
	  if(id.length < 4) {
		  alert("아이디 최소 4자리를 입력하세요.");
		  $("#id").focus();
		  return false;
	  }
	  if(password.length == 0) {
		  alert("비밀번호를 입력하세요.");
		  $("#password").focus();
		  return false;
	  }
	  if(repassword.length == 0) {
		  alert("비밀번호확인을 입력하세요.");
		  $("#repassword").focus();
		  return false;
	  }
	  if(password != repassword ) {
		  alert("비밀번호가 맞지않습니다.");
		  $("#repassword").val("");
		  $("#repassword").focus();
		  return false;
	  }
	  if(name.length == 0) {
		  alert("이름을 입력하세요.");
		  $("#name").focus();
		  return false;
	  }
	  if(birth.length == 0) {
		  alert("생일을 입력하세요.");
		  $("#birth").focus();
		  return false;
	  }
	  if(postcode.length == 0) {
		  alert("주소를 입력하세요.");
		  $("#postcode").focus();
		  return false;
	  }
	  if(address2.length == 0) {
		  alert("상세주소를 입력하세요.");
		  $("#address2").focus();
		  return false;
	  }
	  if(tel.length == 0) {
		  alert("전화번호를 입력하세요.");
		  $("#tel").focus();
		  return false;
	  }
	  if(email.length == 0) {
		  alert("이메일을 입력하세요.");
		  $("#email").focus();
		  return false;
	  }
	  
	  
	  var query={id:id, password:password, name:name, birth:birth, postcode:postcode, address:address, address2:address2, tel:tel, email:email, gender:gender, genre:genre};
	  
		 $.ajax({
			type: "POST",
			url:  "join",
			data: query,
			
			success: function(data){
				var mid = data.trim();
				if(mid=='OK'){
					alert("회원가입에 성공하였습니다.");
				var ctx=window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
				window.location.href=ctx + "/Main";
				}
				else{
					var explain="회원가입에 실패하였습니다.";
					//데이터베이스 문제나 여러 문제 때문에 안 될 수 있으므로 예외적인 상황에 실패를 알리도록함
					alert(explain);
				}
			}
			 
		 });
}
 function login() {
	 var id=$("#lid").val();
	 var password=$("#lpassword").val();
	 
	 if(id.length == 0) {
		 alert("아이디름 입력하세요.");
		 $("#lid").focus();
		 return false;
	 }
	 if(password == 0) {
		 alert("비밀번호를 입력하세요.");
		 $("lpassword").focus();
		 return false;
	 }
	 
	 var query={id:id, password:password};
	 $.ajax ({
		 type: "POST",
		 url: "login",
		 data: query,
		 success: function(data) {
			 
			 var log = data.trim();
			 	if(log == 'check') {
			 		alert("로그인을 성공하였습니다.");
			 		var ctx=window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
			 		window.location.href=ctx + "/Main";
			 	} else if(log == 'c') {
			 		var explain="비밀번호가 틀립니다.";
			 		alert(explain);
			 	}
		 }
	 });
	 
 }
 $(document).ready(function (){
			 $(".idcheck").click(function() {
				 
				 // id를 param
				 var id = {id : $("#id").val()};
				 
				 $.ajax({
					 type: "post",
					 url: "idcheck",
					 data: id,
					 success: function(data) {
						 if(data == "NO") {
							 alert("이미 사용중인 아이디입니다.");
							 $("#id").focus();
							 $("#id").val("");
							 $("#join-btn").attr("disabled", "disabled")
						 }else if (data == "OK" ){
							 alert("사용가능한 아이디입니다.");
							 $("#id").focus();
							 $("#join-btn").removeAttr("disabled");
						 }
					 }
				 });
			 });
 });
