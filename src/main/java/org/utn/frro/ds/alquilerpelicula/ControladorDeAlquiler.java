package org.utn.frro.ds.alquilerpelicula;

import java.util.*;

public class ControladorDeAlquiler {
	
	private CatalogoDeSocios cs;
	private CatalogoDePeliculas cp;
	private Pedido pedidoActual;
	private Socio s;
	private Regla regla;
	
	public String identificarSocio(String id, String argPassword) {
		//Declara variable s de tipo Socio
		Socio s;
		//Asigna el objeto socio que retorna el catalogo de socios a la variable s
		s = cs.buscarSocio(id);
		boolean valido = s.validarPassword(argPassword);
		if (valido) {
			String estado = s.getEstado();
			if (estado.equals("habilitado")) {
				String nombre = s.getNombre();
				String apellido = s.getApellido();
				pedidoActual = new Pedido(s);
				return nombre + " " + apellido;
			}
		}
		return null;
	}
	
	public Collection<String[]> identificarPelicula(String tituloParcial) {
		// Declara una colección de peliculas y le asigna la coleccion que 
		// retorna el catalogo de peliculas
		List<Pelicula> arrPeliculas = cp.buscartitParcial(tituloParcial);		
		// Declara e instancia una colección de array de strings 
		// para guardar los datos de películas vacia
		Collection<String[]> colDatosPeliculas = new ArrayList<String[]>();
		for (int i = 0; i < arrPeliculas.size() ; i++ ) {
			Pelicula pelicula = arrPeliculas.get(i);
			String codigo = pelicula.getCodigo();
			String genero = pelicula.getGenero();
			String titulo = pelicula.getTitulo();
			String descripcion = pelicula.getDescripcion();
			int duracion = pelicula.getDuracion();
			String duracionStr = String.valueOf(duracion);
			// Crea un array con los datos de la película
			String[] datosPelicula = {codigo, titulo, genero, descripcion, duracionStr};
			//DatosPelicula datosPelicula = new DatosPelicula(codigo, titulo, genero, descripcion, duracion);
			// Agrega el objeto con los datos de la película a la colección de datos de películas
			colDatosPeliculas.add(datosPelicula);
		}
		// Retorna los datos de las peliculas
		return colDatosPeliculas;
	}
	
	public void seleccionarPelicula(String codPelicula) {
		Pelicula pel = cp.buscarPelicula(codPelicula);
		int cantidadPeliculasPendientes = s.getCantPeliculasPendientes();
		int cantPelActual = pedidoActual.getCantPeliculas();
		int cantMaxPelPendiente = regla.getMaxPelPendiente();
		if (cantMaxPelPendiente > cantidadPeliculasPendientes + cantPelActual) {
			boolean incluye = pedidoActual.incluyePelicula(pel);
			if (!incluye) {
				pedidoActual.crearLineaDePedido(pel);
			}
		}
	}
	
	public Collection<DatosPelicula> finalizarAlquiler() {
		s.agregarPedido(pedidoActual);
		Collection<Pelicula> peliculas  = pedidoActual.getPeliculas();
		// Crea una colección de datos de películas
		Collection<DatosPelicula> datosPeliculas  = new ArrayList<DatosPelicula>();
		for(Pelicula pel : peliculas) {
			String titulo = pel.getTitulo();
			String genero = pel.getGenero();
			String descripcion = pel.getDescripcion();
			// Crea un objeto con los datos de la película
			DatosPelicula datosPelicula = new DatosPelicula(titulo, genero, descripcion); 
			// Agrega el objeto con los datos de la película a la colección de datos de películas
			datosPeliculas.add(datosPelicula);
		}
		// Retorna los datos de las peliculas
		return datosPeliculas;
	}
}
