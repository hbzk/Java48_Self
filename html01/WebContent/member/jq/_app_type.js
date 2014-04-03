$(document).ready(function() {
	loadMemberList();
	clearForm();
	
	$('#memberTable').on('click', 'btnMemberDelete', function() {
		deleteMember($(this).attr('data-no'));
	});
	
	$('btnCancel').click(function() {
		$('.editMode').css('display', 'none');
		$('.newMode').css('display', '');
	});
	
	$('#btnAdd').click(function() {
		try {
			validateForm();
			addMember();
		}	catch (err) {
			alert(err);
		}
	});
	
	$('btnUpdate').click(function() {
		try {
			validateForm();
			addMember();
		}	catch (err) {
			alert(err);
		}
	});
	
	$('btnDelete').click(function() {
		deleteMember($('#no').val());
	});
	
});

function validateForm() {
	var pass1 = $('#pass1').val();
	var pass2 = $('#pass2').val();
	if (pass1 != pass2) {
		throw '암호가 일치하지 않습니다!';
	}
	var name = $('#name').val();
	var email = $('#email').val();
	if (name == '' || email == '') {
		throw '이름과 이메일은 필수 입력 항목입니다!';
	}
}








