package ar.com.ml.challenge.repository.custom;

import ar.com.ml.challenge.model.Human;

public interface HumanRepositoryCustom {

	/**
	 * Almacena los humanos en el cache.
	 * @param human
	 */
	public Human saveCacheHuman(Human human);

	/**
	 * Persiste los Humanos en la base de datos.
	 */
	public void persistHumans();
	
}
