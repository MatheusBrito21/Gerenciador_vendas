package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	//parametro de conexao
	static {
		try {
			emf = Persistence.createEntityManagerFactory("MinionDB");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public DAO() {
		// construtor nulo
	}
	
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();

	}
	
	public DAO<E> teste() {
		return this;
	}
	
	public DAO<E> abriT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		return this.abriT().incluir(entidade).fecharT();
	}
	
	public List<E> obterTodos(int qtd,int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}else {
			String jpql = "select e from " + classe.getName()+" e";
			TypedQuery<E> query = em.createQuery(jpql, classe);
			query.setMaxResults(qtd);
			query.setFirstResult(deslocamento);
		return query.getResultList();
		}
	}
	
	public List<E> obterTodosP(){
		return this.obterTodos(10, 0);
	}
	
	
	
	
	
}
