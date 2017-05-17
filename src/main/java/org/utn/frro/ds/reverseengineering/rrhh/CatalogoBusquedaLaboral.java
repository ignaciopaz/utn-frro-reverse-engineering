package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class CatalogoBusquedaLaboral {
    //En UML2, el siguiente atributo ser�a equivalente a: busquedasLabrolares:BusquedaLaboral[*]
	private Collection<BusquedaLaboral> busquedasLabrolares;

	public BusquedaLaboral buscar(long idBusquedaLaboral) {
		//Para cada bl:BusquedaLaboral en la colecci�n busquedasLabrolares:BusquedaLaboral[*]
		for(BusquedaLaboral bl: busquedasLabrolares) {
			long id = bl.getIdBusquedaLaboral();
			//Si coincide el id de la busqueda laboral con el par�metro idBusquedaLaboral
			//retorna el objeto bl:BusquedaLaboral
			if (idBusquedaLaboral == id) {
				return bl;
			}
		}
		return null;
	}

}
