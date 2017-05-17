package org.utn.frro.ds.alquilerpelicula;

import java.util.*;

public class Socio {

	private String id;
	private String password;
	private String estado;
	private String nombre;
	private String apellido;
	private Collection<Pedido> pedidos;
	public String getId() {
		return id;
	}
	public boolean validarPassword(String argPassword) {
		if ((this.password==null && argPassword==null)
				|| this.password.equals(argPassword)) {
			return true;
		}
		return false;
	}
	public String getEstado() {
		return estado;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getCantPeliculasPendientes() {
		int cantPelicPend = 0;
		for (Pedido p : pedidos) {
			cantPelicPend += p.getCantPelicPend();
		}
		return cantPelicPend;
	}
	public void agregarPedido(Pedido pedidoActual) {
		pedidos.add(pedidoActual);
	}
}
