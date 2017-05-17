package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

import org.utn.frro.ds.reverseengineering.alquilervehiculos.dao.CatalogoAlquileres;

public class AlquierRegistradorComposite extends AlquilerRegistrador{
	
	private AlquilerRegistrador[] alquilerRegistradores;
	
	 public AlquierRegistradorComposite() {
		super();
		alquilerRegistradores= new AlquilerRegistrador[2];
		alquilerRegistradores[0]=new CarRentalEstimateAdapter();
		alquilerRegistradores[1]=CatalogoAlquileres.getInstance();
	}

	@Override
	public void registrar(Alquiler alquiler) {
		 
		 for (AlquilerRegistrador ar: alquilerRegistradores) {
			 
			 ar.registrar(alquiler);
		 }
		 
		
		
	}

}
