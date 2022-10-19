package main;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

import editor.*;
import editor.figure.Circle;
import editor.figure.Rectangle;
import editor.figure.Triangle;
import editor.tool.CircleCreationTool;
import editor.tool.RectangleCreationTool;
import editor.tool.SelectionTool;
import editor.tool.Tool;
import editor.tool.TriangleCreationTool;

public class Main {
	private static Editor editor;
	private boolean exit;
	private BufferedReader input;
	private PrintStream output;
	private static Map<String, Tool> tools = new HashMap<>();
	public static void main(String[] args) throws IOException {
		initializeTools();
		new Main().run();
	}
	private static void addTool(String key, Tool tool) {
		tools.put(key, tool);
	}
	static void initializeTools()
	{
		addTool("seleccion", new SelectionTool(editor));
		addTool("rectangulo", new RectangleCreationTool(editor));
		addTool("circulo", new CircleCreationTool(editor));
		addTool("triangulo", new TriangleCreationTool(editor));
	}
	public void run() throws IOException {
		editor = new Editor(new Drawing());
		input = new BufferedReader(new InputStreamReader(System.in));
		output = System.out;

		showHelp();
		while (!exit) {
			askUser();
		}
		output.println("¡Adios!");
		return;
	}

	private void showHelp() {
		output.println("");
		output.println("Herramientas: seleccion - rectangulo - circulo - triangulo");
		output.println("Acciones del ratón: pulsar <x>,<y> - mover <x>,<y> - soltar");
		output.println("Otras acciones: dibujar - ayuda - salir");
		output.println("-----------------------------------------------------------");
	}

	private void askUser() throws IOException {
		output.print("> ");
		output.flush();
		String[] tokens = input.readLine().split("[ ]", 2);
		String action = tokens[0];

		// Comprueba que a las acciones que no requieren parámetros, efectivamente no se
		// les
		// pase ninguno (por usabilidad, para que el usuario se dé cuenta de que la
		// última
		// acción no funciona como él esperaba). Por ejemplo, si por equivocación
		// tecleó:
		//
		// "soltar 200, 345"
		//
		// cuando realmente esas coordenadas no son tenidas en cuenta (se debería haber
		// llamado previamente a "mover 200, 345" y luego simplemente "soltar").
		//
		if (action.equals("seleccion") || action.equals("rectangulo") || action.equals("circulo")
				|| action.equals("triangulo") || action.equals("soltar") || action.equals("dibujar")
				|| action.equals("ayuda") || action.equals("salir")) {
			if (tokens.length > 1) {
				output.printf("Error de sintaxis: \"%s\" no tiene parámetros\n", action);
				return;
			}
		}

		if (action.equals("salir")) {
			exit = true;
		} else if (action.equals("seleccion")) {
			editor.release();
		} else if (action.equals("rectangulo")) {
			editor.selectTool(tools.get("rectangulo"));
		} else if (action.equals("circulo")) {
			editor.selectTool(tools.get("circulo"));
		} else if (action.equals("triangulo")) {
			editor.selectTool(tools.get("triangulo"));
		} else if (action.equals("pulsar")) {
			click(tokens);
		} else if (action.equals("mover")) {
			move(tokens);
		} else if (action.equals("soltar")) {
			editor.release();
		} else if (action.equals("dibujar")) {
			editor.drawDocument();
		} else if (action.equals("ayuda")) {
			showHelp();
		} else {
			output.println("Acción desconocida");
			showHelp();
		}
	}

	private void click(String[] tokens) {
		try {
			// la siguiente línea es para que funcione independientemente de si las
			// coordenadas
			// están separadas sólo por una coma o si hay espacios entre los números y la
			// coma
			String[] arguments = tokens[1].split("\\s*,\\s*");
			int x = Integer.parseInt(arguments[0]);
			int y = Integer.parseInt(arguments[1]);
			editor.click(x, y);
		} catch (NumberFormatException e) {
			output.println(
					"Error de sintaxis: se esperaban las coordenadas del punto en que se hizo clic: pulsar <x>, <y>");
		}
	}

	private void move(String[] tokens) {
		try {
			// la siguiente línea es para que funcione independientemente de si las
			// coordenadas
			// están separadas sólo por una coma o si hay espacios entre los números y la
			// coma
			String[] arguments = tokens[1].split("\\s*,\\s*");
			int x = Integer.parseInt(arguments[0]);
			int y = Integer.parseInt(arguments[1]);
			editor.move(x, y);
		} catch (NumberFormatException e) {
			output.println(
					"Error de sintaxis: se esperaban las coordenadas del punto adonde se movió el cursor: mover <x>, <y>");
		}
	}
}
