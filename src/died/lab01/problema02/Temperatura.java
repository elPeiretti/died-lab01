package died.lab01.problema02;

public class Temperatura {
	
	private Double grados;
	private Escala escala;
	
	
	//CONSTRUCTORS
	public Temperatura() {
		this.grados=0d;
		this.escala= Escala.CELCIUS;
	}
	
	public Temperatura(double grad, Escala esc) {
		this.grados=grad;
		this.escala=esc;
	}
	
	//METHODS
	public String toString() {
		
		String ans = this.grados.toString();
		
		switch(this.escala) {
			case CELCIUS:{
				ans+=" °C";
			}
			case FAHRENHEIT:{
				ans+=" °F";
			}
		}
		
		return ans;
	}
	
	public Double asCelcius() {
		if (this.escala == Escala.CELCIUS) {
			return this.grados;
		}
		else {
			return (this.grados-32)*(5.0/9.0);
		}
	}
	
	public Double asFahrenheit() {
		if (this.escala == Escala.CELCIUS) {
			return this.grados*(9.0/5.0)+32;
		}
		else {
			return this.grados;
		}
	}
	
	public void aumentar(Temperatura temperatura) {
		if(temperatura.grados <= 0.0) return;
		
		if(this.escala == temperatura.escala) {
			this.grados+=temperatura.grados;
		}
		else if(this.escala == Escala.CELCIUS){
			this.grados+= temperatura.asCelcius();
		}
		else {
			this.grados+= temperatura.asFahrenheit();
		}
		
	}
	
	public void disminuir(Temperatura temperatura) {
		if(temperatura.grados <= 0.0) return;
		
		if(this.escala == temperatura.escala) {
			this.grados-=temperatura.grados;
		}
		else if(this.escala == Escala.CELCIUS){
			this.grados-= temperatura.asCelcius();
		}
		else {
			this.grados-= temperatura.asFahrenheit();
		}
	}
	
	
	
}
