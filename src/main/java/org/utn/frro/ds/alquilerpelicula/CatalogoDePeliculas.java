package org.utn.frro.ds.alquilerpelicula;

import java.util.*;

public class CatalogoDePeliculas {
	Collection<Pelicula> peliculas = new ArrayList<Pelicula>();

	public List<Pelicula> buscartitParcial(String tituloParcial) {
		List<Pelicula> arrPeliculas = new ArrayList<Pelicula>();
		for(Pelicula pel : peliculas) {
			String titulo = pel.getTitulo();
			if (titulo.startsWith(tituloParcial)) {
				arrPeliculas.add(pel);
			}				
		}
		return arrPeliculas;
	}

	public Pelicula buscarPelicula(String codPelicula) {
		for(Pelicula pel : peliculas) {
			String codigo = pel.getCodigo();
			if (codigo.equals(codPelicula)) {
				return pel;
			}
		}
		return null;
	}

	

}
