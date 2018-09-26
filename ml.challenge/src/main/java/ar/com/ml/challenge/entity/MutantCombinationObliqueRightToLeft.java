package ar.com.ml.challenge.entity;

public class MutantCombinationObliqueRightToLeft extends MutantCombination {

	/**
	 * Busca las combinaciones oblicuas de derecha a izquierda en la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(char[][] matrixDna, int row) {
		
		// Combinacion Diagonal Superior
		String combinacionDiagonalSuperior = "";
		for (int j=0; j<=row; j++) { 
			combinacionDiagonalSuperior += matrixDna[row-j][j];
		}

		// Combinacion Diagonal Inferior
		String combinacionDiagonalInferior = "";
		for (int k=0; k<matrixDna.length-row-1; k++) {
			combinacionDiagonalInferior += matrixDna[matrixDna.length-k-1][k+row+1];
		}
		
		return isDnaMutant(combinacionDiagonalSuperior) + isDnaMutant(combinacionDiagonalInferior);
	}

}
