package org.utn.frro.ds.alquilerpelicula;

import java.util.*;

public class Pedido {
	Socio soc;
	Date fecha;
	String estado;
	Collection<LineaDePedido> colLineas;

	public Pedido(Socio s) {
		soc = s;
		fecha = new Date();
		estado = "habilitado";
		colLineas = new ArrayList<LineaDePedido>();
	}

	public int getCantPelicPend() {
		int cantPelicPend = 0;
		for (LineaDePedido lp : colLineas) {
			if (lp.estaPendiente()) {
				cantPelicPend++;
			}
		}
		return cantPelicPend;		
	}

	public int getCantPeliculas() {
		int cant = colLineas.size();
		return cant;
	}

	public boolean incluyePelicula(Pelicula pel) {
		for (LineaDePedido lp : colLineas) {
			if (lp.incluyePelicula(pel)) {
				return true;
			}
		}
		return false;
	}

	public void crearLineaDePedido(Pelicula pel) {
		LineaDePedido linea = new LineaDePedido(pel);
		colLineas.add(linea);
	}

	public Collection<Pelicula> getPeliculas() {
		Collection<Pelicula> peliculas = new ArrayList<Pelicula>();
		for(LineaDePedido lp : colLineas) {
			Pelicula pel = lp.getPelicula();
			peliculas.add(pel);
		}
		return peliculas;
	}

}
