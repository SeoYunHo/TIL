<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Object obj1=session.getAttribute("mySessionName");
		String mySessionName=(String) obj1;
		out.print(mySessionName+"<br/>");
		
		Object obj2=session.getAttribute("myNum");
		Integer myNum=(Integer) obj2;
		out.print(myNum+"<br/>");
		
		out.print("***************<br/>");
		
		String sName;
		String sValue;
		Enumeration enumeration=session.getAttributeNames();
		while(enumeration.hasMoreElements()){
			sName=enumeration.nextElement().toString();
			sValue= session.getAttribute(sName).toString();
			out.print("sName : "+ sName+"<br/>");
			out.print("sValue : "+ sValue+"<br/>");
		}
		out.print("***************<br/>");
		
		String sessionID=session.getId();
		out.print("sessionID : "+sessionID+"<br/>");
		int sessionInter=session.getMaxInactiveInterval();
		out.print("sessionInter : "+sessionInter+"<br/>");
		
		out.print("***************<br/>");
		
		session.removeAttribute("mySessionName");
		Enumeration enumeration1=session.getAttributeNames();
		while(enumeration.hasMoreElements()){
			sName=enumeration.nextElement().toString();
			sValue= session.getAttribute(sName).toString();
			out.print("sName : "+ sName+"<br/>");
			out.print("sValue : "+ sValue+"<br/>");
		}
		
		session.invalidate();
		if(request.isRequestedSessionIdValid()){
			out.print("session vaild");
		}else{
			out.print("session invaild");
		}
	%>
</body>
</html>