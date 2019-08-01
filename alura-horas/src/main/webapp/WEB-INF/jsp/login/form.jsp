<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir = "/WEB-INF/tags" prefix="verificaErro" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<br>
		<form action="${linkTo[LoginController].autentica()}" method = "post">

		<h2 class="form-signin-heading">Login</h2>
		<br>
			<input type = "text" id = "login" name = "usuario.login" class="form-control"  placeholder="Login"/>
			<br>
			<input type = "password" id = "senha" name = "usuario.senha" class="form-control"  placeholder="Senha"/>
			<br>
			<button type = "submit" class="btn btn-lg btn-primary btn-block">Autenticar</button>
		
		</form>
		
		<c:if test="${not empty mensagem}">
   			<div class="alert alert-warning">${mensagem}</div>
		</c:if>
		
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>