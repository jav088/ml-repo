package ar.com.ml.challenge.enums;

import ar.com.ml.challenge.exception.ServiceException;

public enum MutantesEnum {

	A("AAAA"), T("TTTT"), C("CCCC"), G("GGGG");

	private String combination;
	
	MutantesEnum(String combination) {
		this.setCombination(combination);
	}

	public String getCombination() {
		return combination;
	}
	public void setCombination(String combination) {
		this.combination = combination;
	}
	
	public static void validateAdnMutant(String dna) throws ServiceException {
		
		if(!dna.equals(A.name()) && !dna.equals(T.name()) && !dna.equals(C.name()) && !dna.equals(G.name()))
			throw new ServiceException("El valor del compuesto de ADN es invalido, solo admite A,T,C,G");
	}
	
}
