package br.com.alura.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

import br.com.alura.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDao {
	private EntityManager manager;
	
	@Inject
	public UsuarioDao(EntityManager manager){
		this.manager = manager;
	}
	
	public UsuarioDao(){}
	
	public void adicionar(Usuario usuario){
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}
		
	public List<Usuario> lista(){
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        
        return query.getResultList();
    }
	
		
	public void remover(Usuario usuario) {
		manager.getTransaction().begin();
		manager.remove(busca(usuario));
		manager.getTransaction().commit();
	}
	
	public Usuario busca(Usuario usuario) {
		return manager.find(Usuario.class, usuario.getId());
	}
	
	public void atualizar(Usuario usuario) {
		manager.getTransaction().begin();
		Usuario atualizarUsuario = manager.find(Usuario.class, usuario.getId());
		
		atualizarUsuario.setNome(usuario.getNome());
		atualizarUsuario.setLogin(usuario.getLogin());
		atualizarUsuario.setEmail(usuario.getEmail());
		atualizarUsuario.setSenha(usuario.getSenha());
		manager.getTransaction().commit();
	}
	
	public Usuario buscaLogin(String login, String senha) {
		String jpql = "select u from Usuario u where u.login = :pLogin and u.senha = :pSenha";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		
		query.setParameter("pLogin", login);
		query.setParameter("pSenha", senha);
	
		return query.getSingleResult();
	}
}
