package editor.figure;

import java.awt.Point;
import java.util.List;

public class Rectangle implements Figure {
	private Point esquina;
	private int ancho,alto;
	public Rectangle(Point esquina, int alto , int ancho) {
		this.esquina=esquina;
		this.alto=alto;
		this.ancho=ancho;
	}

	@Override
	public void dibujar() {
		System.out.println(String.format("	-Rectángulo:(%d,%d) ancho=%d alto=%d ",esquina.x,esquina.y,ancho,alto));


	}

	@Override
	public void mover(int x, int y) {
		this.esquina=new Point(x,y);

	}


	@Override
	public boolean select(int x, int y) {
		Point posicion=new Point(x,y);
		return (esquina.x <= posicion.x && posicion.x <= esquina.x + ancho) && (esquina.y <= posicion.y && posicion.y <= esquina.y + alto);
		
	}

	
	
	
	
}

