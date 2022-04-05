package jokoa;

import java.util.ArrayList;
import java.util.Random;

public class PC extends Jokalari {
	
	private Random random;
	private char[] norabideAukerak;
	

	private PC() {
		super();
		random= new Random();
		norabideAukerak="HB".toCharArray(); //H--> Horizontala
							//B--> Bertikala
	}
	
	public static Jokalari getNeureJok() {
		if (nJok==null) {
			nJok= new PC();
		}
		return nJok;
	}
	
	public void ontziakKokatu() {
		int x,y;
		while (PC.getNeureJok().badagoKokatuGabekoOntzirik()) {
			x=random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
			y= x%10; //hondarra ateratzeko, honek y-ren balioa emango du
			norabidea=chars[]
			neureOntziakKokatu(x,y,norabidea);
			aurkariarenFlota=Jokalari1.getNeureJok().getAurkariarenFlota();
		}
	}
	
}
