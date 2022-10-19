package editor;

import editor.figure.Figure;
import editor.tool.SelectionTool;
import editor.tool.Tool;

public class Editor {


	
	private Drawing drawing;
	private Tool currentTool;

	public Editor() {
		setDrawing(new Drawing());
		currentTool = new SelectionTool(this);

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

	private void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void drawDocument()


	{
		System.out.println("Herramieta seleccionada : "+currentTool.toString());
		drawing.draw();
		//toolFinished() its better that the tool itself decides when to be finished
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
