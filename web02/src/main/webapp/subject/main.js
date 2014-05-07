$(document).ready(function(){
	
	
	
	var coo = 'Account :  ';
	coo += $.cookie().loginEmail;
	console.log(coo);
	
	
	$('#header').append(coo);
	
	// 페이지 로드
	var page = 1;
	var list = '';
	
	
	// 1페이지 로드
	load();
	$('#pre').css("display", "none");

	$('#pre').on('click', function() {
		page --;
		
		clear();
		load();

		
	})
	
	
	$('#next').on('click', function() {
		page ++;
		console.log(page);
		
		clear();
		load();
		
		$('#pre').css("display", "block");
	})

	
function load() {
	$.ajax('list.ajax', {
		type: 'POST',
		dataType: 'json', 	// 서버에서 보내는 데이터의 형식 지정
		data: { 			// 서버쪽으로 보내는 데이터
			pageNo: page		//,
			//pageSize: $('#password').val(),
		},
		success: function(Object){
			//console.log(Object);
			var list = Object.ajaxResult.data;
			
			var pageSize = Object.ajaxResult.pageSize;
			
			// 페이지가 1일때 안보이게
			if (page != 1) {
				$('#pre').css("display", "");
			}	else {
				$('#pre').css("display", "none");
			}
			
			// 출력 갯수가 10개일때만 다음 버튼 보이게
			if (pageSize == 10) {
				$('#next').css("display", "");
			}	else {
				$('#next').css("display", "none");
			}
			
			
			//console.log();
			var listTable = $('#listTable');
			var tr, td = null; 
			for (var i = 0; i < list.length; i++) {
				var subject = list[i];
				//console.log(subject);
				console.log(subject.no, subject.title);
				
				tr = document.createElement('tr');
				tr.setAttribute('class', 'listTr');
				td = document.createElement('td');
				td.innerHTML = subject.no;
				tr.appendChild(td);
				
				td = document.createElement('td');
				td.innerHTML = subject.title;
				tr.appendChild(td);
				
				listTable.append(tr);
			}
			
		}, 
		error:function(xhr, status, errorThrown){
			alert('오류 잡으세요');
			console.log(status);
			console.log(errorThrown);
		}
	})
}

function clear() {
	$('.listTr').remove();
}

	
});