package br.com.alura.horas.controllers;

import javax.inject.Inject;

import org.hibernate.annotations.Immutable;

import br.com.alura.horas.dao.UsuarioDao;
import br.com.alura.horas.modelos.Usuario;
import br.com.alura.horas.seguranca.Open;
import br.com.alura.horas.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {
	
	private UsuarioDao usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;
	
	@Inject
	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado, Result result, Validator validator){
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	@Deprecated
	public LoginController() {}
	@Open
	public void form() {
		
	}
	
	@IncludeParameters
	@Open
	public void autentica(Usuario usuario) {
		Usuario usuarioArmazenado = usuarioDao.buscaLogin(usuario.getLogin(), usuario.getSenha());
		if(usuarioArmazenado == null) {
			result.include("mensagem", "Login ou senha incorretos");
			result.redirectTo(this).form();
			
		}
		if(usuarioArmazenado != null){
			usuarioLogado.setId(usuarioArmazenado.getId());
			usuarioLogado.fazLogin(usuarioArmazenado);
			result.redirectTo(UsuarioController.class).lista();
		}
	}
	
	@Open
	public void desloga() {
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}
}
