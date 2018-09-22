package ar.com.ml.challenge.entity;

import java.util.ArrayList;
import java.util.List;

public class MutantCombinationOblique extends MutantCombination {

	/**
	 * Agrega las combinaciones oblicuas de derecha a izquierda y de izquierda a derecha que encuentra en la matriz.
	 * @param dna
	 * @param matrixDna
	 */
	@Override
	public List<String> getCombinations(String[] dna, char[][] matrixDna) {
		
		List<String> combinations = new ArrayList<String>();
		
		for (int i=0;i<matrixDna.length;i++) {
			
			combinations.addAll(addObliqueCombinationsRightToLeft(matrixDna, i));
			combinations.addAll(addObliqueCombinationsLeftToRight(matrixDna, i));
		}
		
		return combinations;
	}
	
	/**
	 * Agrega las combinaciones oblicuas de derecha a izquierda que encuentra en la matriz.
	 * @param matrixDna
	 * @param i
	 */
	private List<String> addObliqueCombinationsRightToLeft(char[][] matrixDna, int i) {

		List<String> combinations = new ArrayList<String>();
		
		// Combinacion Diagonal Superior
		String combinacionDiagonalSuperior = "";
		for (int j=0;j<=i;j++) { 
			combinacionDiagonalSuperior += matrixDna[i-j][j];
		}
		
		// Combinacion Diagonal Inferior
		String combinacionDiagonalInferior = "";
		for (int k=0;k<matrixDna.length-i-1;k++) {
			combinacionDiagonalInferior += matrixDna[matrixDna.length-k-1][k+i+1];
		}
		
		if(combinacionDiagonalSuperior.length() >= 4)
			combinations.add(combinacionDiagonalSuperior);
		
		if(combinacionDiagonalInferior.length() >= 4)
			combinations.add(combinacionDiagonalInferior);
		
		return combinations;
	}
	
	/**
	 * Agrega las combinaciones oblicuas de izquierda a derecha que encuentra en la matriz.
	 * @param matrixDna
	 * @param i
	 */
	private List<String> addObliqueCombinationsLeftToRight(char[][] matrixDna, int i) {

		List<String> combinations = new ArrayList<String>();
		
		//Combinacion Diagonal Superior
		String combinacionDiagonalSuperior = "";
	    for (int j=matrixDna.length-1; j>=matrixDna.length-1-i ;j--) { 
	    	combinacionDiagonalSuperior += matrixDna[i+j-matrixDna.length+1][j];
	    }
	    
	    //Combinacion Diagonal Inferior
	    String combinacionDiagonalInferior = "";
	    for (int j=0;j<matrixDna.length-i-1;j++) { 
	    	combinacionDiagonalInferior += matrixDna[i+j+1][j];
		}
		
		if(combinacionDiagonalSuperior.length() >= 4)
			combinations.add(combinacionDiagonalSuperior);
		if(combinacionDiagonalInferior.length() >= 4)
			combinations.add(combinacionDiagonalInferior);
		
		return combinations;
	}

}
