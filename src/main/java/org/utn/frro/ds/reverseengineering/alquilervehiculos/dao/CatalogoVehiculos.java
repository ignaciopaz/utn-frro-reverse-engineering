package org.utn.frro.ds.reverseengineering.alquilervehiculos.dao;

import java.util.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.*;

public class CatalogoVehiculos {
	private Collection<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
	public Vehiculo buscar(String patente) {		
		for (Vehiculo vehiculo : vehiculos) {
			if(vehiculo.getPatente().equals(patente)) {
				return vehiculo;
			}
		}
		return null;
	}
	
	/** Retorna una colección de objetos Vehículo con de un determinado TipoVehículo
	 * y que esté disponible en el periodo ingresado */
	public Collection<Vehiculo> buscarDisponibles(TipoVehiculo tipoVehiculo,
												  Date fechaDesde, Date fechaHasta) {
		Collection<Vehiculo> vehiculosDisp = new ArrayList<Vehiculo>();		
		for (Vehiculo vehiculo : vehiculos) { //Para cada vehiculo en vehiculos
			if (vehiculo.getTipoVehiculo() == tipoVehiculo) {
				boolean estaDisp = vehiculo.estaDisponible(fechaDesde, fechaHasta);
				if (estaDisp) {
					vehiculosDisp.add(vehiculo);	
				}
			}
		}
		return vehiculosDisp;
	}
}
