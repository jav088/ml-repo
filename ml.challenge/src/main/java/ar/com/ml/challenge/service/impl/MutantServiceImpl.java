package ar.com.ml.challenge.service.impl;

import org.springframework.stereotype.Service;

import ar.com.ml.challenge.entity.HandlerMutantCombination;
import ar.com.ml.challenge.enums.MutantesEnum;
import ar.com.ml.challenge.exception.ServiceException;
import ar.com.ml.challenge.service.MutantService;

@Service("mutantService")
public class MutantServiceImpl implements MutantService {
	
	public boolean isMutant(String[] dna) throws ServiceException {
		
		char[][] matrixDna = convertToMatrixAndValidateStructure(dna);
		
		return isDnaMutant(matrixDna);
	}

	/**
	 * Convierte el Array de Strings en una Matriz de Strings.
	 * Valida que la matriz sea cuadrada y que los datos ingresados sean A,T,C,G.
	 * @param dna
	 * @return
	 * @throws ServiceException 
	 */
	public char[][] convertToMatrixAndValidateStructure(String[] dna) throws ServiceException {

		if(dna == null) throw new ServiceException("El ADN no puede ser nulo.");
		
		char[][] matrixDna = new char[dna.length][dna.length];
		
		for (int i=0; i < dna.length; i++) {
			matrixDna[i] = getDnaValidated(dna, i);
		}

		return matrixDna;
	}

	/**
	 * Valida que la matriz sea cuadrada y que los datos ingresados sean A,T,C,G.
	 * @param dna
	 * @param position
	 * @return
	 * @throws ServiceException
	 */
	private char[] getDnaValidated(String[] dna, int position) throws ServiceException {
		
		char[] charArray = dna[position].toCharArray();
		
		int rows = dna.length;
		
		if(dna[position].length() != rows) {
			throw new ServiceException("La cantidad de adn ingresado en la posicion " +String.valueOf(position)+ 
					" del adn " +dna[position]+ " es incorrecto, la matriz debe ser cuadrada"); 
		}
		
		for(char letraAdn : charArray) {
			MutantesEnum.validateAdnMutant(String.valueOf(letraAdn));
		}
		
		return charArray;
	}
	
	/**
	 * Ejecuta los buscadores de coincidencias y suma la cantidad para saber si es mutante.
	 * @param combinationsHandler 
	 * @param matrixDna
	 * @throws ServiceException 
	 */
	private Boolean isDnaMutant(char[][] matrixDna) throws ServiceException {

		HandlerMutantCombination handler = new HandlerMutantCombination();
		int combinations = handler.getCombinations(matrixDna);
		
		return (combinations > 1) ? true : false;
	}
	
}
