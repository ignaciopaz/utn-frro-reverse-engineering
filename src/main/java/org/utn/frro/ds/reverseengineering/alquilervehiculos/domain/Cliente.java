package org.utn.frro.ds.reverseengineering.alquilervehiculos.domain;

public class Cliente {
	private long codCliente;
	private String razonSocial;
	
	public Cliente(long pCodCliente, String pRazonSocial) {
		codCliente = pCodCliente;
		razonSocial = pRazonSocial;
	}
	public long getCodCliente() {
		return codCliente;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
}
