package editor;

import java.awt.Point;
import java.util.List;

public class Circle implements Figure {
	private int radio;
	private Point centro;

	@Override
	public void dibujar() {
		System.out.println(String.format("	-Círculo : (%d,%d), radio= %d", centro.x, centro.y, radio));

	}

	@Override
	public void mover(Point nextPosition) {
		this.centro = nextPosition;

	}

	@Override
	public boolean select(Point posicion) {
		double distancia = Math.sqrt(Math.pow(posicion.x - centro.x, 2) + Math.pow(posicion.y - centro.y, 2));
		return distancia < radio;

	}

	@Override
	public void create(List<Point> points) {
		centro=points.get(0);
		radio=points.get(1).x-centro.x;
		
	}

}
