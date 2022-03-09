package main;

import java.util.UUID;

public class Pessoa {
	private String primeiroNome;
	private String ultimoNome;
	private int idade;
	private double saldo;
	private UUID id;
	
	public Pessoa(String primeiroNome, String ultimoNome, int idade, double saldo) {
		super();
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.idade = idade;
		this.saldo = saldo;
		id = UUID.randomUUID();
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Pessoa [primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", idade=" + idade + ", saldo="
				+ saldo + ", id=" + id + "]";
	}
	
	
	
	
}
