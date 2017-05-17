package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

public class Modelo {
	private String codModelo;
	private TipoVehiculo tipoVehiculo;
	private Marca marca;

	public Modelo(String codModelo, Marca marca, TipoVehiculo tipoVehiculo) {
		super();
		this.codModelo = codModelo;
		this.marca = marca;
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getCodModelo() {
		return codModelo;
	}	
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public Marca getMarca() {
		return marca;
	}
}
