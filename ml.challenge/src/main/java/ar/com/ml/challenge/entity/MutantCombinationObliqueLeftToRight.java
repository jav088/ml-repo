package ar.com.ml.challenge.entity;

public class MutantCombinationObliqueLeftToRight extends MutantCombination {

	/**
	 * Busca las combinaciones oblicuas de izquierda a derecha de la matriz.
	 * @param row
	 */
	@Override
	public Integer findCombinations(int row) {
		
		//Combinacion Diagonal Superior
		String combinacionDiagonalSuperior = "";
	    for (int j=getMatrixDna().length-1; j>=getMatrixDna().length-1-row; j--) { 
	    	combinacionDiagonalSuperior += getMatrixDna()[row+j-getMatrixDna().length+1][j];
	    }
	    
	    //Combinacion Diagonal Inferior
	    String combinacionDiagonalInferior = "";
	    for (int j=0;j<getMatrixDna().length-row-1; j++) { 
	    	combinacionDiagonalInferior += getMatrixDna()[row+j+1][j];
		}
		
		return isDnaMutant(combinacionDiagonalSuperior) + isDnaMutant(combinacionDiagonalInferior);
	}
	
}
