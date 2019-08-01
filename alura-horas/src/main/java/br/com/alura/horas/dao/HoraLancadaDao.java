package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.modelos.Usuario;

public class HoraLancadaDao {

	private EntityManager manager;

	@Inject
	public HoraLancadaDao(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	public HoraLancadaDao() {
	}

	public List<HoraLancada> lista() {
		String jpql = "select h from HoraLancada h";
		TypedQuery<HoraLancada> query = manager.createQuery(jpql, HoraLancada.class);
		return query.getResultList();
	}

	public void adiciona(HoraLancada horaLancada) {
		manager.getTransaction().begin();
		manager.persist(horaLancada);
		manager.getTransaction().commit();
	}

	public List<HoraLancada> horasDoUsuario(Usuario usuario) {
		String jpql = "select h from HoraLancada h where h.usuario = :pUsuario order by h.data";
		TypedQuery<HoraLancada> query = manager.createQuery(jpql, HoraLancada.class);
		query.setParameter("pUsuario", usuario);
		return query.getResultList();
	}
}
