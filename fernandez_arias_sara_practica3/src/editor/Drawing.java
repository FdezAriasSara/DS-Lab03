package editor;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Drawing {
	private List<Figure> figures;

	public Drawing() {
		this.figures = new ArrayList<>();
	}

	public void addFigure(Figure figure) {
		this.figures.add(figure);
	}

	public void draw() {
		figures.forEach(figure -> figure.dibujar());
		
	}

	public Figure figureAt(int x, int y) {
		Figure found;
		try {
			found = figures.stream().filter(figure -> figure.select(x, y)).findFirst().get();
		} catch (NoSuchElementException e) {
			found = null;
		}
		return found;

	}
}
