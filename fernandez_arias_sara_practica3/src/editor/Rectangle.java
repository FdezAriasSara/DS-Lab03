package editor;

import java.awt.Point;

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
	public boolean select(int x, int y) {
		return (esquina.x <= x && x <= esquina.x + ancho) && (esquina.y <= y && y <= esquina.y + alto);
		
	}
	
	
}

