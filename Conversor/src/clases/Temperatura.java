package clases;

public class Temperatura {

	private String nombre;
	private String simbolo;
	private double valor;
	
	public Temperatura(String nombre, String simbolo, double valor) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public double getValor() {
		return valor;
	}
	
	public double multiplicar(double numero) {
	    return this.valor * numero;
	}

	public double dividir(double numero) {
		return this.valor / numero;
	}
	
	

	
}
