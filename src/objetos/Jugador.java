package objetos;

import java.util.Date;

public class Jugador {
	
	private String dni;
	private String nombre;
	private String apellido;
	private int dorsal;
	private Date fecha_nacimiento;
	private Entrenador entrenador;
	
	public Jugador() {
		
	}
	
	public Jugador(String dni, String nombre, String apellido, int dorsal, Date fecha_nacimiento,
			Entrenador entrenador) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dorsal = dorsal;
		this.fecha_nacimiento = fecha_nacimiento;
		this.entrenador = entrenador;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	@Override
	public String toString() {
		return "Jugador [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", dorsal=" + dorsal
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", entrenador=" + entrenador + "]";
	}
	
	
	
	
}
