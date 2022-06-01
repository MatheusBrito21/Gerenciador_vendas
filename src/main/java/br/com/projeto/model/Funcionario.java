package br.com.projeto.model;

import javax.persistence.Entity;

@Entity


public class Funcionario extends Cliente {
	
	 private char[] senha;
	 private String cargo;
	 private String nivel_acesso;
	 
	public Funcionario() {
		super();
	}
	public Funcionario(String nome, String rg, String cpf, String email, String telefone, String celular, String cep,
			String endereco, int numero, String complemento, String bairro, String cidade, String estado) {
		super(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado);
		
	}
	public char[] getSenha() {
		return senha;
	}
	public void setSenha(char[] cs) {
		this.senha = cs;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNivel_acesso() {
		return nivel_acesso;
	}
	public void setNivel_acesso(String nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
	}
	 
	 
}
