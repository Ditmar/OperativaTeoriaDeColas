import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double p0 = 0.01818181818;
		/*ArrayList<Double> u = new ArrayList<>();
		u.add(5.0);
		u.add(15.0);
		u.add(15.0);
		*/
		Double probacum = p0;
		System.out.println("Para 0 Cliente  La p0 = " + p0 + " Probabilidad acumulada " + probacum);
		
		for (Integer i = 1; i < 100; i++) {
			if (i >= 1 && i <= 3) {
				Double p = Math.pow(2, i) * p0;
				probacum += p;
				System.out.println("Para " + i + " Cliente  La p" + i + " = " + p + " Probabilidad acumulada " + probacum);
			} else 
			if (i >= 4 && i <= 6) {
				Double p = Math.pow(2, 3) * p0;
				probacum += p;
				System.out.println("Para " + i + " Cliente  La p" + i + " = " + p + " Probabilidad acumulada " + probacum);
			} else {
				//System.out.println(i-6);
				
				Double potencia = Math.pow(0.66666, (i - 6));
				Double p = 8 * potencia * p0;
				probacum += p;
				System.out.println("Para " + i + " Cliente  La p" + i + " = " + p + " Probabilidad acumulada " + probacum);
			}
			
		}
	}

}
