package editor.tool;

import editor.Editor;

public abstract class FigureCreationTool implements Tool 
{
	protected Editor editor;
	public FigureCreationTool(Editor editor) {
		this.editor=editor;
	}
	@Override
	public void click(int x, int y ) {
		//base implementation
	}
	@Override
	public void moveTo(int x, int y) {
		//base implementation

	}
	@Override
	public void release() {
		//base implementation
		

	}
}
