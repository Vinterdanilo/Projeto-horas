<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir = "/WEB-INF/tags" prefix="verificaErro" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
<br>	
	<form action="${linkTo[HoraLancadaController].adiciona(null)}" method = "post">
			
			<label for="data">Data:</label>
			<input type = "text" id = "data"  name = "horaLancada.data" class="form-control" value = "${horaLancada.data}"/>
			<verificaErro:validationMessage name="horaLancada.data"/>
			
			<label for="horaInicial">Hora Incial:</label>
			<input type = "text" id = "horaInicial" name = "horaLancada.horaInicial" class="form-control" value = "${horaLancada.horaInicial}"/>
			<verificaErro:validationMessage name="horaLancada.horaInicial"/>
			
			
			<label for="horaFinal">Hora Final:</label>
			<input type = "text" id = "horaFinal" name = "horaLancada.horaFinal" class="form-control" value = "${horaLancada.horaFinal}"/>
			<verificaErro:validationMessage name="horaLancada.horaFinal"/>
			
			<label for="comentario">Comentario:</label>
			<input type = "text" id = "comentario" name = "horaLancada.comentario" class="form-control" value = "${horaLancada.comentario}"/>
			<verificaErro:validationMessage name="horaLancada.comentario"/>
			
			<br>
			<button type = "submit" class="btn btn-lg btn-primary btn-block">Cadastrar</button>
	</form>
	<br>
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>