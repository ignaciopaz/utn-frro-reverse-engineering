package org.utn.frro.ds.reverseengineering.alquilervehiculos.dao;

import java.util.*;
import org.utn.frro.ds.reverseengineering.alquilervehiculos.domain.Cliente;

public class CatalogoClientes {
	//Declara una collección de clientes que se instancia al crear el 
	//catálogo con un ArrayList de clientes
	private Collection<Cliente> clientes = new ArrayList<Cliente>();
		
	/** Busca el objeto de la clase Cliente dentro del catálogo cuyo 
	 * codCliente coincida con el codCliente ingresado como parámetro.
	 * Si no lo encuentra devuelve null.*/
	public Cliente buscar(long codCliente) {		
		for(Cliente cliente : clientes) { //Para cada objeto cliente en la colección clientes
			if(codCliente == cliente.getCodCliente()) {
				return cliente;
			}
		}
		return null;
	}
}
