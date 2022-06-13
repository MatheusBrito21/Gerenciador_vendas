package br.com.projeto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Entidade que armazena uma lista de Itens de produto, referenciando o cliente que realizou a compra

public class Venda {

//	  id int auto_increment primary key,
//	  cliente_id int,
//	  data_venda datetime,
//	  total_venda decimal (10,2),
//	  observacoes text,

	//Define o id e a estratégia de geração de valor
		//Identity -> cada instancia tera um valor único e sequencial
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		//define que a coluna não aceita valores nulos
		@Column(nullable = false)
		private Date data;
		
		
		@OneToMany(mappedBy = "venda")
		private List<Item_venda> itens;
		
		
		public Venda() {
			
		}
		
		public Venda(Date data) {
			this.data = data;
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
		
		
	
	
}
