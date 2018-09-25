package ar.com.ml.challenge.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ar.com.ml.challenge.repository.HumanRepository;

@Component
public class HumanCacheTask {

	@Autowired
	private HumanRepository humanRepository;
	
	/**
	 * Tarea que se ejecuta una vez por segundo para insertar el cache guardado en la base de datos.
	 */
	@Scheduled(fixedRate = 1000)
	public void reportCurrentTime() {
		humanRepository.persistHumans();
	}

}
