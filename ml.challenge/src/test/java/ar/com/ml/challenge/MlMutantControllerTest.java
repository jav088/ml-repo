package ar.com.ml.challenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import ar.com.ml.challenge.util.IntegrationTestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MlMutantControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void restMutantOKTest() throws Exception {

		String[] dnaMutante = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		testMutantServiceRest(dnaMutante, HttpStatus.OK);
    }
	
	@Test
    public void restMutantForbiddenNoEsCuadradaTest() throws Exception {

		String[] dnaMutante = {"GCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		testMutantServiceRest(dnaMutante, HttpStatus.FORBIDDEN);
    }
	
	private String testMutantServiceRest(String[] dna, HttpStatus code) throws IOException, Exception {
		
		ResultActions resultAction = mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(IntegrationTestUtil.convertObjectToJsonBytes(dna))).andDo(print());
		
		if(HttpStatus.OK == code) {
			resultAction.andExpect(status().isOk());
		}else {
			resultAction.andExpect(status().isForbidden());
		}

		MvcResult result = resultAction.andReturn();
		return result.getResponse().getContentAsString();
	}
	
}
