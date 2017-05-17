package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class Candidato {
	private long idCandidato;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private Collection<Conocimiento> conocimientosCandidato;
	
	/** Retorna true si el Candidato conoce sobre todos los conocimientos
	 * en el parámetro colección conocimientosBuscados */
	public boolean sabe(Collection<Conocimiento> conocimientosBuscados) {
		//Si el candidato tiene todos los conocimientosBuscados en su lista
		//de conocimientos (conocimientosCandidato) devuelve true
		//llama al método de colección containsAll para ver si todos los objetos
		//conocimiento están dentro de la colección
		if (conocimientosCandidato.containsAll(conocimientosBuscados)) {
			return true;
		}
		return false;
	}

	public long getIdCandidato() {
		return idCandidato;
	}

	public String getNombreAppellido() {
		return nombre + " " + apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}
}
