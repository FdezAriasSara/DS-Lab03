package editor.tool;

import java.awt.Point;

import editor.Editor;
import editor.figure.Triangle;

public class TriangleCreationTool extends FigureCreationTool {
	private Point[] vertices;

	public TriangleCreationTool(Editor editor) {
		super(editor);
		vertices=new Point[3];
		
	}
	@Override
	public void click(int x, int y) {
		int numberOfElements=vertices.length;
		if(numberOfElements<3) {
			vertices[numberOfElements-1]=new Point(x,y);
			
		}
		editor.addFigure(new Triangle(vertices[0],vertices[1],vertices[2]));
		editor.toolFinished();
	}

	

}
