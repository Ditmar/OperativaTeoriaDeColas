package queque;

public class Probability {
	private Double pn;
	private Double probabilityAccum;
	private Integer n;
	public Probability(Double pn, Double proacum) {
		this.pn = pn;
		this.probabilityAccum = proacum;
	}
	
	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Double getPn() {
		return pn;
	}
	public void setPn(Double pn) {
		this.pn = pn;
	}
	public Double getProbabilityAccum() {
		return probabilityAccum;
	}
	public void setProbabilityAccum(Double probabilityAccum) {
		this.probabilityAccum = probabilityAccum;
	}
	
}
