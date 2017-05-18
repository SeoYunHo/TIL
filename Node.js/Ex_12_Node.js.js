var fs=require('fs');

//파일에 데이터를 습니다.
fs.writeFile('./Ex_12_text.txt','Hello World!',function(err){
    if(err){
        console.log('Error : '+err);
    }

    console.log('Ex_12_text.txt 파일에 데이터 쓰기 완료');
})