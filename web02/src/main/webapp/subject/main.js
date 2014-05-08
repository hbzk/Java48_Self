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
		deleteSubject( $(this).attr('data-no') );
	});
	

	$(document).on('click', 'a.titleLink', function(){
		$.getJSON(bit.contextRoot + '/subject/detail.ajax?no=' + $(this).attr('data-no'),
			function(jsonObj){
				var result = jsonObj.ajaxResult;
				if (result.status == "ok") {
					$('#no').val(result.data.no);
					$('#title').val(result.data.title);
					$('#description').val(result.data.description);
					
					changeFormState('update');
				} else {
					alert('해당 과목이 없습니다.')
				}
		});
	});
	

	$('#btnAdd').click(function(){
		$.post(
			bit.contextRoot + '/subject/insert.ajax',
			{
				title: $('#title').val(),
				description: $('#description').val()
			},
			function(jsonObj) {
				console.log(jsonObj);
				loadSubjectList(currPageNo);
				$('#btnReset').click();
			},
			'json');
	});
	
	$('#btnChange').click(function(){
		$.post(
			bit.contextRoot + '/subject/update.ajax',
			{
				no: $('#no').val(),
				title: $('#title').val(),
				description: $('#description').val()
			},
			function(jsonObj) {
				console.log(jsonObj);
				loadSubjectList(currPageNo);
				$('#btnReset').click();
			},
			'json');
	});
	
	$('#btnDelete').click(function(){
		deleteSubject( $('#no').val() );
	});
	
	$('#btnReset').click(function(){
		changeFormState('new');
	});
	
	
	
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

function deleteSubject(no) {
	$.getJSON(bit.contextRoot + '/subject/delete.ajax?no=' + no,
			function(jsonObj){
				var result = jsonObj.ajaxResult;
				if (result.status == "ok") {
					loadSubjectList(currPageNo);
					$('#btnReset').click();
					$('#subjectList').show('clip', 500);
				}
		});
}

function loadSubjectList(pageNo) {
	$.getJSON(
		bit.contextRoot + '/subject/list.ajax?pageNo=' + pageNo + '&pageSize=' + pageSize,
		function(jsonObj){
			var result = jsonObj.ajaxResult;
			listSize = result.data.length;
			
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
							.addClass('titleLink')
							.attr('href', '#')
							.attr('data-no', subject.no)
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
				
				$('#btnReset').click();
				toggleBtn();
			}
	});
}

function changeFormState(state) {
	if (state == 'update') {
		$('.updateFormItem').css('display', '');
		$('.newFormItem').css('display', 'none');
	}	else {
		$('.updateFormItem').css('display', 'none');
		$('.newFormItem').css('display', '');
	}
}



