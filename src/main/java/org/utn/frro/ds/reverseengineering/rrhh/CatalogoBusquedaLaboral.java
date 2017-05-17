package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class CatalogoBusquedaLaboral {
    //En UML2, el siguiente atributo sería equivalente a: busquedasLabrolares:BusquedaLaboral[*]
	private Collection<BusquedaLaboral> busquedasLabrolares;

	public BusquedaLaboral buscar(long idBusquedaLaboral) {
		//Para cada bl:BusquedaLaboral en la colección busquedasLabrolares:BusquedaLaboral[*]
		for(BusquedaLaboral bl: busquedasLabrolares) {
			long id = bl.getIdBusquedaLaboral();
			//Si coincide el id de la busqueda laboral con el parámetro idBusquedaLaboral
			//retorna el objeto bl:BusquedaLaboral
			if (idBusquedaLaboral == id) {
				return bl;
			}
		}
		return null;
	}

}
