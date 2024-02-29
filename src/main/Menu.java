package main;

public class Menu {
	
	static final int SALIR = 0;
	
	//menuPrincipal
	static final int MENU_JUGADORES = 1;
	public static final int MENU_ENTRENADORES = 2;
	
	//menuJugadores
	public static final int VER_TODOS_JUGADORES = 1;
	public static final int INSERTAR_JUGADORES = 2;
	public static final int ELIMINAR_JUGADORES = 3;
	public static final int MODIFICAR_JUGADORES = 4;
	public static final int VER_JUGADORES_X_ENTRENADOR = 5;
	public static final int ORDENAR_X_FECHA = 6;
	public static final int ELIMINAR_JUGADORES_X_FECHA = 7;
	
	//menuEntrenadores 
	public static final int VER_TODOS_ENTRENADORES = 1;
	public static final int INSERTAR_ENTRENADORES = 2;
	public static final int ELIMINAR_ENTRENADORES = 3;
	public static final int MODIFICAR_ENTRENADORES = 4;
	public static final int MOSTRAR_X_EXPERIENCIA = 5;

	
	public static void menuPrincipal() {
		System.out.println("--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(MENU_JUGADORES + "- Menu de jugadores");
		System.out.println(MENU_ENTRENADORES + "- Menu de entrenadores");
	}
	
	public static void menuJugadores() {
		System.out.println("--MENU--");
		System.out.println(VER_TODOS_JUGADORES + "- Ver todos los jugadores");
		System.out.println(INSERTAR_JUGADORES + "- Insertar jugadores");
		System.out.println(ELIMINAR_JUGADORES + "- Eliminar jugadores");
		System.out.println(MODIFICAR_JUGADORES + "- Modificar jugadores");
		System.out.println(VER_JUGADORES_X_ENTRENADOR + "- Ver todos los jugadores entrenados por un entrenador");
		System.out.println(ORDENAR_X_FECHA + "- Ordenar por fecha de nacimientos");
		System.out.println(ELIMINAR_JUGADORES_X_FECHA + "- Eliminar jugadores con la fecha de nacimiento anterior a 2003");
	}
	
	public static void menuEntrenadores() {
		System.out.println("--MENU--");
		System.out.println(VER_TODOS_ENTRENADORES + "- Ver todos los entrenadores");
		System.out.println(INSERTAR_ENTRENADORES + "- Insertar entrenadores");
		System.out.println(ELIMINAR_ENTRENADORES + "- Eliminar entrenadores");
		System.out.println(MODIFICAR_ENTRENADORES + "- Modificar entrenadores");
		System.out.println(MOSTRAR_X_EXPERIENCIA + "- Mostrar entrenadores con mas de 20 años de experiencia");

	}
}
