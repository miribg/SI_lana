package jokoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import bista.OntziNorabidea;

public class Flota {
	private int dirua;
	private ArrayList<Ontzi> unekoOntziZer;
	private ArrayList<Ontzi> ontziDesb;
	//Ez da hobeto OntziZer klasea sortzea?
	private Map<Ontzi,  Integer> zenbat;
	private ArrayList<Arma> armamentuZer;
	
	public Flota() {
		dirua=25;
		unekoOntziZer= new ArrayList<Ontzi>();
		ontziDesb= new ArrayList<Ontzi>();
		zenbat= new HashMap<Ontzi, Integer>();
		ontziakSortu();
		armamentuZer= new ArrayList<Arma>();
		armamentuaGehitu();
	}
	
	/*private Iterator<String> getIteradoreA(){
		return armamentuZer.iterator();
	}*/
	
	private Iterator<Ontzi> getIteradoreaO(){
		return unekoOntziZer.iterator();
	}
	
	private Iterator<Ontzi> getIteradoreaDesb(){
		return ontziDesb.iterator();
	}
	
	private void ontziakSortu() {
		OntziFactory nFact = OntziFactory.getNireOntziFact();
		OntziNorabidea on= OntziNorabidea.getNireOntziNorabidea();
		char orientazioa=on.getOrientazioa();
		Ontzi berria= nFact.createOntzi(4, orientazioa);
		//hegazkin ontzi bat
		zenbat.put(berria, 1);
		ontziDesb.add(berria);
		//4 Fragata izango ditugu
		berria= nFact.createOntzi(1, orientazioa);
		zenbat.put(berria, 4);
		ontziDesb.add(berria);
		// hiru suntsitzaile
		berria= nFact.createOntzi(2, orientazioa);
		zenbat.put(berria, 3);
		ontziDesb.add(berria);
		//bi itsaspeko
		berria= nFact.createOntzi(3, orientazioa);
		zenbat.put(berria, 2);
		ontziDesb.add(berria);
	}
	
	private void armamentuaGehitu() {
		Arma a;
		for (int i=0; i<3; i++) {
			a=new Radarra();
			armamentuZer.add(a);
			a= new Bonba();
			armamentuZer.add(a);
			a= new Misila();
			armamentuZer.add(a);
			a=new Ezkutua();
			armamentuZer.add(a);
		}
	}
	
	public void gehituOntzi(Ontzi pOntzi) {
		unekoOntziZer.add(pOntzi);
		if (unekoOntziZer.size()==10) {
			motaHonetakoLimiteaPasa();
		}
		System.out.println(unekoOntziZer.size()+" unekoOntziTamaina, FLOTA");
	}
	private boolean motaHonetakoOntzirikInprima (Ontzi pOntzi) {
		int kont=0;
		int limite=zenbat.get(pOntzi);
		System.out.println(limite+"limite, FLOTA"+pOntzi);
		Iterator<Ontzi> itr= getIteradoreaO();
		Ontzi o;
		boolean inprima=true;
		System.out.println(pOntzi.getMota()+"mota2");
		while (itr.hasNext()&& kont< limite) {
			o= itr.next();
			if (o.getMotaBera(pOntzi.getMota())) { //pOntziren eta o-ren egoera bera
				kont++;
				System.out.println(kont+"*******************************************");
			}
		} if (kont==limite) {	//jada ontzi nahiko mota horretakoak
			inprima=false;	
		}
		System.out.println(inprima+"mota2---------");
		return inprima;
	}
	
	public Ontzi[] lortuOntziPosibleak(){
		motaHonetakoLimiteaPasa();
		Iterator<Ontzi> itr= getIteradoreaDesb();
		Ontzi o;
		Ontzi[] emaitza= new Ontzi[4];	//gehienez 4 ontzi mota egongo dira
		int i=0;
		while (itr.hasNext()) {
			o=itr.next();
			emaitza[i]=o;
			i++;
		}
		return emaitza;
	}
	
	private void motaHonetakoLimiteaPasa () {
		Iterator<Ontzi> itr= getIteradoreaDesb();
		Ontzi o=null;
		if (!ontziDesb.isEmpty()) {
			o= itr.next();
		}
		while (motaHonetakoOntzirikInprima(o) && itr.hasNext()) {
			o=itr.next();
		} if (!motaHonetakoOntzirikInprima(o)) {//jada badaude ontzi kop max
			ontziDesb.remove(o);
			System.out.println("11111111111111111");
		}
	}
	
	public boolean ontziDenakKokatuta () {
		System.out.println(ontziDesb.size()+"/////////////////////////");
		return ontziDesb.size()==0;
	}

	public boolean ontziDenakAurkituta() {
		return unekoOntziZer.size()==0;
	}

	public void ontziaKendu(Ontzi pOntzi) {
		unekoOntziZer.remove(pOntzi);
	}


}
