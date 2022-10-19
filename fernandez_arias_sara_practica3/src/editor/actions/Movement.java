package editor.actions;

import editor.tool.Tool;

public class Movement implements Action {
	private int x,y;//movement
	private Tool tool;
	public Movement(int x, int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public void undo() {
		tool.moveTo(-x, -y);
		

	}

	@Override
	public void redo() {
		tool.moveTo(x, y);

	}

}
