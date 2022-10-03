package editor;

import java.awt.Point;

public interface Figure {
	public void dibujar();
	public void mover(Point nextPosition);
	public boolean contains(int x, int y);
}
