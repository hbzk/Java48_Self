$(function(){
	var contextPath = bit.getContextRootPath(); 
	$.getJSON(
		contextPath + '/auth/getLoginUser.ajax',
		function(jsonObj){
			var result = jsonObj.ajaxResult;
			if (result.status == "ok") {
				var user = result.data;
				$('#loginUsername').text(user.name);
				$('#loginEmail').text(user.email);
			} else {
				alert("로그인 하지 않았습니다.");
				location.href = contextPath + "/auth/login.html";
			}
		});
});

$('#btnLogout').click(function(){
	$.getJSON(
		bit.contextRoot + '/auth/logout.ajax',
		function(jsonObj){
			var result = jsonObj.ajaxResult;
			if (result.status == "ok") {
				location.href = contextPath + "/auth/login.html";
			} else {
				alert("로그아웃 중 오류 발생");
			}
		});
}); 