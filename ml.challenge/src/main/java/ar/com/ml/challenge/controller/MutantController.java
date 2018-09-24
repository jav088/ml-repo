package ar.com.ml.challenge.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ml.challenge.entity.MutantStats;
import ar.com.ml.challenge.exception.ServiceException;
import ar.com.ml.challenge.model.Human;
import ar.com.ml.challenge.repository.HumanRepository;
import ar.com.ml.challenge.service.MutantService;

@RestController
public class MutantController {

	private static final Logger LOG = LoggerFactory.getLogger(MutantController.class);
	
	@Autowired
	private MutantService mutantService;
	@Autowired
	private HumanRepository humanRepository;

    @RequestMapping(value = "/mutant", method = RequestMethod.POST)
	public ResponseEntity<String> mutant(@RequestBody String[] dna, HttpServletResponse response) {
    	
    	try {
			Boolean isMutant = mutantService.isMutant(dna);
			Human human = new Human(Arrays.toString(dna), isMutant);
			humanRepository.save(human);
			
			return (isMutant) ? new ResponseEntity<String>(HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		
    	} catch (ServiceException e) {
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			LOG.error("Error al verificar el ADN", e);
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
    }
		
    @RequestMapping(value = "/stats", method = RequestMethod.GET)
	public ResponseEntity<MutantStats> getStats() {
    	
    	try {
			double mutantsCount = humanRepository.countByIsMutant(true);
			double humansCount = humanRepository.count();
			double ratio;
			
			if(humansCount == 0) {
				ratio = 0;
			}else {
				ratio = mutantsCount / humansCount;
			}
			
			MutantStats stats = new MutantStats(mutantsCount, humansCount, ratio);
			return ResponseEntity.ok(stats);

		} catch (Exception e) {
			LOG.error("Error al consultar el servicio", e);
		}
    	
		return new ResponseEntity<MutantStats>(HttpStatus.FORBIDDEN);
    }
    
}

