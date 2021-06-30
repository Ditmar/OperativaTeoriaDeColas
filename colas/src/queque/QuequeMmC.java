package queque;

import java.util.ArrayList;

public class QuequeMmC {
	private Double lambda;
	private Double niu;
	private Double ro;
	private ArrayList<Probability> pn;
	private Double Lq;
	private Double p0;
	private Double Ls;
	private Double Ws;
	private Double Wq;
	private Double c_c;
	private Integer n;
	private Double probabilityAccum;
	private Integer servers;
	public QuequeMmC(Double lambda, Double niu, Integer c ,Integer n) {
		this.lambda = lambda;
		this.niu = niu;
		this.n = n;
		this.servers = c;
		this.pn = new ArrayList<Probability>();
		this.probabilityAccum = 0.0;
	}
	private Integer fact(Integer n) {
		if (n == 1) {
			return 1;
		}
		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}
	private Double calcRo() {
		return this.lambda / this.niu;
	}
	private Double calcC(Double ls, Double lq) {
		return ls - lq;
	}
	private Double calcP0() {
		if (this.ro / this.servers >= 1) {
			System.out.print("no cumple para la propidad ro/c < 1");
			return null;
		}
		Double totalcalc = 0.0;
		for (Integer n = 0; n < this.servers; n++) {
			Double numerator = Math.pow(this.ro, n);
			Integer nfactorial = fact(n);
			totalcalc += numerator / nfactorial;
		}
		Double nextcalc = Math.pow(this.ro, this.servers); 
		Integer cfactorial = fact(this.servers);
		Double auxGen = 1 / (1 - this.ro / this.servers);
		Double resultden = totalcalc + (nextcalc / cfactorial) * auxGen;
		return 1 / resultden;
	}
	private Double calcPn(Integer n) {
		if (n < this.servers) {
			return (Math.pow(this.ro, n) / fact(n)) * this.p0;
		} else {
			return (Math.pow(this.ro, n) / (fact(this.servers) * Math.pow(this.servers, (n - this.servers)))) * this.p0;
		}
	}
	private Double calcLq() {
		Double num = Math.pow(this.ro, this.servers + 1);
		Integer cfactorial = fact(this.servers - 1);
		Double sum = (this.servers - this.ro);
		Double deno = Math.pow(sum, 2);
		return (num / (cfactorial * deno )) * this.p0;
	}
	private Double calcLs() {
		return this.Lq + this.ro;
	}
	private Double calcWs() {
		return this.Ls / this.lambda;
	}
	private Double calcWq() {
		return this.Lq / this.lambda;
	}
	public void process() {
		this.ro = this.calcRo();
		this.p0 = this.calcP0();
		this.Lq = this.calcLq();
		this.Ls = this.calcLs();
		this.Ws = this.calcWs();
		this.Wq = this.calcWq();
		//this.c_c = this.calcC(this.Ls, this.Lq);
		this.probabilityAccum = this.p0;
		Probability auxpro = new Probability(this.p0, this.probabilityAccum);
		auxpro.setN(0);
		this.pn.add(auxpro);
		for (Integer i  = 1; i <= this.n; i++) {
			Double aux = calcPn(i);
			this.probabilityAccum += aux;
			Probability pro = new Probability(aux, this.probabilityAccum);
			pro.setN(i);
			this.pn.add(pro);
		}
	}
	public Double getLambda() {
		return lambda;
	}
	public void setLambda(Double lambda) {
		this.lambda = lambda;
	}
	public Double getNiu() {
		return niu;
	}
	public void setNiu(Double niu) {
		this.niu = niu;
	}
	public Double getRo() {
		return ro;
	}
	public void setRo(Double ro) {
		this.ro = ro;
	}
	public ArrayList<Probability> getPn() {
		return pn;
	}
	public void setPn(ArrayList<Probability> pn) {
		this.pn = pn;
	}
	public Double getLq() {
		return Lq;
	}
	public void setLq(Double lq) {
		Lq = lq;
	}
	public Double getP0() {
		return p0;
	}
	public void setP0(Double p0) {
		this.p0 = p0;
	}
	public Double getLs() {
		return Ls;
	}
	public void setLs(Double ls) {
		Ls = ls;
	}
	public Double getWs() {
		return Ws;
	}
	public void setWs(Double ws) {
		Ws = ws;
	}
	public Double getWq() {
		return Wq;
	}
	public void setWq(Double wq) {
		Wq = wq;
	}
	public Double getC_c() {
		return c_c;
	}
	public void setC_c(Double c_c) {
		this.c_c = c_c;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Double getProbabilityAccum() {
		return probabilityAccum;
	}
	public void setProbabilityAccum(Double probabilityAccum) {
		this.probabilityAccum = probabilityAccum;
	}
	public Integer getServers() {
		return servers;
	}
	public void setServers(Integer servers) {
		this.servers = servers;
	}
	
}
