package ar.com.ml.challenge.entity;

public class MutantCombinationHorizontal extends MutantCombination {

	/**
	 * Busca las combinaciones horizontales en la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(char[][] matrixDna, int row) {
		
		String combinacionHorizontal = "";
		for (int j=0; j<matrixDna[row].length; j++) { 
			combinacionHorizontal += matrixDna[row][j];
		}
		
		return isDnaMutant(combinacionHorizontal);
	}

}
