<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>
<body>

<form action="movimentacoes" method="POST">

	Pesquisa movimentações.
	<br /><br />
	Data Inicial: <input type="text" name="data_ini" />
	<br />
	Data Final: <input type="text" name="data_fim" />
	<br /><br />
	Tipo:
	<br />
		Entrada <input type="radio" value="ENTRADA" name="tipoMovimentacao" />
		<br />
		Saída <input type="radio" value="SAIDA" checked="checked"  name="tipoMovimentacao" /> 
		
	<br /><br />
	<input type="submit" value="Gera relatório" />

</form>
</body>
</html>