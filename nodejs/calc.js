var http = require('http');		// http라는 도구를 준비 (포함된 함수를 호출할 수 있는)
http.createServer(function (req, res) {	// .createServer(([requestListener])) => 새로운 웹 서버를 리턴한다
																// [requestListener]	(요청 이벤트 발생시 호출할 함수)	// [Listener] 	(이벤트 발생시 호출할 함수) 
																// (req, res) // req => 클라이언트(브라우저)측 정보	// res => 응답 정보				
	
	var urlObj = require('url').parse(req.url, true); 	// url이라는 도구를 준비  (포함된 함수를 호출할 수 있는)
																				// .parse라는 함수를 호출 // (req.url) =>파라미터로 브라우져의 url을 준다.
																				// true => query:  {a=10, b=20} 형태로 얻고 싶을때
																				// 기본값은 false => query: 'a=10&b=20' 형태 그대로 (검색결과 url처럼) 
	
	// 변수urlObj 에는 { href: '/calc?op=minus&a=10&b=30',
	//	  search: '?op=minus&a=10&b=30',
	//	  query: { a=10, b=20 },
	//	  pathname: '/calc' 
	//	  ...} 이런 값들이 들어왔다
	var pathname = urlObj.pathname;						// url 중 ?이전 부분을 확인, 이번 예제에서는  어떤 함수인지 판단하기 위해 사용	// 예)calc
	var params = urlObj.query;								// url 중 ?이후 속성과 값을 모아둔다	// 예) { a=10, b=20, c=20, ...}
	try {																		// 오류 발생시 서버 전체가 다운(응답 불) 되는것을 막기위해 try {} catch {} 문을 사용, 동작 전체를 감쌌다.
																				// 오류 발생 가능성 있는 부분은 다 감싸주도록 권장
	  if (pathname == '/calc') {									// 이번 예제에서는 calc(계산기) 함수임을 구분하도록 사용
		  var result = 0;												// 출력을 위한 결과값 변수 지정
		  var a = Number(params.a);							// Number(prompt) => params 자체는 문자로 인식되므로, 연산을 위해 숫자로 강제 형 변환 
		  var b = Number(params.b);
		  if (params.op == 'plus') {								// { op=plus, ... ) 부분을 파악해서 어떤 연산인지 판단 
			  result = a + b;											// 해당 연산 동작 후 result 변수에 저장
		  }	else if (params.op == 'minus') {
			  result = a - b;
		  }	else {
			  result = '지원하지 않는 연산자이거나 값이 올바르지 않습니다.';	// 준비된 연산이 아닌경우 사용자가 알 수 있도록 오류 메시지 출력
		  }
		  
		  // 이 아래는 res (= 서버가 클라이언트에게 응답 할 정보) 관련
		  res.writeHead(200, {'Content-Type': 'text/plain; charset=UTF-8'});	// 200==ok를 의미 404 등 오류 코드
		  															// text/plain => 응답 내용은 순수 문자형태이며 // UTF-8을 사용했다는것을 클라이언트에게 알림
		  res.write(String(result));	// 연산 후 결과를 담아뒀던 result 변수를 출력 // >> String() 으로 강제 형 변환
		  											// .write() 내부의 첫 아규먼트는 string이나 buffer여야 한다. 
	  }
	}	catch (err) {														// 동작 중 오류가 발생했다면 동작할 함수 호출, 오류 사항을 err이라는 파라미터 명으로 같이 넘긴다.
		res.write(String(err));										// err 이라는 이름으로 받은 에러 내용을 출력한다. // .write() 사용으로 String() 으로 강제 형 변환
	}
	res.end();									// 응답 내용이 완료되었음을 클라이언트에게 알림, 각 응답(response)에 필수적으로 포함되어야 한다
}).listen(8882, '192.168.200.45');			// 서버가 응답을 받을(listen) url과 포트 넘버 지정
console.log('Server running at http://192.168.200.45:8882/');		// 서버가 시작된 것을 서버 관리자가 알 수 있도록 메시지 출력. 내용은 자유
					// 서버 사용중 console.log는 커맨드 창에 출력된다 (브라우저가 아닌,서버 관리자에게)





