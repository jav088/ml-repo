package ar.com.ml.challenge.entity;

public class MutantCombinationVertical extends MutantCombination {

	/**
	 * Busca las combinaciones horizontales en la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(char[][] matrixDna, int row) {
	
		String combinacionVertical = "";
		for (int j=0; j<matrixDna[row].length; j++) { 
			combinacionVertical += matrixDna[j][row];
		}
		
		return isDnaMutant(combinacionVertical);
	}

}
