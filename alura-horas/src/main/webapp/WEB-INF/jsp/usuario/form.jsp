<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir = "/WEB-INF/tags" prefix="verificaErro" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<br>
		<form action="${linkTo[UsuarioController].adiciona(null)}" method = "post">
			
			<label for="name">Nome:</label>
			<input type = "text" id = "nome"  name = "usuario.nome" class="form-control" value = "${usuario.nome}"/>
			<verificaErro:validationMessage name="usuario.nome"/>
			
			<label for="login">Login:</label>
			<input type = "text" id = "login" name = "usuario.login" class="form-control" value = "${usuario.login}"/>
			<verificaErro:validationMessage name="usuario.login"/>
			
			<label for="email">E-mail:</label>
			<input type = "email" id = "email" name = "usuario.email" class="form-control" value = "${usuario.email}"/>
			<verificaErro:validationMessage name="usuario.email"/>
			
			<label for="senha">Senha:</label>
			<input type = "password" id = "senha" name = "usuario.senha" class="form-control"/>
			<verificaErro:validationMessage name="usuario.senha"/>
			
			<br>
			<button type = "submit" class="btn btn-lg btn-primary btn-block">Cadastrar</button>
		
		</form>
	<br>
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>