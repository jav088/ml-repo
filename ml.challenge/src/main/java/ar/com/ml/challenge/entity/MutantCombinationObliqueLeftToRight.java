package ar.com.ml.challenge.entity;

public class MutantCombinationObliqueLeftToRight extends MutantCombination {

	/**
	 * Busca las combinaciones oblicuas de izquierda a derecha de la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(char[][] matrixDna, int row) {
		
		//Combinacion Diagonal Superior
		String combinacionDiagonalSuperior = "";
	    for (int j=matrixDna.length-1; j>=matrixDna.length-1-row; j--) { 
	    	combinacionDiagonalSuperior += matrixDna[row+j-matrixDna.length+1][j];
	    }
	    
	    //Combinacion Diagonal Inferior
	    String combinacionDiagonalInferior = "";
	    for (int j=0;j<matrixDna.length-row-1; j++) { 
	    	combinacionDiagonalInferior += matrixDna[row+j+1][j];
		}
		
		return isDnaMutant(combinacionDiagonalSuperior) + isDnaMutant(combinacionDiagonalInferior);
	}
	
}
