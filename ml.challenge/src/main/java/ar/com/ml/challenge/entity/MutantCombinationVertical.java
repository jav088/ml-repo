package ar.com.ml.challenge.entity;

public class MutantCombinationVertical extends MutantCombination {

	/**
	 * Busca las combinaciones horizontales en la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(int row) {
	
		String combinacionVertical = "";
		for (int j=0; j<getMatrixDna()[row].length; j++) { 
			combinacionVertical += getMatrixDna()[j][row];
		}
		
		return isDnaMutant(combinacionVertical);
	}

}
