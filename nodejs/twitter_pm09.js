var http = require('http');
var twitterAPI = require('node-twitter-api');
var twitter = new twitterAPI({
    consumerKey: '1bsocepyZZihm3AxOqt8Uw',
    consumerSecret: 'U2xQiKEWCF5w6Go4k45bqOOL0zYItLUqhZ7i6CVef4',
    callback: 'http://192.168.200.45:8884/getAccessToken'
});

http.createServer(function (req, res) {
	res.setHeader('Access-Control-Allow-Origin', '*');
	
	var urlObj = require('url').parse(req.url, true);
	console.log(urlObj.pathname);
	try {
		if (urlObj.pathname == '/getRequestToken') {
			res.writeHead(200, {'Content-Type': 'text/plain'});
			
			twitter.getRequestToken(function(error, requestToken, requestTokenSecret, results){
				if (error) {
					console.log("Error getting OAuth request token : " + error);
				} else {
					// console.log(requestToken);
					res.write(dsfsdfsdfdsf)
					//res.write('"requestToken":"' + requestToken + '"');
					res.write('}');
					res.end();
				}
			});
			
		}	else {
			res.write('if -- error');
			res.end();
		}
		
	}	catch(err) {
		throw 'catch  --- error';
	}
	
	
  

  
}).listen(8884, '192.168.200.45');
console.log('Server running at http://192.168.200.45:8884/');
