<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("서버 : "+request.getServerName()+"<br/>"); 		//서버이름을 얻습니다.
		out.println("포트 번호 : "+request.getServerPort()+"<br/>");	//서버의 포트번호를 얻습니다.
		out.println("요청 방식 : "+request.getMethod()+"<br/>");		//get방식과 post방식을 구분할 수 있습니다.
		out.println("프로토콜 : "+request.getProtocol()+"<br/>");		//해당 프로토콜을 얻습니다.
		out.println("URL : "+request.getRequestURL()+"<br/>");		//요청 URL을 얻습니다.
		out.println("URI : "+request.getRequestURI()+"<br/>");		//요청 URI를 얻습니다.
	%> 
</body>
</html>