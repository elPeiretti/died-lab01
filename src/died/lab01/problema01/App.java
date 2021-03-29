package died.lab01.problema01;

public class App {

	public static void main(String[] args) {
		
		Punto p1 = new Punto(1,1);
		Punto p2 = new Punto(2,2);
		Recta r1 = new Recta(p1,p2);
		
		System.out.println("pendiente r1 = "+r1.pendiente());
		
		Punto p3 = new Punto(3,3);
		Recta r2 = new Recta(p2,p3);
		
		System.out.println("pendiente r2 = "+r2.pendiente());
		System.out.println("R1 = R2? "+ r1.equals(r2));

	}

}
