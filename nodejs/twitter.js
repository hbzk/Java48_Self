var http = require('http');
var twitterAPI = require('node-twitter-api');
var twitter = new twitterAPI({
    consumerKey: '1bsocepyZZihm3AxOqt8Uw',
    consumerSecret: 'U2xQiKEWCF5w6Go4k45bqOOL0zYItLUqhZ7i6CVef4',
    callback: 'http://192.168.200.45:8884/getAccessToken'
});

var reqToken, reqTokenSec;
var accToken, accTokenSec;


http.createServer(function (req, res) {
	var urlObj = require('url').parse(req.url, true);

	try {
		if (urlObj.pathname == '/getRequestToken') {
			res.setHeader('Access-Control-Allow-Origin', '*');
			res.writeHead(200, {'Content-Type': 'text/plain'});
			twitter.getRequestToken(function(error, requestToken, requestTokenSecret, results){
				if (error) {
					console.log("Error getting OAuth request token : " + error);
				} else {
					console.log(requestToken);
					reqToken = requestToken;
					reqTokenSec = requestTokenSecret;
					
					res.write('{');
					res.write('"requestToken":"' + requestToken + '"');
					res.write('}');
					res.end();
					//store token and tokenSecret somewhere, you'll need them later; redirect user
				}
			});

		}	else if (urlObj.pathname == '/getAccessToken') {
			
			
		}	else if (urlObj.pathname == '/getUserTimeline') {
			
			
		}	else {
			
		}

	}	catch(err) {
		throw 'catch err -------';
	}



}).listen(8884, '192.168.200.45');
console.log('Server running at http://192.168.200.45:8884/');

