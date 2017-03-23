<%@page import="dao.ContaDAOMongo"%>
<%@page import="dao.ContaDAO"%>
<%@page import="model.Operacao"%>
<%@page import="java.util.List"%>
<%@page import="model.Conta"%>
<%@page import="java.util.ArrayList"%>

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
		ArrayList<Operacao> lista = (ArrayList<Operacao>) request.getAttribute("extrato");
	%>
	Extrato:  
	<br/>
	<%for(int i=0;i<lista.size(); i++) {%>
	<br/>		
			Data: <%=lista.get(i).getData() %><br/>
			Valor: <%=lista.get(i).getValor() %><br/>
			Operação: <%=lista.get(i).getTipoOpr() %><br/>
	
	<%} %>
	
	<a href="javascript:history.go(-1)">Voltar</a>
</body>
</html>