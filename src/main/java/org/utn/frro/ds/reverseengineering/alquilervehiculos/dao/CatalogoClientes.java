package org.utn.frro.ds.reverseengineering.alquilervehiculos.dao;

import java.util.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.Cliente;

public class CatalogoClientes {
	//Declara una collecci�n de clientes que se instancia al crear el 
	//cat�logo con un ArrayList de clientes
	private Collection<Cliente> clientes = new ArrayList<Cliente>();
		
	/** Busca el objeto de la clase Cliente dentro del cat�logo cuyo 
	 * codCliente coincida con el codCliente ingresado como par�metro.
	 * Si no lo encuentra devuelve null.*/
	public Cliente buscar(long codCliente) {		
		for(Cliente cliente : clientes) { //Para cada objeto cliente en la colecci�n clientes
			if(codCliente == cliente.getCodCliente()) {
				return cliente;
			}
		}
		return null;
	}
}
