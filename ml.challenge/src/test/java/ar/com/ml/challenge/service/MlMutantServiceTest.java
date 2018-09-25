package ar.com.ml.challenge.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.ml.challenge.exception.ServiceException;
import ar.com.ml.challenge.service.impl.MutantServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MutantServiceImpl.class})
public class MlMutantServiceTest {

	@Autowired
	private MutantService mutantService;

	@Test
	public void isMutantTrueTest() throws ServiceException {
		
		String[] dnaMutante = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Assert.assertTrue(mutantService.isMutant(dnaMutante));
	}
	
	@Test
	public void isMutantTrueVerticalTest() throws ServiceException {
		
		String[] dnaMutante = {"CTGCGA","CAGTGC","CTATGT","CGAAGG","CGCCTA","TCACTG"};
		Assert.assertTrue(mutantService.isMutant(dnaMutante));
	}
	
	@Test
	public void isMutantFalseTest() throws ServiceException {
		
		String[] dnaNoMutante = {"ATGCGA", "CAGTGC", "TTATGT", "AGAGGG", "TCCCTA", "TCACTG"};
		Assert.assertFalse(mutantService.isMutant(dnaNoMutante));
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
	public void isMutantFalseOneMatchTest() throws ServiceException {
		
		String[] dnaMutante = {"TTGCGA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"};
		Assert.assertFalse(mutantService.isMutant(dnaMutante));
	}
	

	
	@Test
	public void isMutantFalseObliqueHorizontal() throws ServiceException {
		
		String[] dnaMutante = { "CAAAACAA",
								"CAGTCCTC",
								"TTATGTCC",
								"AGAAGGTT",
								"CGCCTATT",
								"TCAGCGCA",
								"TCACTGCT",
								"TCACTGTC"};
		Assert.assertFalse(mutantService.isMutant(dnaMutante));
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
	
	@Test
	public void isMutantDataTest() throws ServiceException {
		
		String[] dnaMutante = {"AAGCGA","CAATAC","TTGAGT","AGAGAG","CCGCTA","TCACTG"};
	
		for (int i = 0; i < 1000000; i++) {
			Assert.assertTrue(mutantService.isMutant(dnaMutante));
		}
	}
	
}
