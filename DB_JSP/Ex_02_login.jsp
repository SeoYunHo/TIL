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
			Class.forName(driver);
			connection=DriverManager.getConnection(url,uid,upw);
			statement=connection.createStatement();
			
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			
			resultSet=statement.executeQuery("select * from user where id='"+id+"' and pw='"+pw+"'; ");
			
			if(resultSet.next()){
				out.print("<h1>로그인 완료<h1/><br/>");
			}else{
				out.print("<h1>로그인 실패<h1/><br/>");
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
	
</body>
</html>