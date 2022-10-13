package editor.figure;

import java.awt.Point;
import java.util.List;

public interface Figure {
	public void dibujar();

	public void mover(int x, int y );

	public boolean select(int x,int y);


	

}
