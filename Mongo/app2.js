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

//사용자 추가 라우팅 함수-클라이언트에서 보내온 데이터를 이용해 데이터베이스에 추가
app.post('/process/adduser',function(req,res){
  console.log('/process/adduser 호출됨');

  var paramId=req.body.id || req.query.id;
  var paramPassword=req.body.passowrd || req.query.passowrd;
  var paramName=req.body.name || req.query.name;

  console.log('요청 파라미터 : '+paramId+', '+paramPassword+', '+paramName);

  //데이터베이스 객체가 초기화된 경우, addUser 함수 호출하여 사용자 추가
  if(database){
    addUser(database,paramId,paramPassword,paramName,function(err,result){
      if(err){throw err;}

      //결과 객체 확인하여 추가된 데이터 있으면 성공 응답 전송
      if(result&&result.insertedCount>0){
        console.dir(result);

        res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
        res.write('<h2>사용자 추가 성공</h2>');
        res.end();
      }else{  //결과 객체가 없으면 실패 응답 전송
        res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
        res.write('<h2>사용자 추가 실패</h2>');
        res.end();
      }
    });
  }else{
    res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
    res.write('<h1>데이터베이스 연결실패</h1>');
    res.write('<div><p>데이터베이스에 연결하지 못했습니다.</p></div>');
  }
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

var addUser=function(database,id,password,name,callback){
  console.log('addUser 호출됨 : '+id+', '+password+', '+name);

  //users컬렉션 참조
  var users=database.collection('users');

  //id, password, username을 사용해 사용자 추가
  users.insertMany([{"id":id,"passowrd":password,"name":name}],function(err,result){
    if(err){  //오류가 발생했을 때 콜백 함술르 호출하면서 오류 객체 전달
      callback(err,null);
      return;
    }

    //오류가 아닌 경우, 콜백함수를 호출하면서 결과 객체 전달
    if(result.insertedCount>0){
      console.log('사용자 레코드 추가됨.'+result.insertedCount);
    }else{
      console.log('추가된 레코드 없음.');
    }

    callback(null,result);
  });
}

//======서버 시작=======//
http.createServer(app).listen(app.get('port'),function(){
  console.log('서버가 시작되었습니다. 포트 : '+app.get('port'));
  connectDB();
});