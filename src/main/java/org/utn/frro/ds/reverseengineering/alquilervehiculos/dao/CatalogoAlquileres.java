package org.utn.frro.ds.reverseengineering.alquilervehiculos.dao;

import java.util.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.Alquiler;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.AlquilerRegistrador;

public class CatalogoAlquileres extends AlquilerRegistrador{
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	//atributo de clase nroAlquiler
	private static long nroAlquiler;
	
	//Método de clase que retorna el nroAlquiler siguiente.
	//La palabra "synchronized" asegura que el método se ejecutre en un único hilo por vez.
	//Evita problemas de concurrencia en caso que el método se llame por dos o mas procesos 
	//al mismo tiempo y asegura que se genere un único nroAlquiler y no se intente incrementar
	//su valor por dos o más procesos al mismo tiempo. 
	private synchronized static long getProximoNroAlquiler() {
		nroAlquiler = nroAlquiler + 1;
		return nroAlquiler; 
	}
	
	public void registrar(Alquiler alquiler) {	
		long nroAlquiler = getProximoNroAlquiler();
		alquiler.setNroAlquiler(nroAlquiler);
		alquileres.add(alquiler);
	}
	/** Busca el objeto de la clase Alquiler dentro del catálogo cuyo
	 * nroAlquiler coincida con el nroAlquiler ingresado como parámetro.
	 * Si no lo encuentra devuelve null. */
	public Alquiler buscar(long nroAlquiler) {
		//Para cada alquiler en alquileres
		for(Alquiler alquiler : alquileres) {
			if(nroAlquiler == alquiler.getNroAlquiler()) {
				return alquiler;
			}
		}
		return null;
	}

	public static AlquilerRegistrador getInstance() {
		// TODO Auto-generated method stub
		return null;
	}	
}
