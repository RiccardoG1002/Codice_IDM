package test;

public class Dipendente {

	private double salario;
	private String nome;
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Dipendente(double salario, String nome) {
		super();
		this.salario = salario;
		this.nome = nome;
	}
	
	
}
