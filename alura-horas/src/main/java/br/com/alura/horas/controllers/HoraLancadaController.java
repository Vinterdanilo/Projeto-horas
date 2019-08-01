package br.com.alura.horas.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.HoraLancadaDao;
import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.modelos.RelatorioDeHoras;
import br.com.alura.horas.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HoraLancadaController {

	private HoraLancadaDao dao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;

	@Inject
	public HoraLancadaController(HoraLancadaDao dao, UsuarioLogado usuarioLogado, Result result,Validator validator) {
		this.dao = dao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	@Deprecated
	public HoraLancadaController() {}
	
	public void form() {}
	
	public void adiciona(@Valid HoraLancada horaLancada) {
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(usuarioLogado.getUsuario());
		dao.adiciona(horaLancada);
		result.include("mensagem", "Hora cadastrada com sucesso!");
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		result.include("horas", dao.lista());
	}
	
	public void relatorioDeHoras() {
		List<HoraLancada> horas = dao.horasDoUsuario(usuarioLogado.getUsuario());
		RelatorioDeHoras relatorioDeHoras = new RelatorioDeHoras(horas);
		result.include("relatorio", relatorioDeHoras);
	}
}
