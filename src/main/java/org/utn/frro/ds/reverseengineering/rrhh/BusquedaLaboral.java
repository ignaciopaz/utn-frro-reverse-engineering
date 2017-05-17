package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class BusquedaLaboral {
	private long idBusquedaLaboral;
	private String empresa;
	private Collection<Conocimiento> conocimientodsBuscados;
	//En UML2, el siguiente atributo sería equivalente a: entrevistas:Entrevista[*]
	private Collection<Entrevista> entrevistas;
	
	public long getIdBusquedaLaboral() {
		return idBusquedaLaboral;
	}

	public Collection<Conocimiento> getConocimientosBuscados() {
		return conocimientodsBuscados;
	}

	public void agregarEntrevista(Candidato c, Date fechaHoraEntrevista) {
		//Patrón Creador
		Entrevista e = new Entrevista(c, fechaHoraEntrevista);
		entrevistas.add(e);		
	}

	public String getEmpresa() {
		return empresa;
	}
}
