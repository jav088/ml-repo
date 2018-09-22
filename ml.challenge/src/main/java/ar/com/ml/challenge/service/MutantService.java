package ar.com.ml.challenge.service;

import ar.com.ml.challenge.exception.ServiceException;

public interface MutantService {

	/**
	 * Determina a traves de un array de String si es un mutante.
	 * Para ser un mutante debe tener una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical.
	 * @param dna
	 * @return
	 * @throws ServiceException 
	 */
	public boolean isMutant(String[] dna) throws ServiceException;
	
}
