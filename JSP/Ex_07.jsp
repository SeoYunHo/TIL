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
		out.println("���� : "+request.getServerName()+"<br/>"); 		//�����̸��� ����ϴ�.
		out.println("��Ʈ ��ȣ : "+request.getServerPort()+"<br/>");	//������ ��Ʈ��ȣ�� ����ϴ�.
		out.println("��û ��� : "+request.getMethod()+"<br/>");		//get��İ� post����� ������ �� �ֽ��ϴ�.
		out.println("�������� : "+request.getProtocol()+"<br/>");		//�ش� ���������� ����ϴ�.
		out.println("URL : "+request.getRequestURL()+"<br/>");		//��û URL�� ����ϴ�.
		out.println("URI : "+request.getRequestURI()+"<br/>");		//��û URI�� ����ϴ�.
	%> 
</body>
</html>