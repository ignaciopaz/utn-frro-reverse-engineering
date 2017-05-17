package org.utn.frro.ds.reverseengineering.rrhh;

import java.util.*;

public class Entrevista {
	private Candidato candidato;
	private Date fechaHoraEntrevista;
	private Date fechaCreacion;
	private String estado;
	private Double puntajeEvaluacion = null; //inicializa el puntaje en null

	//Constructor de la clase Entrevista. Equivalente al método create
	public Entrevista(Candidato c, Date pFechaHoraEntrevista) {
		candidato=c;
		fechaHoraEntrevista=pFechaHoraEntrevista;
		//guarda la hora en la que se creo la entrevista
		fechaCreacion = new Date();
		//inicializa el estado de la entrevista
		estado = "confirmado";
	}
}
