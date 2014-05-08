var currPageNo = 1;
var pageNo = 1;
var pageSize = 10;

var listSize = 0;

$(document).ready(function(){
	$('#header').load('../header.html');
	$('#footer').load('../footer.html');
	
	$('#prevPage').click(function(event){
		if (currPageNo > 1) {
			loadSubjectList(currPageNo - 1);
			$('#subjectList').effect('slide', { direction: 'left'}, 400);
		}
	})
	
	$('#nextPage').click(function(){
		loadSubjectList(currPageNo + 1);
		$('#subjectList').effect('slide', { direction: 'right'}, 300);

	})
	
	// >>>>>>>>>>>>>>>> live litener 등록 <<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
	$(document).on('click', 'button.rowDelBtn', function(){
		$.getJSON(bit.contextRoot + '/subject/delete.ajax?no=' + $(this).attr('data-no'),
			function(jsonObj){
				var result = jsonObj.ajaxResult;
				//if (result.status == "ok") {
					loadSubjectList(currPageNo);
					$('#subjectList').show('clip', 500);
				//}
		});
	})
	
	// UI 테스트
	$('#btnUi').click(function(){
		
	})
	
	
	
	// 페이지 로드 시작
	
	$('#subjectList').hide();
	loadSubjectList(1);
	$('#subjectList').show('clip', 500);
	
	toggleBtn();
});

function toggleBtn() {
	if (currPageNo == 1) {
		$('#prevPage').attr('disabled', 'disabled');
	}	else {
		$('#prevPage').removeAttr('disabled');
	}
}


function loadSubjectList(pageNo) {
	$.getJSON(
		bit.contextRoot + '/subject/list.ajax?pageNo=' + pageNo + '&pageSize=' + pageSize,
		function(jsonObj){
			var result = jsonObj.ajaxResult;
			listSize = result.data.length;
			console.log(listSize);
			
			if (listSize < 10) {
				$('#nextPage').attr('disabled', 'disabled');
			}	else {
				$('#nextPage').removeAttr('disabled');
			}
			
			
			if (result.data.length > 0) {
				var table = $('#subjectList');
				$('.dataRow').remove();
				
				$.each(result.data, function(index, subject){
					$('<tr>')
					.addClass('dataRow')
					.append('<td>' + subject.no)
					.append($('<td>')
						.append($('<a>')
							.attr('href', contextRoot + '/subject/detail.bit?no=' + subject.no)
							.text(subject.title)
						)
					)
					.append($('<td>')
						.append($('<button>삭제</button>')
							.addClass('rowDelBtn')
							.addClass('btn btn-danger btn-xs')
							.attr('data-no', subject.no)
					))
					.appendTo(table);
				});
				currPageNo = pageNo;
				$('#currPageNo').text(pageNo);
				toggleBtn();
			}
	});
}