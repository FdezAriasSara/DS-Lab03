package editor;

import java.awt.Point;
import java.util.List;

public class Rectangle implements Figure {
	private Point esquina;
	private int ancho,alto;
	

	@Override
	public void dibujar() {
		System.out.println(String.format("	-Rectángulo:(%d,%d) ancho=%d alto=%d ",esquina.x,esquina.y,ancho,alto));


	}

	@Override
	public void mover(Point nextPosition) {
		this.esquina=nextPosition;

	}


	@Override
	public boolean select(Point posicion) {
		return (esquina.x <= posicion.x && posicion.x <= esquina.x + ancho) && (esquina.y <= posicion.y && posicion.y <= esquina.y + alto);
		
	}

	@Override
	public void create(List<Point> points) {
		esquina=points.get(0);
		Point esquina2=points.get(1);
		//In software coordinates go from left to right( x axis) 
		ancho=esquina.x-esquina2.x;
		//and downwards(y axis)
		alto=esquina2.y-esquina2.x;
		
	}
	
	
}

