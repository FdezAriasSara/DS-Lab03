package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Editor {

	private static final int NONE = -1;
	private Drawing drawing;
	private Figure selected,beingCreated;
	private List<Point> points;
	private int lastX, lastY;

	public Editor(Drawing drawing) {
		setDrawing(drawing);
		this.points = new ArrayList<>();

	}

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void drawDocument()
	// "dibujar"
	
	{
		beingCreated.create(points);
		drawing.addFigure(beingCreated);
		drawing.draw();
		selectionTool();//It's the default one!
	}

	public void addFigure(Figure figure) {
		points = new ArrayList<>();
		this.beingCreated=figure;
		// The figure is not included in the drawing straightforward
		// its included when "dibujar" is used ) drawing.addFigure(figure);
	}

	/**
	 * This method will update the record of the coordinates selected. In case the
	 * selection tool is in use,the drawing will be asked to return if there's any
	 * figure in that position. In case it is, it will be the selected one.
	 * 
	 * @param x
	 * @param y
	 */

	public void click(int x, int y) {
		

		if (selected == null) {
			Figure figure = drawing.figureAt(x, y);
			this.selected = figure;
			
		}
		move(x,y);
	}

	/**
	 * This method will update the record of the last coordinates selected.
	 * The figure itself will not be moved until "soltar" is called (and "dibujar" right afterwards) .
	 * 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {

		this.lastX = x;
		this.lastY = y;

	}

	/**
	 * This method will add the last point to the list, if and only if , there's a
	 * figure in process of being created. In case there's a selection, the figure will be moved to the last coordinates the user selected.
	 * Else , it will essentially do nothing.
	 * 
	 */
	public void drop() {
		Point lastPoint = new Point(lastX, lastY);

		if (beingCreated != null) {
			
			if (this.points.contains(lastPoint)) {
				points.add(lastPoint);
			}

		}
		else if(selected!=null) {
			selected.mover(lastPoint);
		}

	}
	/**
	 * This tool essentially resets all attributes to the default value.
	 */

	public void selectionTool() {
		this.selected = null;
		this.beingCreated=null;
		this.points=new ArrayList<>();
		this.lastX = NONE;
		this.lastY = NONE;

	}
}
