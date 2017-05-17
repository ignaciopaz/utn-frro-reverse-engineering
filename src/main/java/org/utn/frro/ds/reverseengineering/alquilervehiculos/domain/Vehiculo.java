package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

import java.util.*;

public class Vehiculo {
	private String patente;
	private Modelo modelo;
	private Collection<Alquiler> alquileres = new ArrayList<Alquiler>();

	public String getPatente() {
		return patente;
	}
	// indica si el vehiculo esta disponible para un periodo
	public boolean estaDisponible(Date fechaDesde, Date fechaHasta) {				
		//el vehiculo puede tener alquileres programados para el futuro)
		for (Alquiler alquiler : alquileres) {
			if (!alquiler.estaCancelado()) {
				boolean incluyeFechas = alquiler.incluyeFechas(fechaDesde, fechaHasta);
				if (incluyeFechas) {
					return false;
				}
			}		
		}
		return true;
	}	
	public TipoVehiculo getTipoVehiculo() {
		TipoVehiculo tipoVehiculo = modelo.getTipoVehiculo();
		return tipoVehiculo;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public double getPrecioDia() {
		TipoVehiculo tipoVehiculo = getTipoVehiculo();
		double precioDia = tipoVehiculo.getPrecioDia();
		return precioDia;
	}
	public void agregarAlquiler(Alquiler alquiler) {
		alquileres.add(alquiler);
	}
}