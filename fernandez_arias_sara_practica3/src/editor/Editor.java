package editor;

import editor.figure.Figure;
import editor.tool.SelectionTool;
import editor.tool.Tool;

public class Editor {

	private static final int NONE = -1;
	
	private Drawing drawing;
	private Tool currentTool;

	public Editor(Drawing drawing) {
		setDrawing(drawing);

		currentTool = new SelectionTool(this);

	}
	public Editor() {
		// TODO Auto-generated constructor stub
	}
	public void toolFinished() {
		selectTool(new SelectionTool(this));
	}
	public void selectTool(Tool tool) {
		this.currentTool = tool;
	}

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void drawDocument()


	{
		drawing.draw();
		toolFinished();// We go back to the default tool , selection
	}

	 public void addFigure(Figure figure) {
		drawing.addFigure(figure);
	}

	public void click(int x, int y) {

		currentTool.click(x, y);
	}

	public void move(int x, int y) {
		currentTool.moveTo(x, y);

	}

	public void release() {
		currentTool.release();

	}

	

}
