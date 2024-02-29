package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import objetos.Comparador;
import objetos.Entrenador;
import objetos.Jugador;

public class GestorPrincipal {
	
	public void run() {
		
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		GestorBBDD gestorbbdd = new GestorBBDD();
		
		do {
			Menu.menuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.MENU_JUGADORES:
				System.out.println("Has entrado al menu de jugadores");
				
				Menu.menuJugadores();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				case Menu.VER_TODOS_JUGADORES:
					gestorbbdd.conectar();
					ArrayList<Jugador> jugadores = gestorbbdd.getJugadores();
					Visor.mostrarJugadores(jugadores);
					gestorbbdd.cerrar();
					break;
				
				case Menu.INSERTAR_JUGADORES:
					gestorbbdd.conectar();
					Jugador jugador = Formulario.introducirDatosJugador(scan);
					gestorbbdd.insertarJugadores(jugador);
					gestorbbdd.cerrar();
					break;
					
				case Menu.ELIMINAR_JUGADORES:
					gestorbbdd.conectar();
					jugadores = gestorbbdd.getJugadores();
					Visor.mostrarJugadores(jugadores);
					
					String dniJugador = Formulario.eliminarJugador(scan);
					gestorbbdd.eliminarJugador(dniJugador);
					
					gestorbbdd.cerrar();
					break;
					
				case Menu.MODIFICAR_JUGADORES:
					gestorbbdd.conectar();
					
					jugadores = gestorbbdd.getJugadores();
					Visor.mostrarJugadores(jugadores);
					
					dniJugador = Formulario.getDniJugador(scan);
					jugador = Formulario.modificarDatosJugador(scan);
					gestorbbdd.modificarJugador(dniJugador, jugador);
					
					gestorbbdd.cerrar();
					break;
					
				case Menu.VER_JUGADORES_X_ENTRENADOR:
					gestorbbdd.conectar();
					jugadores =	gestorbbdd.getJugadoresXEntrenador(Formulario.getDniJugador(scan));
					gestorbbdd.cerrar();
					Visor.mostrarJugadores(jugadores);
					break;

				case Menu.ORDENAR_X_FECHA:
					gestorbbdd.conectar();
					jugadores = gestorbbdd.getJugadores();
					jugadores.sort(new Comparador());
					Visor.mostrarJugadores(jugadores);
					gestorbbdd.cerrar();
					break;
				
				case Menu.ELIMINAR_JUGADORES_X_FECHA:
					gestorbbdd.conectar();
					
					jugadores = gestorbbdd.getJugadores();
					Visor.mostrarJugadores(jugadores);
					
					Iterator<Jugador> it = jugadores.iterator();
				    jugador = new Jugador();
					while(it.hasNext()) {
						
					}
					
					gestorbbdd.cerrar();
					break;
					
				default:
					break;
				}
				break;

			case Menu.MENU_ENTRENADORES:
				System.out.println("Has entrado al menu de entrenadores");
				
				Menu.menuEntrenadores();
				opcion = Integer.parseInt(scan.nextLine());
				
				switch (opcion) {
				case Menu.VER_TODOS_ENTRENADORES:
					gestorbbdd.conectar();
					ArrayList<Entrenador> entrenadores = gestorbbdd.getEntrenadores();
					gestorbbdd.cerrar();
					Visor.mostrarEntrenadores(entrenadores);
					break;
				
				case Menu.INSERTAR_ENTRENADORES:
					gestorbbdd.conectar();
					gestorbbdd.insertarEntrenador(Formulario.introducirDatosEntrenador(scan));
					gestorbbdd.cerrar();
					break;
					
				case Menu.ELIMINAR_ENTRENADORES:
					gestorbbdd.conectar();
					gestorbbdd.eliminarEntrenador(Formulario.eliminarEntrenador(scan));
					gestorbbdd.cerrar();
					break;
					
				case Menu.MODIFICAR_ENTRENADORES:
					gestorbbdd.conectar();
					
					//mostrar arraylist de entrenadores
					entrenadores = gestorbbdd.getEntrenadores();
					Visor.mostrarEntrenadores(entrenadores);
					
					//usuario elige un entrenador a modificar
					String dniEntrenador = Formulario.getDniJugador(scan);
					Entrenador entrenador2 = gestorbbdd.getEntrenador(dniEntrenador);
					//modificar entrenador
					Entrenador entrenador = Formulario.modificarDatosEntrenador(scan);
					gestorbbdd.modificarEntrenador(entrenador, entrenador2);
					
					Visor.mostrarEntrenadores(gestorbbdd.getEntrenadores());
					gestorbbdd.cerrar();
					break;
					
				case Menu.ORDENAR_X_FECHA:
					gestorbbdd.conectar();
					entrenadores = gestorbbdd.getEntrenadores();
					Visor.mostrarEntrenadoresXExperiencia(entrenadores);
					gestorbbdd.cerrar();
					break;
					
				default:
					break;
				}
				break;
				
			default:
				break;
			}
			
		}while(Menu.SALIR != opcion );
	}
}
