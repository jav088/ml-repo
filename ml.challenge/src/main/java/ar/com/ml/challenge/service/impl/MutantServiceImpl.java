package ar.com.ml.challenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.ml.challenge.entity.MutantCombination;
import ar.com.ml.challenge.entity.MutantCombinationHorizontal;
import ar.com.ml.challenge.entity.MutantCombinationObliqueLeftToRight;
import ar.com.ml.challenge.entity.MutantCombinationObliqueRightToLeft;
import ar.com.ml.challenge.entity.MutantCombinationVertical;
import ar.com.ml.challenge.enums.MutantesEnum;
import ar.com.ml.challenge.exception.ServiceException;
import ar.com.ml.challenge.service.MutantService;

@Service("mutantService")
public class MutantServiceImpl implements MutantService {

	private List<MutantCombination> combinationsHandler;
	
	public boolean isMutant(String[] dna) throws ServiceException {

		initilizeCombinations();
		
		char[][] matrixDna = convertToMatrixAndValidateStructure(dna);
		
		return isDnaMutant(matrixDna);
	}

	/**
	 * Inicializa los handlers de las combinaciones posibles de una matriz.
	 */
	private void initilizeCombinations() {
		
		combinationsHandler = new ArrayList<MutantCombination>();
		combinationsHandler.add(new MutantCombinationHorizontal());
		combinationsHandler.add(new MutantCombinationVertical());
		combinationsHandler.add(new MutantCombinationObliqueRightToLeft());
		combinationsHandler.add(new MutantCombinationObliqueLeftToRight());
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
			throw new ServiceException("La cantidad de adn ingresado en la posicion " +String.valueOf(position-1)+ 
					" del adn " +dna[position]+ " es incorrecto, la matriz debe ser cuadrada"); 
		}
		
		for(char letraAdn : charArray) {
			MutantesEnum.validateAdnMutant(String.valueOf(letraAdn));
		}
		
		return charArray;
	}
	
	/**
	 * Ejecuta los buscadores de coincidencias y suma la cantidad para saber si es mutante.
	 * @param matrixDna
	 * @throws ServiceException 
	 */
	private Boolean isDnaMutant(char[][] matrixDna) throws ServiceException {

		int count = 0;
		
		for (MutantCombination combinationHandler : combinationsHandler) {
			combinationHandler.setMatrixDna(matrixDna);
			count += combinationHandler.getCombinations();
		}

		return (count > 1) ? true : false;
	}
	
}
