package ar.com.ml.challenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import ar.com.ml.challenge.util.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MlMutantControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void restIsMutantOKTest() throws Exception {

		String[] dnaMutante = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		testMutantServiceRest(dnaMutante, HttpStatus.OK);
    }
	
	@Test
	public void isMutantTrueVerticalTest() throws Exception {
		
		String[] dnaNoMutante = {"ATGCGA", "CAGTGC", "TTATGT", "AGAGGG", "TCCCTA", "TCACTG"};
		testMutantServiceRest(dnaNoMutante, HttpStatus.FORBIDDEN);
	}
	
	@Test
    public void restIsMutantForbiddenNoEsCuadradaTest() throws Exception {

		String[] dnaMutante = {"GCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		testMutantServiceRest(dnaMutante, HttpStatus.FORBIDDEN);
    }
	
	@Test
    public void restGetIsMutantOkTest() throws Exception {

		ResultActions resultAction = this.mockMvc.perform(get("/stats")).andDo(print());
		
	    System.out.println(resultAction);
    }
	
	private String testMutantServiceRest(String[] dna, HttpStatus code) throws IOException, Exception {
		
		ResultActions resultAction = mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JsonUtil.convertObjectToJsonBytes(dna)));
		
		if(HttpStatus.OK == code) {
			resultAction.andExpect(status().isOk());
		}else {
			resultAction.andExpect(status().isForbidden());
		}

		MvcResult result = resultAction.andReturn();
		return result.getResponse().getContentAsString();
	}
	
}
