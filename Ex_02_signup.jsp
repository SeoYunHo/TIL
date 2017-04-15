<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/Ex";
	String uid="root";
	String upw="hy980615";
	int r;
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		try{
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			
			Class.forName(driver);
			connection=DriverManager.getConnection(url,uid,upw);
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from user where id='"+id+"' and pw='"+pw+"' ");
			
			if(resultSet.next()){
				out.print("<h1>이미 가입된 회원입니다.<h1/><br/>");
			}else{
				String query="insert into user values('"+id+"','"+pw+"');";
				int r=statement.executeUpdate(query);
				if(r==1) out.print("<h1>회원가입이 완료되었습니다.</h1><br/>");
				else{ out.print("<h1>회원가입에 실패했습니다.<h1/><br/>");}	
			}
		}catch(Exception e){
			out.print(e);
		}finally{
			try{
				if(resultSet!=null) resultSet.close();
				if(statement!=null) statement.close();
				if(connection!=null) connection.close();
			}catch(Exception e){}
		}
	%>
	<a href="Ex_02_login.html">로그인하러 가기</a>
</body>
</html>