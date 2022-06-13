package br.com.projeto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity

@NamedQueries({
		
		@NamedQuery(name = "consultarProdPorNome",
		query ="select p from Produto p where p.nome like :nome"),
		
		//seleciona a partir do Id
		@NamedQuery(name = "consultarProdPorId",
		query = "select p from Produto p where p.id = :id")
		
})

public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String nome;
	private double preco;
	private int qtd_estoque;
	@OneToOne(cascade = CascadeType.DETACH)
	private Fornecedor fornecedor;
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, double preco, int qtd_estoque, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.qtd_estoque = qtd_estoque;
		this.fornecedor = fornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
	
	
}
