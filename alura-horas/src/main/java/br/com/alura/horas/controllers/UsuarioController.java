package br.com.alura.horas.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.UsuarioDao;
import br.com.alura.horas.modelos.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	private Result result;
	private Validator validator;
	
	@Inject
	public UsuarioController(UsuarioDao usuarioDao,Result result,Validator validator){
    	this.usuarioDao = usuarioDao;
    	this.result = result;
    	this.validator = validator;
    }

	public UsuarioController(){}
	
	public void form(){}
	
	public void lista(){
        result.include("usuarios", usuarioDao.lista());
    }
	
	//acesso do usuario, direto na view
    @IncludeParameters
    public void adiciona(@Valid Usuario usuario){
    	validator.onErrorRedirectTo(this).form();
    	usuarioDao.adicionar(usuario);
    	result.include("mensagem", "Usuario adicionado com sucesso!");
    	result.redirectTo(this).lista();
    }

    @Get
	public void remove(Usuario usuario) {
    	usuarioDao.remover(usuario);
		result.include("mensagem", "Usuario removido com sucesso!");
		result.redirectTo(this).lista();
	}
}




