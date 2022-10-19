package editor.tool;

import java.awt.Point;

import editor.Editor;
import editor.figure.Triangle;

public class TriangleCreationTool extends FigureCreationTool {
	private static final int VERTICES = 3;
	private Point[] vertices;
	private int verticesLeft;
	public TriangleCreationTool(Editor editor) {
		super(editor);
		vertices=new Point[VERTICES];
		this.verticesLeft=VERTICES;
	}
	@Override
	public void click(int x, int y) {
		
		if(verticesLeft>0) {
			
			vertices[verticesLeft-1]=new Point(x,y);
			--verticesLeft;
			
		}else {
			editor.addFigure(new Triangle(vertices[0],vertices[1],vertices[2]));
			editor.toolFinished();
		}
		
	}

	@Override
	public String toString() {
		
		return "Triangulo";
	}

}
