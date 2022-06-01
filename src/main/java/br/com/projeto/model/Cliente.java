package br.com.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		//seleciona a partir do nome da Entidade, nao da tabela
		//Cliente != cliente;
		@NamedQuery(name = "consultarPorNome",
		query ="select c from Cliente c where c.nome like :nome"),
		
		//seleciona a partir do Id
		@NamedQuery(name = "consultarPorId",
		query = "select c from Cliente c where c.id = :id"),
		
		@NamedQuery(name = "consultarFuncPorNome",
		query ="select f from Funcionario f where f.nome like :nome"),
		
		//seleciona a partir do Id
		@NamedQuery(name = "consultarFuncPorId",
		query = "select f from Funcionario f where f.id = :id"),
		
		//seleciona a partir do Id
		@NamedQuery(name = "consultarFuncPorEmail",
		query = "select f from Funcionario f where f.email = :email"),
})

@Inheritance(strategy = InheritanceType.JOINED)

public class Cliente {
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  private String nome;
	  private String rg;
	  private String cpf;
	  private String  email;
	  private String  telefone;
	  private String celular;
	  private String  cep;
	  private String endereco;
	  private Integer numero;
	  private String complemento;
	  private String bairro;
	  private String cidade;
	  private String estado;
	
	  public Cliente() {
		  
	  }
	  
	  public Cliente(String nome, String rg, String cpf, String email, String telefone, String celular, String cep,
			String endereco, int numero, String complemento, String bairro, String cidade, String estado) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
				+ ", celular=" + celular + ", cep=" + cep + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ "]";
	}
	  
	  
	  
	  
}
