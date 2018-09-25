package ar.com.ml.challenge.repository.custom.impl;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;

import ar.com.ml.challenge.model.Human;
import ar.com.ml.challenge.repository.HumanRepository;
import ar.com.ml.challenge.repository.custom.HumanRepositoryCustom;

public class HumanRepositoryImpl implements HumanRepositoryCustom {

	@Autowired
	private HumanRepository humanRepository;
	@Autowired
	private CacheManager cacheManager;

	
	@CachePut(value="humans")
	public Human saveCacheHuman(Human human) {
		return human;
	}

	@Override
	public void persistHumans() {

		Cache cache = cacheManager.getCache("humans");
		ConcurrentHashMap<Human, Human> cacheMap = (ConcurrentHashMap<Human, Human>) cache.getNativeCache();
		
		if(cacheMap.size() > 0) {
			humanRepository.saveAll(cacheMap.values());
			cache.clear();			
		}
	}

}
