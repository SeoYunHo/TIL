var express = require('express');
var http=require('http');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var index = require('./routes/index');
var users = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');
app.set('port',3000);

//uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', index);
app.use('/users', users);

app.use(function(req,res,next){
  console.log('첫 번째 미들웨어에서 요청을 처리함');

  req.user='mike';

  next();
});

app.use('/',function(req,res,next){
  console.log('두 번째 미들웨어에서 요청을 처리함');

  res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
  res.end('<h1>Express 서버에서 '+req.user+' 응답한 결과입니다.</h1>');

  next();
});

//catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;

http.createServer(app).listen(3000,function(){
  console.log('Express 서버가 실행되었습니다.');
});
