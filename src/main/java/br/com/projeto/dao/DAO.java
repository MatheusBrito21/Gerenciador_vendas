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
	
	public DAO<E> conectar() {
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
	
	public DAO<E> alterar(E entidade){
		return this.abriT().fecharT();
	}
	
	public DAO<E> excluir(E entidade){
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
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
	
	public List<E> consultar(String nomeConsulta, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for(int i = 0; i<params.length; i+=2) {
			query.setParameter(params[i].toString(),params[i+1]);
		}
		return query.getResultList();
	}
	
	
//	public boolean autenticarLogin(String email,char[] senha){
//			String jpql = "select c.email, f.senha from Funcionario f inner join Cliente c "
//			 + "where c.email = '"+email+"'and f.senha = '"+senha.toString()+"'";
//			Query query = em.createQuery(jpql);
//			
//		return query.getResultList().isEmpty();
//	}
	
	
}
