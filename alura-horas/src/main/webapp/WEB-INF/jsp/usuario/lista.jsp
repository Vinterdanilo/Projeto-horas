<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp"/>
	<ul class="nav nav-tabs">
		<li><a href="${linkTo[UsuarioController].form()}">Novo usuário</a></li>
	</ul>
	<br>
	<br>
	<table class = "table table-stripped table-hover table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Login</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach items="${usuarios}" var = "usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.login}</td>
			<%-- 	<td><a href="<c:url value='/usuario/remove?usuario.id=${usuario.id}'/>">Remover</a></td>
					<td><a href="<c:url value='/produto/formularioAtualiza?produto.id=${produto.id}'/>">Atualizar</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty mensagem}">
   		<div class="alert alert-primary" role = "alert">${mensagem}</div>
	</c:if>

<c:import url="/WEB-INF/jsp/footer.jsp"/>