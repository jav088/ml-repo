package ar.com.ml.challenge.entity;

import org.apache.commons.lang3.StringUtils;

import ar.com.ml.challenge.enums.MutantesEnum;

public abstract class MutantCombination {

	protected abstract Integer findCombinations(char[][] matrixDna, int row);

	/**
	 * Evalua a traves de las combinaciones posibles de una lista, si es un ADN
	 * mutante.
	 * 
	 * @return
	 */
	protected int isDnaMutant(String dna) {

		int countA = StringUtils.countMatches(dna, MutantesEnum.A.getCombination());
		int countC = StringUtils.countMatches(dna, MutantesEnum.C.getCombination());
		int countG = StringUtils.countMatches(dna, MutantesEnum.G.getCombination());
		int countT = StringUtils.countMatches(dna, MutantesEnum.T.getCombination());

		return countA + countC + countG + countT;
	}

}
