<%@page import="model.Conta"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<Conta> lista = (ArrayList<Conta>) request.getAttribute("extrato");
	%>
	
	<%for(int i=0;i<lista.size(); i++) {%>
		<br/> <%= lista.get(i) %>
	<%} %>

	<table>
		<tr>
			<td>Conta</td>
			<td>Valor</td>
			<td>Operacao</td>
		</tr>
	</table>
	<br />
	<a href="javascript:history.go(-1)">Voltar</a>
</body>
</html>