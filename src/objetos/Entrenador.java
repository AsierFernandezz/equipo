package objetos;

public class Entrenador {
	
	private String dni;
	private String nombre;
	private String apellido;
	private int anos_experiencia;
	
	public Entrenador() {
		
	}
	
	public Entrenador(String dni, String nombre, String apellido, int anos_experiencia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.anos_experiencia = anos_experiencia;
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
	public int getAnos_experiencia() {
		return anos_experiencia;
	}
	public void setAnos_experiencia(int años_experiencia) {
		this.anos_experiencia = años_experiencia;
	}
	
	@Override
	public String toString() {
		return "Entrenador [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", anos_experiencia="
				+ anos_experiencia + "]";
	}
	
	
	
}
