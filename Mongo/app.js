var express = require('express');
var http=require('http');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var expressSession=require('express-session');
var expressErrorHandler=require('express-error-handler');

var index = require('./routes/index');
var users = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');
app.set('port',3000);

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
//세션 설정
app.use(expressSession({
  secret : 'mykey',
  resave : true,
  saveUninitialized:true
}));  

//몽고디비 모듈 사용
var MongoClient=require('mongodb').MongoClient;

//데이터베이스 객체를 위한 변수 선언
var database;

//데이터베이스에 연결
function connectDB(){
  //데이터베이스 연결 정보
  var databaseUrl='mongodb://localhost:27017/local';

  //데이터베이스 연결
  MongoClient.connect(databaseUrl,function(err,db){
    if(err) throw err;

    console.log('데이터베이스에 연결되었습니다. : '+databaseUrl);
    
    //database 변수에 할당
    database=db;
  })
}

//라우터 객체 참조
var router=express.Router();

//로그인 라우팅 함수 - 데어터베이스의 정보와 비교
router.route('/process/login').post(function(req,res){
  console.log('/process/login 호출됨');
});

app.post('/process/login',function(req,res){
  console.log('/process/login 호출됨.');

  var paramId=req.param('id');
  var paramPassword=req.param('password');

  if(database){
    authUser(database,paramId,paramPassword,function(err,docs){
      if(err){throw err;}

      if(docs){
        console.dir(docs);

        res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
        res.write('<h1>로그인 성공</h1>');
        res.write('<div><p>사용자 아이디'+paramId+'</p></div>');
        res.write('<div><p>사용자 비밀번호'+paramPassword+'</p></div>');
        res.write("<br><br><a href='/login.html' >다시 로그인하기</a>");
        res.end();
      }else{
        res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
        res.write('<h1>로그인 실패</h1>');
        res.write('<div><p>아이디와 비밀번호를 다시 확인하십시오.</p></div>');
        res.write("<br><br><a href='/login.html' >다시 로그인하기</a>");
        res.end();
      }
    });
  }else{
    res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
    res.write('<h1>데이터베이스 연결실패</h1>');
    res.write('<div><p>데이터베이스에 연결하지 못했습니다.</p></div>');
  }
});

var authUser=function(database,id,password,callback){
  console.log('authUser 호출됨.');

  //Users 컬렉션 참조
  var users=database.collection('users');

  //아이디와 비밀번호를 사용해 검색
  users.find({"id":id, "password":password}).toArray(function(err,docs){
    if(err){
      callback(err,null);
      return;
    }

    if(docs.length>0){
      console.log('아이디 [%s], 비밀번호 [%s]가 일치하는 사용자 찾음.',id,password);
      callback(null,docs);
    }else
      console.log('일치하는 사용자를 찾지 못함.');
      callback(null,null);
  });
}

//======서버 시작=======//
http.createServer(app).listen(app.get('port'),function(){
  console.log('서버가 시작되었습니다. 포트 : '+app.get('port'));
  connectDB();
});