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
	
	public double convertirCelsiusAFarenheit(double valor) {
		return this.valor = (valor * 1.8 + 32); 
    }

    public double convertirCelsiusAKelvin(double valor) {
        return this.valor = (valor + 273.15);
    }

    public double convertirFahrenheitACelsius(double valor) {
        return this.valor = (valor - 32 ) / 1.8;
    }

    public double convertirFahrenheitAKelvin(double valor) {
       
        return this.valor = (valor - 32) * 5/9  + 273.15;
    }

    public double convertirKelvinACelsius(double valor) {
        return this.valor = (valor - 273.15);
    }

    public double convertirKelvinAFarenheit(double valor) {
        return this.valor = ((valor - 273.15) * 1.8)  + 32 ;
    }

	public void setValor(double valor) {
		this.valor = valor;
	}

    
    
}
