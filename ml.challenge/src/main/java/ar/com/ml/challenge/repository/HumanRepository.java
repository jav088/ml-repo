package ar.com.ml.challenge.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.com.ml.challenge.model.Human;
import ar.com.ml.challenge.repository.custom.HumanRepositoryCustom;

@RepositoryRestResource(collectionResourceRel = "humans", path = "humans")
public interface HumanRepository extends PagingAndSortingRepository<Human, Long>, HumanRepositoryCustom {

	List<Human> findByIsMutant(@Param("isMutant") Boolean isMutant);

	Long countByIsMutant(@Param("isMutant") Boolean isMutant);
	
}
