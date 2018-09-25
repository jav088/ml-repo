package ar.com.ml.challenge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ML_HUMAN")
public class Human implements Serializable {

	private static final long serialVersionUID = -2780800658405169538L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="DNA")
	private String dna;
	
	@Column(name="IS_MUTANT")
	private Boolean isMutant;

	public Human() {
	}

	public Human(String dna, Boolean isMutant) {
		super();
		this.dna = dna;
		this.isMutant = isMutant;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public Boolean getIsMutant() {
		return isMutant;
	}
	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}
	
}
