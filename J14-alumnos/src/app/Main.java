package app;

import vista.MenuPrincipal;
import vista.swing.VInicial;

public class Main {
	public static void main(String[] args) {
		
		if (args.length > 0 && args[0].equalsIgnoreCase("consola"))
			new MenuPrincipal();
		else
			new VInicial();
	}
}
