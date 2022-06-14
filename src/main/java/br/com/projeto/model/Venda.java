package br.com.projeto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//Entidade que armazena uma lista de Itens de produto, referenciando o cliente que realizou a compra
@Entity
public class Venda {

//	  id int auto_increment primary key,
//	  cliente_id int,
//	  data_venda datetime,
//	  total_venda decimal (10,2),


	//Define o id e a estratégia de geração de valor
		//Identity -> cada instancia tera um valor único e sequencial
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		//define que a coluna não aceita valores nulos
		@Column(nullable = false)
		private Date data;
		
		@ManyToOne
		private Cliente cliente;
		
		@OneToMany(mappedBy = "venda")
		private List<Item_venda> itens;
		
		private double total;
		
		
		public Venda() {
			this.data = new Date();
		}
		
		public Venda(Cliente cliente, List<Item_venda> itens, double total) {
			super();
			this.cliente = cliente;
			this.itens = itens;
			this.total = total;
		}


		
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}

		public List<Item_venda> getItens() {
			return itens;
		}

		public void setItens(List<Item_venda> itens) {
			this.itens = itens;
		}
		
		@Override
			public String toString() {
		
				return this.getCliente().getNome()+ " Data:"+ this.getData()+"\n"+
				"Total: R$"+this.getTotal();
				
			}
	
	
}
