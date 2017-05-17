package org.utn.frro.ds.reverseengineering.alquilervehiculos.service;

import java.util.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.dao.*;

/** Esta clase Controla el CU Alquilar Vehículo.
 * - Los alquileres mediante este CU comienzan hoy.
 * - Los alquileres programados o reservados son manejados por otro CU.
 * - Para simplificar el CU, se omiten conceptos de KM utilizados,
 *   consumo de combustible, roturas y estado del vehículo.
 * - Para simplificar, no se tienen en cuenta hs de alquiler, se alquila por días completos. */
public class ControladorAlquilarVehiculo {
	private CatalogoClientes cc;
	private CatalogoTipoVehiculos ctv;
	private CatalogoVehiculos cv;
	private AlquilerRegistrador ca;	
	private Alquiler alquilerActual;
	
	/** Método Constructor de la clase ControladorAlquilerVehiculos.
	 * Equivalente a método "create" de los DSD.
	 * El Controlador normalmente se crea desde la interfaz de usuario o una parte mas gral del Sistema */
	public ControladorAlquilarVehiculo (CatalogoClientes cc,
										  CatalogoTipoVehiculos ctv,
										  CatalogoVehiculos cv, AlquilerRegistrador ca) {
		this.cc=cc;
		this.ctv=ctv;
		this.cv=cv;
		this.ca=ca;
	}
	
	public String identificarCliente(long codCliente) {
		//Declara una variable local cliente de clase Cliente
		Cliente cliente;
		/* llama al método buscar del catálogo de clientes pasando el codCliente como parámetro.
		   Asigna el objeto cliente que retorna el método buscar a la variable cliente antes definida.*/
		cliente = cc.buscar(codCliente);		
		if (cliente != null) {
			//declara una variable local reazonSocial de la clase String
			// y le asigna al valor de la razon social del cliente encontrado 
			String razonSocial = cliente.getRazonSocial();
			// Crea una nuevo objeto de la clase Alquiler y asigna el objeto
			// creado al atributo de instancia alquiler del controlador
			alquilerActual = new Alquiler(cliente);
			return razonSocial;
		} else {//Si no se encuentra el cliente se devuelve una excepción (mensaje de error).
			throw new RuntimeException("No existe un cliente con el código ingresado");
		}
	}
	
	public Collection<String[]> seleccionarTipoVehiculo(long codTipoVehiculo, Date fechaHasta) {
		//se asume que el alquiler comienza hoy. Se define una variable local fechaDesde del método.
		Date fechaDesde = new Date();
		alquilerActual.setPeriodo(fechaDesde, fechaHasta);
		TipoVehiculo tipoVehiculo = ctv.buscar(codTipoVehiculo);
		String descripcionTipo = tipoVehiculo.getDescripcionTipo();
		Collection<Vehiculo> vechiculosDisp = cv.buscarDisponibles(tipoVehiculo, 
																   fechaDesde, fechaHasta);		
		// Define una lista (Colección) de Array de Strings y le asigna una nueva instancia de ArrayList
		//(Versión simplificada de devolución de datos al exterior. Aquí correspondería un objeto interfaz).
		Collection<String[]> datosVehiculos = new ArrayList<String[]>();
		
		//Para cada vehiculo en vehiculosDisp
		for (Vehiculo vehiculo : vechiculosDisp) {
			String patente = vehiculo.getPatente();
			Modelo modelo = vehiculo.getModelo();
			String codModelo = modelo.getCodModelo();
			String codMarca = modelo.getMarca().getCodMarca();
			//Se usa String.valueOf para convertir números a String.
			String precioDia = String.valueOf(vehiculo.getPrecioDia());
			
			//Define un array de objetos y le asigna los valores
			String[] datosVehiculo = {patente, descripcionTipo, codMarca, codModelo, precioDia};
			//agrega el array de strings con los datos del vehículo a
			//la colleción de datosVehiculo
			datosVehiculos.add(datosVehiculo);
		}
		return datosVehiculos;
	}
	
	public long seleccionarVehiculo(String patente) {
		Vehiculo vehiculo = cv.buscar(patente);
		if (vehiculo==null) {			
			throw new RuntimeException("No existe un vehiculo con la patente ingresada");			
		}
		if (!vehiculo.estaDisponible(alquilerActual.getFechaInicio(), alquilerActual.getFechaFin())) {			
			throw new RuntimeException("El vehiculo seleccionado no está disponible en el periodo: " +
					alquilerActual.getFechaInicio() + " - " +alquilerActual.getFechaFin());			
		}
		alquilerActual.setVehiculo(vehiculo);
		vehiculo.agregarAlquiler(alquilerActual);
		ca.registrar(alquilerActual);
		long nroAlquiler = alquilerActual.getNroAlquiler();
		return nroAlquiler;
	}	
}