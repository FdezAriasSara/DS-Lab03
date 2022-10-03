package editor;

public class Editor 
{	
	
	private static final int NONE = -1;
	private Drawing drawing;
	private Figure selected;
	private int lastX, lastY;
	public Editor(Drawing drawing)
	{
		setDrawing(drawing);
	}
	
	public Drawing getDrawing()
	{
		return drawing;
	}
	
	public void setDrawing(Drawing drawing)
	{
		this.drawing = drawing;
	}
	
	public void drawDocument()
	{
		drawing.draw();
	}	
	public void addFigure(Figure figure) {
		this.selected=figure;
		drawing.addFigure(figure);
	}

	public void click(int x, int y) {
		Figure figure=drawing.figureAt(x,y);
		this.selected=figure;
		
	}

	public void move(int x, int y) {
		this.lastX=x;
		this.lastY=y;
		
	}

	public void drop() {
		if(selected!=null) {
			//TODO : HACER DIAGRAMA DE FLUJO DE DROP
			
		}
		
	}

	public void selectionTool() {
		this.selected=null;
		this.lastX=NONE;
		this.lastY=NONE;
		
	}
}
