function loadMemberList() {
	$.ajax('http://localhost:8080/web02/member/ajax/list.do', {
		method: 'GET',
		success: function(members){
			var memberTable = $("#memberTable");
			clearMemberList();
			var tr = null, td = null, a = null;
			members.forEach(function(member){
				tr = document.createElement('tr');
				tr.setAttribute('class', 'dataRow');
				[member.no,
				 member.name,
				 member.email,
				 member.tel].forEach(function(value,index,arr){
					td = document.createElement('td');
					if (index == 1) {
						td.innerHTML = '<a href="#"' +
							' onclick="readMember(' + arr[0] +
							'); return false;">' +
							value + '</a>';
					} else {
						td.innerHTML = value;
					} 
					tr.appendChild(td);
				});
				td = document.createElement('td');
				a = document.createElement('a');
				a.href = '#';
				a.onclick = function(event) {
					deleteMember(member.no);
					event.preventDefault();
				};
				a.innerHTML = '삭제';
				td.appendChild(a);
				tr.appendChild(td);

				memberTable.append(tr);
			});
		},
		error: function(msg){
			alert('회원 정보를 읽을 수 없습니다!');
			console.log(msg);
		}
	});
}






/*$(document).ready(function(){


	
	$.ajax('list.ajax', {
		type: 'POST',
		dataType: 'json', 	// 서버에서 보내는 데이터의 형식 지정
		data: { 			// 서버쪽으로 보내는 데이터
			//pageNo: $('#email').val(),
			//pageSize: $('#password').val(),
		},
		success: function(Object){
			console.log(Object);
			var list = Object.ajaxResult.data;
			console.log(list);
			
			
			console.log();
			
			var table = ''; 
			for (var i = 0; i < list.length; i++) {
				var subject = list[i];
				//console.log(subject);
				console.log(subject.no, subject.title);
				
				var tr = '<tr>';
				tr.append('<td>' + subject.no + '</td>');
			}
			
		}, 
		error:function(xhr, status, errorThrown){
			alert('오류 잡으세요');
			console.log(status);
			console.log(errorThrown);
		}
	})

});*/