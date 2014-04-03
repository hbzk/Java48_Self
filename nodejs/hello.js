var http = require('http');
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.write('Hello World\n');
  res.write('ohora Wolrd\n');
  res.end();
}).listen(8881, '192.168.200.45');
console.log('Server running at http://192.168.200.45:8881/');