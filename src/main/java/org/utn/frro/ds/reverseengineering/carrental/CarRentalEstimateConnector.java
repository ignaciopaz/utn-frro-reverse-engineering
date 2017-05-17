package org.utn.frro.ds.reverseengineering.carrental;

import java.util.Date;

public class CarRentalEstimateConnector {
	private static CarRentalEstimateConnector instance;
	
	
	public static CarRentalEstimateConnector getInstance() {
		return instance;
		
	}
	
	public void recibirDatos( long nroAlquiler, String patente, long codTipoVehiculo, long codModelo, String anioFabricacion, Date fechaDesde, int dias) {
		
	}
}
