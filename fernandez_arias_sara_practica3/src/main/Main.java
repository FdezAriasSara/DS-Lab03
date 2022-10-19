package main;


import java.io.IOException;

import editor.Editor;
import editor.tool.CircleCreationTool;
import editor.tool.RectangleCreationTool;
import editor.tool.SelectionTool;
import editor.tool.TriangleCreationTool;
import editor.ui.Menu;


public class Main 
{
	public static void main(String[] args) throws IOException
	{
		Editor editor = new Editor();
		Menu menu = new Menu(editor);
		
		//-- Se registran las distintas herramientas
		menu.addTool("seleccion", new SelectionTool(editor));
		menu.addTool("rectangulo", new RectangleCreationTool(editor));
		menu.addTool("circulo", new CircleCreationTool(editor));
		menu.addTool("triangulo", new TriangleCreationTool(editor));
		
		menu.run();
	}
}
