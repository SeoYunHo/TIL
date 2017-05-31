var router = require('express').Router();
var manager = require('./manager');

router.route('/process/login').post(function (req, res) {
    console.log('/process/login 호출됨.');

    var paramId = req.body.id || req.query.id;
    var paramPassword = req.body.password || req.query.password;

    console.log("here is out authUsser");

    authUser(paramId, paramPassword, function (err, docs) {
        console.log("here is in authUsser");
        if (err) { throw err; }

        if (docs) {
            res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h1>로그인 성공</h1>');
            res.write('<div><p>사용자 아이디'+paramId+'</p></div>');
            res.write('<div><p>사용자 비밀번호'+paramPassword+'</p></div>');
            res.write("<br><br><a href='/login.html' >다시 로그인하기</a>");
            res.end();
        } else {
              res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h1>로그인 실패</h1>');
            res.write('<div><p>아이디와 비밀번호를 다시 확인하십시오.</p></div>');
            res.write("<br><br><a href='/login.html' >다시 로그인하기</a>");
            res.end();
        }
    });
});

router.route('/process/adduser').post(function (req, res) {
    console.log('/process/adduser 호출됨');

    var paramId = req.body.id || req.query.id;
    var paramPassword = req.body.password || req.query.password;
    var paramName = req.body.name || req.query.name;

    console.log('요청 파라미터 : ' + paramId + ', ' + paramPassword + ', ' + paramName);

    addUser(paramId, paramPassword, paramName, function (err, result) {
        if (err) { throw err; }
        console.log(result.insertedCount);
        if (result.insertedCount > 0) {
            console.dir(result);

            //   res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h2>사용자 추가 성공</h2>');
            res.end();
        } else {
            //   res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h2>사용자 추가 실패</h2>');
            res.end();
        }
    });
});

router.route('/process/listuser').post(function (req, res) {
    console.log('/process/listuser 호출됨');

    manager.findAll(function (err, resultes) {
        if (err) {
            //   res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h2>사용자 리스트 조회중 오류 발생</h2>');
            res.write('<p>' + err.stack + '</p>');
            res.end();

            return;
        }

        if (resultes) {
            //   res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h2>사용자 리스트</h2>');
            res.write('<div><ul>');

            for (var i = 0; i < resultes.length; i++) {
                var curId = resultes[i]._doc.id;
                var curName = resultes[i]._doc.name;
                res.write('    <li>#' + i + ' : ' + curId + ', ' + curName + '</li>');
            }

            res.write('</ul></div>');
            res.end();
        } else {
            //   res.writeHead('200',{'Content-Type':'text/html;charset=utf8'});
            res.write('<h2>사용자 리스트 조회 실패</h2>');
        }
    });
});

var authUser = function (id, password, callback) {
    manager.findById(id, function (err, results) {
        if (err) {
            callback(err, null);
            return;
        }

        if (results.length > 0) {
            console.log('아이디가 일치하는 사람 찾음');

            if (results[0]._doc.password == password) {
                console.log('비밀번호 일치함');
                callback(null, results);
            } else {
                console.log('비밀번호 불일치');
                callback(null, null);
            }
        } else
            console.log('일치하는 사용자를 찾지 못함.');
        callback(null, null);
    });
};

var addUser = function (id, password, name, callback) {
    manager.addUser(id, password, name, function (err, results) {
        if (err) {
            callback(err, null);
            return;
        }

        if (results.insertedCount > 0) {
            console.log('사용자 레코드 추가됨.' + results.insertedCount);
        } else {
            console.log('추가된 레코드 없음.');
        }

        callback(null, results);
    });
};



module.exports = router;
