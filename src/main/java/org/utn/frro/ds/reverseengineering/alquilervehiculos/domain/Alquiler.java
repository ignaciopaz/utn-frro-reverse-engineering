package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

import java.util.*;

public class Alquiler {	
	private long nroAlquiler;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private Date fechaAlquiler;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaCancelacion;
		
	//Constructor de Alquiler. Equivalente a método create.
	public Alquiler(Cliente pCliente) {
		this.cliente=pCliente;
		this.fechaAlquiler=new Date();
	}
	public boolean estaCancelado() {
		if (fechaCancelacion == null) {
			return false;
		}
		return true;
	}
	
	public boolean incluyeFechas(Date fechaDesde, Date fechaHasta) {		
		//Si la fechaDesde está dentro del periodo del alquiler, incluye fechas
		if(fechaInicio.before(fechaDesde) && fechaFin.after(fechaDesde)) {
			return true;
		}
		//Si la fechaHasta está dentro del periodo del alquiler, incluye fechas
		if(fechaInicio.before(fechaHasta) && fechaFin.after(fechaHasta)) {
			return true;
		}
		//Si la fechaInicio del alquiler está dentro del periodo ingresado como parámetro, inluye fechas		
		if (fechaInicio.after(fechaDesde) && fechaInicio.before(fechaHasta)) {
			return true;
		}		
		//Si la fechaFin del alquiler está dentro del periodo ingresado como parámetro, inluye fechas		
		if (fechaFin.after(fechaDesde) && fechaFin.before(fechaHasta)) {
			return true;
		}
		return false;
	}
	public void setPeriodo(Date pFechaDesde, Date pFechaHasta) {
		this.fechaInicio = pFechaDesde;
		this.fechaFin = pFechaHasta;
	}
	public void setVehiculo(Vehiculo pVehiculo) {
		this.vehiculo = pVehiculo;
	}
	public long getNroAlquiler() {
		return nroAlquiler;
	}
	public void setNroAlquiler(long pNroAlquiler) {
		this.nroAlquiler = pNroAlquiler;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}	
}