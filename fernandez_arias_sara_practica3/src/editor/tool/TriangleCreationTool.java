package editor.tool;

import java.awt.Point;

import editor.Editor;

public class TriangleCreationTool implements Tool {
	private Point[] vertices;
	private Editor editor;
	public TriangleCreationTool(Editor editor) {
		vertices=new Point[3];
		this.editor=editor;
	}
	@Override
	public void click(int x, int y) {
		int numberOfElements=vertices.length;
		if(numberOfElements<3) {
			vertices[numberOfElements-1]=new Point(x,y);
			
		}
		editor.toolFinished();
	}

	@Override
	public void moveTo(int x, int y) {
		// does nothing

	}

	@Override
	public void release() {
		// does nothing
		

	}

}
