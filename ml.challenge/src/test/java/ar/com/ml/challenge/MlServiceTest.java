package ar.com.ml.challenge;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.ml.challenge.exception.ServiceException;
import ar.com.ml.challenge.service.MutantService;
import ar.com.ml.challenge.service.impl.MutantServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MutantServiceImpl.class})
public class MlServiceTest {

	@Autowired
	private MutantService mutantService;

	@Test
	public void isMutantTrueTest() throws ServiceException {
		
		String[] dnaMutante = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Assert.assertTrue(mutantService.isMutant(dnaMutante));
	}
	
	@Test
	public void isMutantTrueTwoOfLine() throws ServiceException {
		
		String[] dnaMutante = { "AAAAAAAA",
								"CAGTCCTC",
								"TTATGTCC",
								"AGAAGGTT",
								"CGCCTATT",
								"TCAGCGCA",
								"TCACTGCT",
								"TCACTGTC"};
		Assert.assertTrue(mutantService.isMutant(dnaMutante));
	}
	
	@Test
	public void isMutantTrueObliqueHorizontal() throws ServiceException {
		
		String[] dnaMutante = { "CAAAACAA",
								"CAGTCCTC",
								"TTATGTCC",
								"AGAAGGTT",
								"CGCCTATT",
								"TCAGCGCA",
								"TCACTGCT",
								"TCACTGTC"};
		Assert.assertTrue(mutantService.isMutant(dnaMutante));
	}
	
	@Test
	public void isMutantFalseTest() throws ServiceException {
		
		String[] dnaNoMutante = {"ATGCGA", "CAGTGC", "TTATGT", "AGAGGG", "TCCCTA", "TCACTG"};
		Assert.assertFalse(mutantService.isMutant(dnaNoMutante));
	}

	@Test(expected = ServiceException.class)
	public void validateExceptionNotSquareMatrixTest() throws ServiceException {
		
		String[] matrixNotSquare = {"GCGA","CAGC","TTATGT","G","DCCCTA","TCACTG"};
		mutantService.isMutant(matrixNotSquare);
	}
	
	@Test(expected = ServiceException.class)
	public void adnInvalidExceptionTest() throws ServiceException {
		
		String[] dnaMutanteConJ = {"JJGCGK","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		mutantService.isMutant(dnaMutanteConJ);
	}
	
//	@Test
//	public void isMutantDataTest() throws ServiceException {
//		
//		long time_start = System.currentTimeMillis();
//		String[] dnaMutante = {"AAGCGA","CAATAC","TTGAGT","AGAGAG","CCGCTA","TCACTG"};
//		boolean isMutant = true;
//		for (int i = 0; i < 1000000; i++) {
//			long forDateInit = System.currentTimeMillis();
//			isMutant = mutantService.isMutant(dnaMutante);
//			long forDateEnd = System.currentTimeMillis();
//			System.out.println("For: " + ( forDateEnd - forDateInit ) + " milliseconds");
//		}
//		long time_end = System.currentTimeMillis();
//		System.out.println("Completing Test Volume data: " + ( time_end - time_start ) + " milliseconds");
//		Assert.assertTrue(isMutant);
//
//	}
	
}
