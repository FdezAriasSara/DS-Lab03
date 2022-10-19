package editor.tool;

import java.awt.Point;

import editor.Editor;
import editor.figure.Rectangle;

public class RectangleCreationTool implements Tool {
	private Point upperDiagonalVertex;
	private int lastX,lastY;
	private Editor editor;
	public RectangleCreationTool(Editor editor) {
		this.editor=editor;
	}

	@Override
	public void click(int x, int y) {
		this.upperDiagonalVertex=new Point(x,y);
				

	}

	@Override
	public void moveTo(int x, int y) {
		this.lastX=x;
		this.lastY=y;
	}

	@Override
	public void release() {
		int height=lastY-upperDiagonalVertex.y;
		int width=lastX-upperDiagonalVertex.x;
		editor.addFigure(new Rectangle(upperDiagonalVertex,height,width ));
		editor.toolFinished();
	}

}
