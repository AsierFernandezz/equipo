package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import objetos.Conector;
import objetos.Entrenador;
import objetos.Jugador;

public class GestorBBDD extends Conector{
	
	public ArrayList<Jugador> getJugadores(){
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		String sql = "SELECT * FROM jugador";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Jugador j = new Jugador();
				j.setDni(rs.getString("dni"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setDorsal(rs.getInt("dorsal"));
				j.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				j.setEntrenador(getEntrenadorDNI(rs.getString("dni_entrenador")));

				
				jugadores.add(j);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jugadores;
		
	}
	
	public ArrayList<Entrenador> getEntrenadores(){
		
		ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
		String sql = "SELECT * FROM entrenador";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Entrenador e = new Entrenador();
				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setAnos_experiencia(rs.getInt("anos_experiencia"));
				
				entrenadores.add(e);
				
			}
			
			return entrenadores;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void insertarJugadores(Jugador jugador) {
		
		String sql = "INSERT INTO jugador (dni,nombre,apellido,dorsal,fecha_nacimiento,dni_entrenador) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, jugador.getDni());
			pst.setString(2, jugador.getNombre());
			pst.setString(3, jugador.getApellido());
			pst.setInt(4, jugador.getDorsal());
			pst.setDate(5, new java.sql.Date (jugador.getFecha_nacimiento().getTime()));
			pst.setString(6, jugador.getEntrenador().getDni());
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertarEntrenador(Entrenador entrenador) {
		
		String sql = "INSERT INTO entrenador (dni,nombre,apellido,anos_experiencia) VALUES (?,?,?,?)";
		
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, entrenador.getDni());
			pst.setString(2, entrenador.getNombre());
			pst.setString(3, entrenador.getApellido());
			pst.setInt(4, entrenador.getAnos_experiencia());
			
			pst.executeUpdate();
			
			System.out.println("Insertado correctamente");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void eliminarJugador(String dniJugador) {
		
		String sql = "DELETE FROM jugador WHERE dni = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dniJugador);
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void eliminarEntrenador(Entrenador entrenador) {
		
		String sql = "DELETE FROM entrenador WHERE dni = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, entrenador.getDni());
			
			pst.executeUpdate();
			
			System.out.println("Eliminado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Jugador modificarJugador(String dniJugador,Jugador jugador) {
		
		String sql = "UPDATE jugador SET nombre =?, apellido =?, dorsal =?, fecha_nacimiento=?, dni_entrenador=? WHERE dni=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, jugador.getNombre());
			pst.setString(2, jugador.getApellido());
			pst.setInt(3, jugador.getDorsal());
			pst.setDate(4, new java.sql.Date(jugador.getFecha_nacimiento().getTime()));
			pst.setString(5, jugador.getEntrenador().getDni());
			pst.setString(6, dniJugador);
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jugador;
		
	}
	
	public Entrenador modificarEntrenador(Entrenador entrenador, Entrenador entrenador2) {
		
		String sql = "UPDATE entrenador SET nombre=?,apellido=?,anos_experiencia=? WHERE dni=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, entrenador.getNombre());
			pst.setString(2, entrenador.getApellido());
			pst.setInt(3, entrenador.getAnos_experiencia());
			pst.setString(4, entrenador2.getDni());
			
			pst.executeUpdate();
			
			return entrenador;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Jugador getJugador (String dniJugador) {
		
		Jugador jugador = new Jugador();
		
		String sql = "SELECT * FROM jugador WHERE dni = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dniJugador);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			jugador.setDni(rs.getString("dni"));
			jugador.setNombre(rs.getString("nombre"));
			jugador.setApellido(rs.getString("apellido"));
			jugador.setDorsal(rs.getInt("dorsal"));
			jugador.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
			
			Entrenador entrenadorTemp = new Entrenador();
			entrenadorTemp.setDni(rs.getString("dni"));
			jugador.setEntrenador(entrenadorTemp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return jugador;
		
	}
	
	public Entrenador getEntrenador (String dniEntrenador) {
		
		String sql = "SELECT * FROM entrenador WHERE dni = ?";
		Entrenador entrenador = new Entrenador();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dniEntrenador);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			entrenador.setDni(rs.getString("dni"));
			entrenador.setNombre(rs.getString("nombre"));
			entrenador.setApellido(rs.getString("apellido"));
			entrenador.setAnos_experiencia(rs.getInt("anos_experiencia"));
			
			return entrenador;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public ArrayList<Jugador> getJugadoresXEntrenador(String dniEntrenador) {
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		String sql = "SELECT * FROM jugador WHERE dni_entrenador = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dniEntrenador);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Jugador j = new Jugador();
				j.setDni(rs.getString("dni"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setDorsal(rs.getInt("dorsal"));
				j.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				j.setEntrenador(getEntrenadorDNI(dniEntrenador));
				
				jugadores.add(j);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jugadores;
		
	}

	public Entrenador getEntrenadorDNI(String dniEntrenador) {
		
		String sql = "SELECT * FROM entrenador WHERE dni = ?";
		
		Entrenador entrenador = new Entrenador();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dniEntrenador);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
			entrenador.setDni(rs.getString("dni"));
			entrenador.setNombre(rs.getString("nombre"));
			entrenador.setApellido(rs.getString("apellido"));
			entrenador.setAnos_experiencia(rs.getInt("anos_experiencia"));
			}
			
			return entrenador;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
