package br.com.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Entidade que armazena uma quantidade X de um produto
@Entity
public class Item_venda {
//	  id int auto_increment primary key,
//	  venda_id int,
//	  produto_id int,
//	  qtd int,
//	  subtotal decimal (10,2),
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qtd;
	private double subtotal;
	
	//relaciona a venda com o pedido
	//Uma venda possui muitos itens
	@ManyToOne
	private Venda venda;
	
	//Um produto esta relacionado a muitos itens
	@ManyToOne
	private Produto produto;
	
	public Item_venda() {
		
	}
	public Item_venda(int qtd, double subtotal, Produto produto) {
		super();
		this.qtd = qtd;
		this.subtotal = subtotal;
		this.produto = produto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	

}
