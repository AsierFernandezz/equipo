package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import objetos.Entrenador;
import objetos.Jugador;

public class Formulario {
	Scanner scan = new Scanner(System.in);
	
	public static String getDniJugador(Scanner scan) {
		
		String dniJugador;
		
		System.out.println("Introduce el DNI del jugador");
		dniJugador = scan.nextLine();
		
		return dniJugador;
		
	}
	
	public static Jugador introducirDatosJugador(Scanner scan) {
		
		Jugador jugador = new Jugador();
		GestorBBDD gestorbbdd = new GestorBBDD();
		
		System.out.println("Introduce el DNI del jugador");
		jugador.setDni(scan.nextLine());
		
		System.out.println("Introduce el nombre del jugador");
		jugador.setNombre(scan.nextLine());
		
		System.out.println("Introduce el apellido del jugador");
		jugador.setApellido(scan.nextLine());
		
		System.out.println("Introduce el dorsal del jugador");
		jugador.setDorsal(Integer.parseInt(scan.nextLine()));
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Introduce la fecha de nacimiento del jugador(dd/MM/yyyy)");
			jugador.setFecha_nacimiento(sdf.parse(scan.nextLine()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Introduce el DNI del entrenador");
		String dniEscrito = scan.nextLine();
		jugador.setEntrenador(gestorbbdd.getEntrenadorDNI(dniEscrito));

		return jugador;
		
	}
	
	public static Entrenador introducirDatosEntrenador(Scanner scan) {
		
		Entrenador entrenador = new Entrenador();
		
		System.out.println("Introduce el DNI del entrenador");
		entrenador.setDni(scan.nextLine());
		
		System.out.println("Introduce el Nombre del entrenador");
		entrenador.setNombre(scan.nextLine());
		
		System.out.println("Introduce el apellido del entrenador");
		entrenador.setApellido(scan.nextLine());
		
		System.out.println("Introduce los años de experiencia del entrenador ");
		entrenador.setAnos_experiencia(Integer.parseInt(scan.nextLine()));
		
		return entrenador;
		
	}
	
	public static Jugador modificarDatosJugador(Scanner scan) {
		
		Jugador jugador = new Jugador();
		GestorBBDD gestorbbdd = new GestorBBDD();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Introduce el nuevo nombre del jugador");
		jugador.setNombre(scan.nextLine());
		
		System.out.println("Introduce el nuevo apellido del jugador");	
		jugador.setApellido(scan.nextLine());
		
		System.out.println("Introduce el nuevo dorsal del jugador");
		jugador.setDorsal(Integer.parseInt(scan.nextLine()));
		
		try {
			System.out.println("Introduce la fecha de nacimiento del jugador");
			jugador.setFecha_nacimiento(sdf.parse(scan.nextLine()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Introduce el dni del entrenador");
		jugador.setEntrenador(gestorbbdd.getEntrenadorDNI(scan.nextLine()));
		
		return jugador;
		
	}
	
	public static Entrenador modificarDatosEntrenador(Scanner scan) {
		
		Entrenador entrenador = new Entrenador();
		
		System.out.println("Introduce el nuevo nombre del entrenador");
		entrenador.setNombre(scan.nextLine());
		
		System.out.println("Introduce el nuevo apellido del entrenador");
		entrenador.setApellido(scan.nextLine());
		
		System.out.println("Introduce los años de experiencia");
		entrenador.setAnos_experiencia(Integer.parseInt(scan.nextLine()));
		
		return entrenador;
		
	}
	
	public static String eliminarJugador(Scanner scan) {
		
		System.out.println("Introduce el DNI del jugador a eliminar");
		String dniJugador = scan.nextLine();
		
		return dniJugador;
		
	}
	
	public static String pedirDniEntrenador(Scanner scan) {
		
		
		System.out.println("Introdice el dni y te mostrare los datos del entrenador");
		String dniEntrenador = scan.nextLine();
		
		return dniEntrenador;
		
	}
	
	public static Entrenador eliminarEntrenador(Scanner scan) {
		
		Entrenador entrenador = new Entrenador();
		
		System.out.println("Introduce el DNI del entreandor a eliminar");
		entrenador.setDni(scan.nextLine());
		
		return entrenador;
		
	}
	
	
}