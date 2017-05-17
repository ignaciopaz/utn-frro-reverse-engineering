package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class BusquedaLaboral {
	private long idBusquedaLaboral;
	private String empresa;
	private Collection<Conocimiento> conocimientodsBuscados;
	//En UML2, el siguiente atributo ser�a equivalente a: entrevistas:Entrevista[*]
	private Collection<Entrevista> entrevistas;
	
	public long getIdBusquedaLaboral() {
		return idBusquedaLaboral;
	}

	public Collection<Conocimiento> getConocimientosBuscados() {
		return conocimientodsBuscados;
	}

	public void agregarEntrevista(Candidato c, Date fechaHoraEntrevista) {
		//Patr�n Creador
		Entrevista e = new Entrevista(c, fechaHoraEntrevista);
		entrevistas.add(e);		
	}

	public String getEmpresa() {
		return empresa;
	}
}
