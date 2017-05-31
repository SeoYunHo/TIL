var express = require('express');
var http=require('http');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var expressSession=require('express-session');
var expressErrorHandler=require('express-error-handler');

var router=require('./modules/router');

var index = require('./routes/index');
var users = require('./routes/users');

var app = express();

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');
app.set('port',3000);

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use(expressSession({
  secret : 'mykey',
  resave : true,
  saveUninitialized:true
}));  


var mongoose=require('mongoose')

var database;

function connectDB(){
  var databaseUrl='mongodb://localhost:27017/local';

  mongoose.Promise=global.Promise;
  mongoose.connect(databaseUrl);
  database=mongoose.connection;

  database.on('error',console.error.bind(console,'mongoose connection error.'));
  database.on('open', function(){
      console.log('Database Connection Succeed');
  });

  database.on('disconnect', function(){
      console.log("Database connection lost. Server will retry in 5 secs");
      setInterval(connectDB, 5000);
  });
}

app.use('/',router);

//======서버 시작=======//
http.createServer(app).listen(app.get('port'),function(){
  console.log('서버가 시작되었습니다. 포트 : '+app.get('port'));
  connectDB();
});