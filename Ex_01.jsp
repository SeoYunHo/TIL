<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/Ex";
	String uid="root";
	String upw="hy980615";
	String query="select * from member";
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
			connection=DriverManager.getConnection(url,uid,"hy980615");
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			
			while(resultSet.next()){
				String id=resultSet.getString("id");
				String pw=resultSet.getString("pw");
				String name=resultSet.getString("name"); 
				String phone=resultSet.getString("phone");
				
				out.print("아이디: "+id+"비밀번호: "+pw+"이름: "+name+"휴대폰: "+phone+"<br/>");
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