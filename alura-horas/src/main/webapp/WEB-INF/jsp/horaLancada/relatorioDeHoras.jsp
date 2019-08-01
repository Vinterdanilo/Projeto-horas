<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
<br>
	<br>
	<table class = "table table-stripped table-hover table-bordered">
		<thead>
			<tr>
				<th>Data<th>
				<th>Horas Normais</th>
				<th>Horas Extras</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach items="${relatorio.horasPorDia}" var = "horas">
				<tr>
					<td>${horas.data.time}</td>
					<td>${horas.horasNormais}</td>
					<td>${horas.horasExtras}</td>
			<%-- 	<td><a href="<c:url value='/usuario/remove?usuario.id=${usuario.id}'/>">Remover</a></td>
					<td><a href="<c:url value='/produto/formularioAtualiza?produto.id=${produto.id}'/>">Atualizar</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<c:import url="/WEB-INF/jsp/footer.jsp"/>