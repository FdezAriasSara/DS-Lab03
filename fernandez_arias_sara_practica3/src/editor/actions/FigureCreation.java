package editor.actions;

import editor.Editor;
import editor.figure.Figure;

public class FigureCreation implements Action {
	private Figure figure;
	private Editor editor;
	
	
	
	
	public FigureCreation(Figure figure, Editor editor) {
		this.figure=figure;
		this.editor=editor;
		
	}
	@Override
	public void undo() {
		editor.removeFigure(figure);
		
	}

	@Override
	public void redo() {
		figure.dibujar();
		
	}

}
