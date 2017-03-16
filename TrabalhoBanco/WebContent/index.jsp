<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="MainServlet" method="post">
	Para acessar sua conta entre com:
<br/>Número conta: <input type="text" name="numeroConta"/>
<br/>Senha: <input type="text" name="senha"/>
<br/>Não possui conta? <button>Cadastro</button>
<br/><input type="submit" value="Enviar">
</form>

</body>
</html>