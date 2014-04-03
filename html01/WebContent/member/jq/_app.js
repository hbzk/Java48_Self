$(document).ready(function() {
	loadMemberList();
	clearForm();
	
	// #memberTable의 자손중 'btnMemberDelete'를 찾아서, 클릭시 동작 설정
	$('#memberTable').on('click', 'btnMemberDelete', function() {
		// this의 'data-no' 속성을 파라미터값으로 deleteMember(); 함수 호출   
		deleteMember($(this).attr('data-no'));
	});
	
	$('#btnCancel').click(function() {
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
	
	$('#btnUpdate').click(function() {
		try {
			validateForm();
			updateMember();
		} catch (err) {
			alert(err);
		}
	});
	
	$('#btnDelete').click(function() {
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

function loadMemberList() {
	// jQuery.ajax( url [, settings ] )	//		jQuery.ajax( [settings ] )  ==> 두가지 형태 모두 쓰일 수 있다
	$.ajax('http://localhost:8080/web02/member/ajax/list.do', {
		type: 'GET',
		dataType: 'json',
		// 요청 성공시 (결과값을 result라는 이름으로 파라미터 값으로 전달하면서) 동작할 함수 지정
		success: function(result) {
			// 전달받은 결과값 중 데이터 부분만 members라는 변수에 저장
			var members = result.jsonResult.data;  
			var memberTable = $('#memberTable');
			clearMemberList();
			// $.each => 객체의 각 항목별로 반복 // 파라미터로 (index, value)가 전달 된다 
			$.each(members, function(index, member) {
				$('<tr></tr>')	// tr 태그 생성
				.addClass('dataRow')		// dataRow class명 부여
				.append($('<td></td>').html(member.no)) // 마지막자손으로 td 태그 추가		// td에 콘텐츠로 no 값을 넣어서
				.append($('<td></td>')	// 마지막자손으로 td 태그 추가		(계속 추가되는 형태이므로 html이 아닌 append 사용)
						.append($('<a></a>')		// a태그를 생성해서 // 마지막자손으로 추가
							.attr('href', '#')				// href 속성에 # 값 할당		(href="#")
							.attr('data-no', member.no)		//	data-no 속성에 no값 할당		(readMember 함수에 파라미터 전달 용도)  
							.html(member.name)	// 태그 내부 콘텐츠에 name 삽입
							.click(function(event){	// 클릭시 동작 설정
								readMember($(this).attr('data-no'));	// readMember 함수 호출		// 위에서 할당했던 no값을 파라미터 값으로 활용  
								event.preventDefault();	// 기본 동작을 방지 (href="#")
							})))
				.append($('<td></td>').html(member.email))
				.append($('<td></td>').html(member.tel))
				.append($('<td></td>')
						.append($('<a>삭제</a>')
							.addClass('btnMemberDelete')
							.attr('href', '#')
							.attr('data-no', member.no)))
				.appendTo(memberTable); 
			});
		},
		error: function(msg) {
			alert('회원 정보를 읽을 수 없습니다!');
			console.log(msg);
		}
	});
}

function clearMemberList() {
	// 	.remove() => JQuery API (DOM트리에서 해당되는 엘리먼트를 지움)
	$('.dataRow').remove(); 
}

function addMember() {
	// jQuery.post( url [, data ] [, success(data, textStatus, jqXHR) ] [, dataType ] )
	$.post('http://localhost:8080/web02/member/ajax/add.do', {	// 첫번째 값은 url
			name: $('#name').val(),	// 두번째 값은 [data] 
			email: $('#email').val(),	// id가 email인 엘리먼트의 val값을 꺼낸다  
			password: $('#pass1').val(),	//		사용법 => val() 비어있으면 값을 꺼내기 //  값이 있으면 값을 설정하기
			tel: $('#tel').val(),
			age: $('#age').val()
		}, function(){					// jQuery.post에서 세번째 값은 성공시 행동으로 지정되어있어서 success가 생략 됨
			loadMemberList();		// app 지정 함수
			clearForm();				// app 지정 함수
		});
}

function clearForm() {
	$('#btnCancel').trigger('click');	// .trigger() => jQuery API (지정된 이벤트 유형에 대한 일치하는 요소에 연결된 모든 처리기와 동작을 실행.)
}

function deleteMember(no) {
	// jQuery.get( url [, data ] [, success(data, textStatus, jqXHR) ] [, dataType ] )
	$.get('http://localhost:8080/web02/member/ajax/delete.do?no=' + no,	// url 
		function(){						// success
			loadMemberList();
			clearForm();
		});
}

function readMember(no) {
	// jQuery.getJSON( url [, data ] [, success( data, textStatus, jqXHR ) ] )
	$.getJSON('http://localhost:8080/web02/member/ajax/read.do?no=' + no, // url 
		function(result){			// success시, 수신된 데이터를 result라는 파라미터명으로 설정, 후 함수 동작
			var member = result.jsonResult.data;	// result(수신된 데이터)에는 resultStatus 등의 상태값도 있으므로 필요한 data만 다시 member 변수에 담는다
			$('#no').val(member.no);							// .val(member.no) => .val() 안에 값이 있을땐 값을 꺼내기
			$('#name').val(member.name);				// $('#name') => id가 name인 엘리먼트를 찾는다 >> 수신된 데이터 중 member.name 값을 넣는다 
			$('#email').val(member.email);
			$('#tel').val(member.tel);
			$('#age').val(member.age);
			
			$('.editMode').css('display', '');				// html에서 미리 설정해둔 editMode Class를 활용해서 엘리먼트들을 선택 >> css 속성 중 display: 를 ''(기본값)으로 설정 
			$('.newMode').css('display', 'none');
	});
}

function updateMember() {
	$.ajax({
		// jQuery.ajax( url [, settings ] )	//		jQuery.ajax( [settings ] )  ==> 두가지 형태 모두 쓰일 수 있다.
		// [settings]에 들어가는 값은 많다 =======> 	 궁금하면 http://api.jquery.com/jQuery.ajax/ 참조
		// 주로 쓰이는건  url: (요청 주소), data: (전송할 값) , success: (성공시 할 일), dataType: (서버에 요청 받기 원하는 데이터 유형)
		url: 'http://localhost:8080/web02/member/ajax/update.do', 
		type: 'POST',		// type: ("POST" or "GET"), 기본값은 "GET".
		data: {
			no: $('#no').val(),
			name: $('#name').val(),
			email: $('#email').val(),
			tel: $('#tel').val(),
			age: $('#age').val()
		},
		success: function(result){		// 성공시 할 일
			// result안에 jsonResult안에 resultStatus 값을 통해 세부 데이터가 정상적으로 잘 받아왔는지 재 확인 ==> 0 이면 정상 수신
			if(result.jsonResult.resultStatus == 0) {		// 세부 데이터 정상 수신부
				loadMemberList();
				clearForm();
			} else {														// 세부 데이터가 정상적으로 수신되지 않았을때 (resultStatus !== 0 일때)
				alert('서버가 바쁩니다. \n계속 문제 발생 시 관리자(1234)에게 연락바랍니다.');		// 사용자에게는 보기 좋은 에러 출력
				console.log(result.jsonResult.error);		// 유지 보수를 위해 콘솔창에 세부 오류 사항 출력
			}
		},
		error: function(xhr, status, msg){	// 송신 자체가 실패 했을때 할 일
			alert('회원 변경 실패!');
			console.log('========>', msg); 
		}
	});
}


















































