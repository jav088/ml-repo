package ar.com.ml.challenge.entity;

public class MutantStats {
	
	private double mutantsCount;
	private double humansCount;
	private double ratio;
	
	
	public MutantStats(double mutantsCount, double humansCount, double ratio) {
		super();
		this.mutantsCount = mutantsCount;
		this.humansCount = humansCount;
		this.ratio = ratio;
	}
	
	public double getMutantsCount() {
		return mutantsCount;
	}
	public void setMutantsCount(double mutantsCount) {
		this.mutantsCount = mutantsCount;
	}
	public double getHumansCount() {
		return humansCount;
	}
	public void setHumansCount(double humansCount) {
		this.humansCount = humansCount;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
