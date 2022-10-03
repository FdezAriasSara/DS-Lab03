package editor;

import java.awt.Point;

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
	public boolean select(int x, int y) {
		double distancia = Math.sqrt(Math.pow(x - centro.x, 2) + Math.pow(y - centro.y, 2));
		return distancia < radio;

	}

}
