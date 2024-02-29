package objetos;

import java.util.Comparator;

public class Comparador implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
		
		return o2.getFecha_nacimiento().compareTo(o1.getFecha_nacimiento());
	}
	
}
