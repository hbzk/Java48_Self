$(document).ready(function(){
	// 화면 로딩이 완료되면, 로그인 버튼의 리스너를 등록한다. 
	$('#btnLogin').on('click', function(event){
		event.preventDefault();
		if ($('#email').val().length == 0 || $('#password').val().length == 0) {
			alert('이메일과 암호는 필수 입니다.');
			return;
		}
		
	
		$.ajax('login.ajax', {
			type: 'POST',
			dataType: 'json', 	// 서버에서 보내는 데이터의 형식 지정
			data: { 			// 서버쪽으로 보내는 데이터
				email: $('#email').val(),
				password: $('#password').val(),
				saveEmail: ($('#saveEmail:checked').length > 0) ? 'true':'false'
			},
			success: function(data){
				console.log(data);
				if (data.status == "ok" && data.result == "success") {
					location.href="../subject/list.bit";
				} else {
					alert('이메일 또는 암호가 맞지 않습니다.');
				}
			}, 
			error:function(xhr, status, errorThrown){
				alert('로그인 실행 중 오류 발생!');
				console.log(status);
				console.log(errorThrown);
			}
		})
		
		// 비동기 요청 후 성공 여부에 관계없이 진행 되는 위치
	});
});