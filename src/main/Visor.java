package main;

import java.util.ArrayList;

import objetos.Entrenador;
import objetos.Jugador;

public class Visor {
	
	public static void mostrarJugadores(ArrayList<Jugador> jugadores) {
		
		for (Jugador jugador : jugadores) {
			System.out.println(jugador);
		}
	}
	
	public static void mostrarEntrenadores(ArrayList<Entrenador> entrenadores) {
		
		for (Entrenador entrenador : entrenadores) {
			System.out.println(entrenador);
		}
	}	
	
	public static void mostrarEntrenadoresXExperiencia(ArrayList<Entrenador> entrenadores) {
		for (Entrenador entrenador : entrenadores) {
			if(entrenador.getAnos_experiencia() > 20) {
				System.out.println(entrenador);
			}else {
				System.out.println("No hay entrenadores con mas de 20 años de experiencia");
			}
		}
	}
	
}
