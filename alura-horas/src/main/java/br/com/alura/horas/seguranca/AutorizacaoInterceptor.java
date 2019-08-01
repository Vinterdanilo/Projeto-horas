package br.com.alura.horas.seguranca;


import javax.inject.Inject;

import br.com.alura.horas.controllers.LoginController;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizacaoInterceptor {
	
	private Result result;
	private UsuarioLogado usuarioLogado;
	private ControllerMethod method;
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
	}
	
	@Deprecated
	public AutorizacaoInterceptor() {}
	
	//Condica, a qual o Intercepts será executado
	@Accepts
	public boolean accept() {
		return !method.containsAnnotation(Open.class);
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if(usuarioLogado.isLogado())
		{		
		//se o usuario estiver logado, 
		stack.next();
		}else {
			//se o usuario nao estiver logado, redirecionamos o mesmo para a tela de login;
			result.redirectTo(LoginController.class).form();
		}
	}
	
}
