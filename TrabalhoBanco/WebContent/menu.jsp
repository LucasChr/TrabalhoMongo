<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="OperadoresServlet" method="post">
		<%
			String conta = (String) request.getAttribute("conta");
		%>
		Numero da conta: <input type="text" name="conta" value="<%= conta %>" readonly="readonly">
		<br />Selecione uma operação e insira os valores: <br /> 
		<br />Crédito:<input type="radio" name="op" value="credito" checked> 
		Débito:<input type="radio" name="op" value="debito"> 
		
		<br>Valor:<input type="text" name="valor"> 
		<br> <input type="submit" value="Enviar"> 
		<a href="ExtratoServlet">Extrato</a>
	</form>

</body>
</html>