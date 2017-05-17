package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

public class TipoVehiculo {
	private long codTipoVehiculo;
	private String descripcionTipo;
	private double precioDia;

	public TipoVehiculo(long pCodTipoVehiculo, String pDescripcionTipo, double pPrecioDia) {
		super();
		this.codTipoVehiculo = pCodTipoVehiculo;
		this.descripcionTipo = pDescripcionTipo;		
		precioDia = pPrecioDia;
	}
	public long getCodTipoVehiculo() {
		return codTipoVehiculo;
	}
	public String getDescripcionTipo() {
		return descripcionTipo;
	}
	public double getPrecioDia() {
		return precioDia;
	}
}
