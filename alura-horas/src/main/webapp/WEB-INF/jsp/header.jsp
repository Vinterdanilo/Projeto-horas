<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
	<title>Sistema de horas</title>
	<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
	<link href="<c:url value='/css/site.css'/>" rel="stylesheet"/>
</head>
<body>
<nav>
<div class = "container">
	<ul class="nav nav-tabs">
		<li><a href="${linkTo[IndexController].index()}">Home</a></li>
		<li><a href="${linkTo[UsuarioController].lista()}">Usuarios</a></li>
		<li><a href="${linkTo[HoraLancadaController].lista()}">Horas</a></li>
		<c:if test = "${usuarioLogado.logado}">
		<li><a href="${linkTo[LoginController].desloga()}">Deslogar</a></li>
		</c:if>
		<c:if test = "${!usuarioLogado.logado}">
		<li><a href="${linkTo[LoginController].form()}">Logar</a></li>
		</c:if>
	</ul>
</div>
</nav>
<div class="container">
	<main class="col-sm-8">
	

