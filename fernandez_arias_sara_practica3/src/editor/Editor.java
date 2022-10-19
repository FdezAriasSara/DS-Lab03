package editor;

import java.util.Stack;

import editor.actions.Action;
import editor.actions.FigureCreation;
import editor.actions.Movement;
import editor.figure.Figure;
import editor.tool.SelectionTool;
import editor.tool.Tool;

public class Editor {


	
	private Drawing drawing;
	private Tool currentTool;
	private Stack<Action> undoRecord, redoRecord;
	public Editor() {
		setDrawing(new Drawing());
		currentTool = new SelectionTool(this);
		this.undoRecord=new Stack<>();
		this.redoRecord=new Stack<>();

	}
	public void undo() {
		Action action=undoRecord.pop();
		action.undo();
		redoRecord.add(action);
	}
	public void redo() {
		Action action=redoRecord.pop();
		action.redo();
		undoRecord.add(action);
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
		undoRecord.add(new FigureCreation(figure, this));
		drawing.addFigure(figure);
	}

	public void removeFigure(Figure figure) {
		 drawing.removeFigure(figure);
	 }
	public void click(int x, int y) {

		currentTool.click(x, y);
	}

	public void move(int x, int y) {
		undoRecord.add(new Movement(x,y));
		currentTool.moveTo(x, y);

	}
	
	public void release() {
		currentTool.release();

	}

	

}
