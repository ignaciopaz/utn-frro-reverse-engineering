package org.utn.frro.ds.reverseengineering.alquilervehiculos.dao;

import java.util.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.TipoVehiculo;

public class CatalogoTipoVehiculos {
	//Declaraci�n de Colecci�n de objetos TipoVehiculo
	private Collection<TipoVehiculo> tiposVehiculo= new ArrayList<TipoVehiculo>();
		
	/** Busca el objeto de la clase TipoVehiculo dentro del cat�logo cuyo 
	 * codTipoVehiculo coincide con el codTipoVehiculo ingresado como 
	 * par�metro. Si no lo encuentra devuelve null. */
	public TipoVehiculo buscar(long codTipoVehiculo) {
		//Para cada objeto tipoVehiculo en la colecci�n tiposVehiculo
		for(TipoVehiculo tipoVehiculo : tiposVehiculo) {
			if(codTipoVehiculo == tipoVehiculo.getCodTipoVehiculo()) {
				return tipoVehiculo;
			}
		}
		return null;
	}
}
