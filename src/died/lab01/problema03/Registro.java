package died.lab01.problema03;


import died.lab01.problema02.*;

public class Registro {
	
	private String ciudad;
	private Temperatura[] historico;
	private int capacidadMaxima;
	private int registros;
	
	//CONSTRUCTORS
	public Registro() {
		this.ciudad="-";
		this.historico = new Temperatura[100];
		this.capacidadMaxima=100;
		this.registros=0;
	}
	public Registro(String ciudad) {
		this.ciudad=ciudad;
		this.historico = new Temperatura[100];
		this.capacidadMaxima=100;
		this.registros=0;
	}
	
	//METHODS
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public void imprimir() {
		System.out.println("TEMPERATURAS REGISTRADAS EN "+this.ciudad);
		
		int i;
		for(i=0;i<this.registros;i++) {
			System.out.println((i+1)+") "+this.historico[i].toString());
		}
	}
	
	public void agregar(Temperatura t) {
		
		if(this.registros == this.capacidadMaxima) {return;}
		this.historico[this.registros++]=t;
	}
	
	public Temperatura totalAsCelcius() {
		Temperatura aux = new Temperatura(0.0,Escala.CELCIUS);
		for(int i=0; i<this.registros;i++) {
			aux.aumentar(this.historico[i]);
		}
		
		return aux;
	}
	
	public Temperatura totalAsFahrenheit() {
		Temperatura aux = new Temperatura(0.0,Escala.FAHRENHEIT);
		for(int i=0; i<this.registros;i++) {
			aux.aumentar(this.historico[i]);
		}
		
		return aux;
	}
	
	public Temperatura MediaAsCelcius() {
		Temperatura aux = this.totalAsCelcius();
		
		return new Temperatura(aux.getGrados()/this.registros,aux.getEscala());
	}
	
	public Temperatura MediaAsFahrenheit() {
		Temperatura aux = this.totalAsFahrenheit();
		
		return new Temperatura(aux.getGrados()/this.registros,aux.getEscala());
	}
	
	public Temperatura maximo() {
		Temperatura max= this.historico[0];
		int i=1;
		return maxTemp(max,i);
	}
	
	private Temperatura maxTemp(Temperatura max, int index) {
		if(index == this.registros) return max;
		
		if(max.lessThan(this.historico[index]))
			return this.maxTemp(this.historico[index], index+1);
		
		return this.maxTemp(max, index+1);
	}
	
}
