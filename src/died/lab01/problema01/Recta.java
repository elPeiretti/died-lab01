package died.lab01.problema01;

public class Recta {

		private Punto p1;
		private Punto p2;
	
		public Recta(Punto p1, Punto p2) {
			this.p1 = p1; 
			this.p2 = p2;
			
			/* si no quisiera usar los mismos objetos
			 * this.p1.setX(p1.getX());
			 * this.p1.setY(p1.getY());
			 * this.p2.setX(p2.getX());
			 * this.p2.setY(p2.getY());
			 */
		}
		public Recta() {
			this.p1.setX(0);
			this.p1.setY(0);
			this.p2.setX(1);
			this.p2.setY(1);
		}
		
		public Punto getP1() {
			return this.p1;
		}
		
		public Punto getP2() {
			return this.p2;
		}
		
		public float pendiente() {
			float x1,x2,y1,y2;
			x1=this.p1.getX();
			x2=this.p2.getX();
			y1=this.p1.getY();
			y2=this.p2.getY();
			
			return (y2-y1)/(x2-x1);
		}
		
		public boolean paralelas(Recta otraRecta) {
			return this.pendiente() == otraRecta.pendiente();
		}
		
		public boolean equals(Object otraRecta) {
			
			
			if(otraRecta instanceof Recta) {
				Punto otroP1 = ((Recta)otraRecta).getP1();
				Recta Raux;
				
				if(otroP1.esMenorX(this.p1)) {
					Raux = new Recta(otroP1,this.p1);
				}
				else {
					Raux = new Recta(this.p1,otroP1);
				}
				
				
				if(Raux.pendiente() == this.pendiente() && Raux.pendiente() == ((Recta)otraRecta).pendiente()) {
					return true;
				}
			}
			
			return false;
		}
}
