package colas;

import java.util.ArrayList;

import queque.Probability;
import queque.QuequeMm1;
import queque.QuequeMmC;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//escenarios! 
		Double lambda = 16.0;
		Double niu = 5.0;
		
		/*QuequeMm1 mm1 = new QuequeMm1(lambda, niu, 20);
		mm1.process();
		System.out.println("Lambda= " + mm1.getLambda() + " Mu = " + mm1.getNiu());
		System.out.println("Lambda Effec= " + mm1.getLambda() + " RO  = " + mm1.getRo());
		System.out.println("Ls = " + mm1.getLs() + " Lq  = " + mm1.getLq());
		System.out.println("Ws = " + mm1.getWs() + " Wq  = " + mm1.getWq());
		System.out.println("c_c = " + mm1.getC_c());
		ArrayList<Probability> pList = mm1.getPn();
		pList.forEach((item) -> {
			System.out.println("P" + item.getN() + " = " + item.getPn() + "  --- " + item.getProbabilityAccum());
		});*/
		
		QuequeMmC mmc = new QuequeMmC(lambda, niu, 4 ,30);
		mmc.process();
		System.out.println("Lambda= " + mmc.getLambda() + " Mu = " + mmc.getNiu());
		System.out.println("Lambda Effec= " + mmc.getLambda() + " RO  = " + mmc.getRo());
		System.out.println("Ls = " + mmc.getLs() + " Lq  = " + mmc.getLq());
		System.out.println("Ws = " + mmc.getWs() + " Wq  = " + mmc.getWq());
		System.out.println("c_c = " + mmc.getC_c());
		ArrayList<Probability> pList = mmc.getPn();
		pList.forEach((item) -> {
			System.out.println("P" + item.getN() + " = " + item.getPn() + "  --- " + item.getProbabilityAccum());
		});
		//System.out.println(mmc.fact(5));
	}

}
