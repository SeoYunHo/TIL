var fs=require('fs');

//파일을 비동기식 IO롤 읽어 들입니다.
var data=fs.readFile('./Ex_11_text.txt','utf8',function(err,data){
    //읽어 들인 데이터를 출력합니다.
    console.log(data);
});

console.log('프로젝트 폴더 안의 Ex_11_text.txt파일을 읽도록 요청했습니다.');

