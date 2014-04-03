var http = require('http');
var totalMsg = []; // 함수 실행과 무관하게 변수가 유지 되도록 밖에 선언
http.createServer(function (req, res) {
  // url이라는 도구를 준비 >> .parse라는 함수를 호출 >> 파라미터로 브라우져의 url을 준다
  try {
	  var params = require('url').parse(req.url, true).query;
	  totalMsg.push(params.me + ":" + params.msg);

	  res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});	  // 200==ok를 의미
	  totalMsg.forEach(function(item) {
		  console.log(totalMsg);
		  res.write(item + '\n');
	  });
  }	catch (err) {
	  res.write(String(err));
  }
  res.end();
}).listen(8883, '192.168.200.45');
console.log('Server running at http://192.168.200.45:8883/');