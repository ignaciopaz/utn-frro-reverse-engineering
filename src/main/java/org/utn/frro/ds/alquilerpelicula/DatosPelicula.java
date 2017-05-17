package org.utn.frro.ds.alquilerpelicula;

public class DatosPelicula {
	String codigo;
	String titulo;
	String genero;
	String descripcion;
	int duracion;
	
	public DatosPelicula(String codigo, String titulo, String genero, String descripcion, int duracion) {
		this.codigo=codigo;
		this.titulo=titulo;
		this.genero=genero;
		this.descripcion=descripcion;
		this.duracion=duracion;
	}

	public DatosPelicula(String titulo, String genero, String descripcion) {
		this.titulo=titulo;
		this.genero=genero;
		this.descripcion=descripcion;
	}

}
