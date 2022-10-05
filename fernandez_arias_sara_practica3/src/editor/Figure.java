package editor;

import java.awt.Point;
import java.util.List;

public interface Figure {
	public void dibujar();

	public void mover(Point nextPosition);

	public boolean select(Point posicion);

	public void create(List<Point> points);
	

}
