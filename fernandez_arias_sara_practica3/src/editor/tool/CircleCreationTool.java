package editor.tool;

import java.awt.Point;

import editor.Editor;
import editor.figure.Circle;

public class CircleCreationTool implements Tool {
	private Point center;
	private int lastX;
	private Editor editor;

	public CircleCreationTool(Editor editor) {
		this.editor=editor;
	}

	@Override
	public void click(int x, int y) {
		this.center=new Point(x,y);

	}

	@Override
	public void moveTo(int x, int y) {
		this.lastX=x;
	

	}

	@Override
	public void release() {
		int radius=lastX-center.x;
		editor.addFigure(new Circle(center,radius));
		editor.toolFinished();

	}

}
