package ar.com.ml.challenge.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de administrar los objetos que recorren la matriz en todas las direcciones.
 * @author j.santagada
 *
 */
public class HandlerMutantCombination {

	/**
	 * Devuelve la cantidad de combinaciones de una matriz.
	 * Solo va a retornar 0, 1 o 2, ya que corta la ejecucion al encontrar 2 combinaciones.
	 * @param matrixDna
	 * @return
	 */
	public Integer getCombinations(char[][] matrixDna) {
		
		List<MutantCombination> combinationsHandler = initilizeCombinations();
		
		int count = 0;
		for (int i=0; i<matrixDna.length; i++) {
						
			for (MutantCombination combinationHandler : combinationsHandler) {
				if(count > 1) return count;
				count += combinationHandler.findCombinations(matrixDna, i);
			}
		}
		
		return count;
	}

	/**
	 * Inicializa los handlers de las combinaciones posibles de una matriz.
	 */
	private List<MutantCombination> initilizeCombinations() {
		
		List<MutantCombination> combinationsHandler = new ArrayList<MutantCombination>();
		combinationsHandler.add(new MutantCombinationHorizontal());
		combinationsHandler.add(new MutantCombinationVertical());
		combinationsHandler.add(new MutantCombinationObliqueRightToLeft());
		combinationsHandler.add(new MutantCombinationObliqueLeftToRight());
		
		return combinationsHandler;
	}
	
}
