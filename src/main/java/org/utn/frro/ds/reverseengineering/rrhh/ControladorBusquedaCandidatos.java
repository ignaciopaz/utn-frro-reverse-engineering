package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;
/**
 * @author ignacio.paz
 * Este controlador permite buscar y agendar entrevistas con 
 * candidatos que tengan los conocimientos requeridos
 * para una búsqueda laboral definida en una consultora de RRHH. 
 */
public class ControladorBusquedaCandidatos {
	private CatalogoBusquedaLaboral cbl;
	private CatalogoCandidatos cc;	
	//En UML2, el siguiente atributo, sería equivalente a: listaCandidatos:Candidato[*]
	private Collection<Candidato> listaCandidatos;
	private BusquedaLaboral bl; //En UML2, equivalente a: bl:BusquedaLaboral
	
	/** Método Constructor de la clase ControladorBusquedaCandidatos.
	 * Equivalente a método "create" de los DSD.
	 * El Controlador normalmente se crea desde la interfaz de usuario o una parte mas gral del Sistema */
	public ControladorBusquedaCandidatos(CatalogoBusquedaLaboral cbl, CatalogoCandidatos cc) {
		super();
		this.cbl = cbl;
		this.cc = cc;
	}

	public Collection<String[]> buscarCandidatos(long idBusquedaLaboral) {
		bl = cbl.buscar(idBusquedaLaboral);
		Collection<Conocimiento> conocimientosBuscados = bl.getConocimientosBuscados();
		
		listaCandidatos = cc.buscarPorConocimientos(conocimientosBuscados);
		if (listaCandidatos.isEmpty()) {
			//Si no hay candidatos con esos conocimientos, termina el CU.
			throw new RuntimeException("No Hay Candidatos que posean todos los conocimientos de la búsqueda");
		}
		
		//inicializa Colección de array de strings
		Collection<String[]> datosCandidatos = new ArrayList<String[]>();
		for (Candidato c : listaCandidatos) {
			long id = c.getIdCandidato();
			String nombreApellido = c.getNombreAppellido();
			String telefono = c.getTelefono();
			String email = c.getEmail();
			//Crea array con los datos del candidato
			String[] datosCandidato = new String[]{String.valueOf(id), nombreApellido, telefono, email};
			//Agrega array de datos del candidato a la colección de datos de candidatos
			datosCandidatos.add(datosCandidato);
		}
		return datosCandidatos;		
	}
	
	//Por cada candidato que se elija, el actor llama a este método 
	//para confirmar fecha y hora de entrevista. Este CU permite confirmar entrevistas con muchos candidatos 
	public String confirmarEntrevista(long codCandidato, Date fechaHoraEntrevista) {
		Candidato c = cc.buscarEnLista(codCandidato, listaCandidatos);
		bl.agregarEntrevista(c, fechaHoraEntrevista); //patrón creador
		return "Se agendó la entrevista con " + c.getNombreAppellido() + 
			   " para la búsqueda de la empresa " + bl.getEmpresa();
	}
}
