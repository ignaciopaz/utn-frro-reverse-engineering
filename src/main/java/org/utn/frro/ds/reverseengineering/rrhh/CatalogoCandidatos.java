package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class CatalogoCandidatos {
	Collection<Candidato> candidatos;

	/** Este método busca los candidatos que tienen todos los conociemientos 
	 * indicados en la colección conocimientosBuscados */
	public Collection<Candidato> buscarPorConocimientos(Collection<Conocimiento> conocimientosBuscados) {
		//crea una colección vacía para agregarle las coincidencias y retornarla
		Collection<Candidato> candidatosEncontrados = new ArrayList<Candidato>();
		//Para cada c:Candidato en candidatos
		for (Candidato c : candidatos) {
			boolean sabe = c.sabe(conocimientosBuscados); //Aplica Patrón Experto en Información
			if (sabe) { //Si sabe sobre los conocimientos lo agrega a la colección
				candidatosEncontrados.add(c);
			}
		}
		return candidatosEncontrados;
	}
	
	public Candidato buscar(long codCandidato) {
		//llama a método buscarEnLista para buscar sobre la 
		//colección de todos los candidatos
		return buscarEnLista(codCandidato, candidatos);
	}
	
	/** Busca un candidato con determinado idCandidato en una colección de candidtos */
	public Candidato buscarEnLista(long idCandidato, Collection<Candidato> listaCandidatos) {
		//Para cada c:Candidato en listaCandidatos
		for (Candidato c : listaCandidatos) {
			//Si el Id del candidato coincide con el parámetro idCandidato retorna c:Candidato
			if(c.getIdCandidato() == idCandidato) {
				return c;
			}
		}
		return null;
	}
}
