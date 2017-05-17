package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

import org.utn.frro.ds.reverseengineering.carrental.CarRentalEstimateConnector;

public class CarRentalEstimateAdapter extends AlquilerRegistrador{
	
	CarRentalEstimateConnector carRentalEstimateConnector;
	
	@Override
	public void registrar(Alquiler alquiler) {
		
		carRentalEstimateConnector.recibirDatos(alquiler.getNroAlquiler(), alquiler.getVehiculo().getPatente(), alquiler.getVehiculo().getTipoVehiculo().getCodTipoVehiculo(), alquiler.getNroAlquiler(), null, alquiler.getFechaInicio(), 2);
		
	}

}
