package ar.com.ml.challenge.entity;

import java.util.List;

public abstract class MutantCombination {
	
	/**
	 * Retorna las combinaciones posibles.
	 * @param dna
	 * @param matrixDna
	 * @param i
	 * @return
	 */
	public abstract List<String> getCombinations(String[] dna, char[][] matrixDna);
	
}
