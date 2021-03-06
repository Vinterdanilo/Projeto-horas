package br.com.alura.horas.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.alura.horas.modelos.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable{
	
	private Usuario usuario;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void fazLogin(Usuario usuario) {
		this.usuario = usuario;
	}
	public void desloga() {
		this.usuario = null;
	}
	public boolean isLogado() {
		return this.getUsuario() != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
