package editor.tool;

import editor.Editor;
import editor.figure.Figure;

public class SelectionTool implements Tool {
	private Figure selected;
	private Editor editor;
	public SelectionTool(Editor editor) {
		this.editor=editor;
	}

	@Override
	public void click(int x, int y) {
		Figure found=editor.getDrawing().figureAt(x, y);
		if(found!=null) {	
			selected=found;
		}

	}

	@Override
	public void moveTo(int x, int y) {
		if(selected!=null) {
			selected.mover(x,y);
		}
		

	}

	@Override
	public void release() {
		setSelected(null);

	}

	public Figure getSelected() {
		return selected;
	}

	void setSelected(Figure selected) {
		this.selected = selected;
	}

}
