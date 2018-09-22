package ar.com.ml.challenge.entity;

import java.util.ArrayList;
import java.util.List;

public class MutantCombinationVertical extends MutantCombination {

	/**
	 * Agrega las combinaciones horizontales que encuentra en la matriz.
	 * @param dna
	 * @param matrixDna
	 */
	@Override
	public List<String> getCombinations(String[] dna, char[][] matrixDna) {

		List<String> combinations = new ArrayList<String>();
		
		for (int i=0;i<matrixDna.length;i++) {
			String combinacionVertical = "";
			for (int j=0;j<matrixDna[i].length;j++) { 
				combinacionVertical += matrixDna[j][i];
			}
			combinations.add(combinacionVertical);
		}
		
		return combinations;
	}

}
