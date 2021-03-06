package queque;

import java.util.ArrayList;

public class QuequeMm1 {
	private Double lambda;
	private Double niu;
	private Double ro;
	private Double Lq;
	private Double Ls;
	private Double Ws;
	private Double Wq;
	private Double c_c;
	private Integer n;
	private ArrayList<Probability> pn;
	private Double probabilityAccum;
	public QuequeMm1 (Double lambda, Double niu, Integer n) {
		this.lambda = lambda;
		this.niu = niu;
		this.n = n;
		this.pn = new ArrayList<Probability>();
		this.probabilityAccum = 0.0;
	}
	private Double calcRo() {
		return this.lambda / this.niu;
	}
	private Double calcPn(Integer n) {
		if (n < 0) {
			System.out.println("No es posible resolver el problema n < 0!");	
			return null;
		}
		return (1 - this.ro) * Math.pow(this.ro, n);
	}
	private Double calcLs() {
		return this.ro / (1 - this.ro);
	}
	private Double calcWs() {
		return 1 / (this.niu - this.lambda);
	}
	private Double calcWq() {
		return this.ro / (this.niu * (1 - this.ro));
	}
	private Double calcLq() {
		return (this.ro * this.ro) / (1 - this.ro);
	}
	private Double calcC(Double ls, Double lq) {
		return ls - lq;
	}
	public void process() {
		if (this.lambda > this.niu) {
			System.out.println("No es posible resolver el problema");
			return;
		}
		this.ro = this.calcRo();
		this.Ls = this.calcLs();
		this.Ws = this.calcWs();
		this.Wq = this.calcWq();
		this.Lq = this.calcLq();
		this.c_c = this.calcC(this.Ls, this.Lq);
		for (Integer i  = 0; i <= this.n; i++) {
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
	public Double getLq() {
		return Lq;
	}
	public void setLq(Double lq) {
		Lq = lq;
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
	public ArrayList<Probability> getPn() {
		return pn;
	}
	public void setPn(ArrayList<Probability> pn) {
		this.pn = pn;
	}
	
}
