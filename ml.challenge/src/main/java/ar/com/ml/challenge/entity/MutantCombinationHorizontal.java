package ar.com.ml.challenge.entity;

public class MutantCombinationHorizontal extends MutantCombination {

	/**
	 * Busca las combinaciones horizontales en la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(int row) {
		
		String combinacionHorizontal = "";
		for (int j=0; j<getMatrixDna()[row].length; j++) { 
			combinacionHorizontal += getMatrixDna()[row][j];
		}
		
		return isDnaMutant(combinacionHorizontal);
	}

	@Override
	protected String getName() {
		return "Horizontal";
	}

}
