package ar.com.ml.challenge.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MutantCombinationHorizontal extends MutantCombination {

	/**
	 * Agrega las combinaciones horizontales que encuentra en la matriz.
	 * @param dna
	 * @param matrixDna
	 */
	@Override
	public List<String> getCombinations(String[] dna, char[][] matrixDna) {
		
		List<String> combinations = new ArrayList<String>();
		
		List<String> combinacionesHorizontales = Arrays.asList(dna);
		combinations.addAll(combinacionesHorizontales);
		
		return combinations;
	}

}
