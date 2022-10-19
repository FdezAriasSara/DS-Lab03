package editor.figure;

import java.awt.Point;
import java.util.List;

public class Triangle implements Figure {

	private Point v1, v2, v3;// Los tres vértices del triángulo
	public Triangle(Point v1,Point v2, Point v3) {
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
	}
	@Override
	public void dibujar() {
		System.out.println(String.format("	-Triángulo: (%d,%d), (%d,%d),(%d,%d)",v1.x,v1.y,v2.x,v2.y,v3.x,v3.y));

	}

	@Override
	public void mover(int x, int y ) {
		Point nextPosition=new Point(x,y);
		int x_movement=nextPosition.x-v1.x;
		int y_movement=nextPosition.y-v1.y;
		v1=nextPosition;
		v2=new Point(v2.x+x_movement,v2.y+y_movement);		
		v3=new Point(v3.x+x_movement,v3.y+y_movement);
		
	}

	@Override
	public boolean select(int x,int y ) {
		Point posicion=new Point(x,y);
		return posicion.equals(v1) || posicion.equals(v2) || posicion.equals(v3);
		
	}

	
	
}
