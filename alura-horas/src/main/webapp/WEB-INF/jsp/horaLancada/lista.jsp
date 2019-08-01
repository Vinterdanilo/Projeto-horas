<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir = "/WEB-INF/tags" prefix="verificaErro" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
	<ul class="nav nav-tabs">
		<li><a href="${linkTo[HoraLancadaController].form()}">Cadastrar Hora</a></li>
		<li><a href="${linkTo[HoraLancadaController].relatorioDeHoras()}">Relatorio</a></li>
	</ul>
	
	<br>
		<table class = "table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Id Usuario</th>
					<th>Data</th>
					<th>Hora Inicial </th>
					<th>Hora Final</th>
					<th>Duracao</th>
				
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${horas}" var = "listaHoras">
					<tr>
						<td>${listaHoras.id}</td>
						<td>${listaHoras.usuario.id}</td>
						<td>${listaHoras.data.time}</td>
						<td>${listaHoras.horaInicial}</td>
						<td>${listaHoras.horaFinal}</td>
						<td>${listaHoras.duracao}</td>
				<%-- 	<td><a href="<c:url value='/usuario/remove?usuario.id=${usuario.id}'/>">Remover</a></td>
						<td><a href="<c:url value='/produto/formularioAtualiza?produto.id=${produto.id}'/>">Atualizar</a></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<c:if test="${not empty mensagem}">
   		<div class="alert alert-primary" role = "alert">${mensagem}</div>
	</c:if>
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>