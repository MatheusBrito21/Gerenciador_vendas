package br.com.projeto.model;

import javax.persistence.Entity;

@Entity
public class Fornecedor extends Cliente {

	//atributos especificos
	private String cnpj;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(String nome, String rg, String cpf, String email, String telefone, String celular, String cep,
			String endereco, int numero, String complemento, String bairro, String cidade, String estado) {
		super(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
