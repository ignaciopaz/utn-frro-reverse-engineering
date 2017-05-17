package org.utn.frro.ds.alquilerpelicula;

import java.util.*;

public class LineaDePedido {
	private Date fechaDevolucion;
	private Pelicula pel;
	private String estado;

	public LineaDePedido(Pelicula pel) {
		this.pel = pel;
		estado = "habilitado";
	}

	public boolean estaPendiente() {
		if (fechaDevolucion==null) {
			return true;	
		}
		return false;
	}

	public boolean incluyePelicula(Pelicula pel) {
		if (this.pel == pel) {
			return true;
		}
		return false;
	}

	public Pelicula getPelicula() {
		return pel;
	}

}
