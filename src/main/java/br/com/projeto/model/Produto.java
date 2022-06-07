package br.com.projeto.model;

//@Entity
public class Produto {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	int id_fornecedor;
	String nome;
	double preco;
	int qtd_estoque;
	
	public Produto(String nome, double preco, int qtd_estoque) {
		this.nome = nome;
		this.preco = preco;
		this.qtd_estoque = qtd_estoque;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
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
	
	
	
}
