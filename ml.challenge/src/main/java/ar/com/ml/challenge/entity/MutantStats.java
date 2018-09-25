package ar.com.ml.challenge.entity;

public class MutantStats {
	
	private Long mutantsCount;
	private Long humansCount;
	private double ratio;
	
	
	public MutantStats(Long mutantsCount, Long humansCount, double ratio) {
		super();
		this.mutantsCount = mutantsCount;
		this.humansCount = humansCount;
		this.ratio = ratio;
	}
	
	public Long getMutantsCount() {
		return mutantsCount;
	}
	public void setMutantsCount(Long mutantsCount) {
		this.mutantsCount = mutantsCount;
	}
	public Long getHumansCount() {
		return humansCount;
	}
	public void setHumansCount(Long humansCount) {
		this.humansCount = humansCount;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
