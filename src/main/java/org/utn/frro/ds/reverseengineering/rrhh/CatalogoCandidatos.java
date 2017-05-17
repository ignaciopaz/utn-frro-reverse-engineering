package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class CatalogoCandidatos {
	Collection<Candidato> candidatos;

	/** Este m�todo busca los candidatos que tienen todos los conociemientos 
	 * indicados en la colecci�n conocimientosBuscados */
	public Collection<Candidato> buscarPorConocimientos(Collection<Conocimiento> conocimientosBuscados) {
		//crea una colecci�n vac�a para agregarle las coincidencias y retornarla
		Collection<Candidato> candidatosEncontrados = new ArrayList<Candidato>();
		//Para cada c:Candidato en candidatos
		for (Candidato c : candidatos) {
			boolean sabe = c.sabe(conocimientosBuscados); //Aplica Patr�n Experto en Informaci�n
			if (sabe) { //Si sabe sobre los conocimientos lo agrega a la colecci�n
				candidatosEncontrados.add(c);
			}
		}
		return candidatosEncontrados;
	}
	
	public Candidato buscar(long codCandidato) {
		//llama a m�todo buscarEnLista para buscar sobre la 
		//colecci�n de todos los candidatos
		return buscarEnLista(codCandidato, candidatos);
	}
	
	/** Busca un candidato con determinado idCandidato en una colecci�n de candidtos */
	public Candidato buscarEnLista(long idCandidato, Collection<Candidato> listaCandidatos) {
		//Para cada c:Candidato en listaCandidatos
		for (Candidato c : listaCandidatos) {
			//Si el Id del candidato coincide con el par�metro idCandidato retorna c:Candidato
			if(c.getIdCandidato() == idCandidato) {
				return c;
			}
		}
		return null;
	}
}
