package org.utn.frro.ds.alquilerpelicula;

import java.util.*;

public class CatalogoDeSocios {
	Collection<Socio> socios = new ArrayList<Socio>();
	public Socio buscarSocio(String id) {		
		for(Socio s : socios) {
			String socioId = s.getId();
			if (socioId.equals(id)) {
				return s;
			}
		}
		return null;
	}
}
