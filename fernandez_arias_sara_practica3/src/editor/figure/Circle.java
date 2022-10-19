package editor.figure;

import java.awt.Point;
import java.util.List;

public class Circle implements Figure {
	private int radio;
	private Point centro;

	public Circle(Point center, int radius) {
		this.centro=center;
		this.radio=radius;
	}

	@Override
	public void dibujar() {
		System.out.println(String.format("	-Círculo : (%d,%d), radio= %d", centro.x, centro.y, radio));

	}

	@Override
	public void mover(int x , int y) {
		this.centro = new Point(x,y);

	}

	@Override
	public boolean select(int x , int y) {
		Point posicion=new Point(x,y);
		double distancia = Math.sqrt(Math.pow(posicion.x - centro.x, 2) + Math.pow(posicion.y - centro.y, 2));
		return distancia < radio;

	}

	
	

}
