<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--표현식, 결과 값은 String타입이며 세미콜론 사용 불가 --%>
	<%!
		int i=10;
		String str="abc";
		
		private int sum(int a,int b){
			return a+b;
		}
	%>
	
	<%= i %><br/>			
	<%= str %><br/>
	<%= sum(1,5) %><br/>
</body>
</html>