package costruzioni;

import figureGeometriche.Cerchio;
import figureGeometriche.Figura;
import figureGeometriche.Quadrato;
import figureGeometriche.Rettangolo;

public class Muratore {
	private String nome;
	
	public Muratore(String nome) {
		this.nome = nome;
    }
	public int calcolaNumeroMattonelle (Figura stanza, Figura mattonella){
		return  (int) Math.ceil(stanza.getArea()/ mattonella.getArea()); 
    }
    public void faiMosaico(Quadrato mattonella){
	    System.out.println("sto costruendo il mosaico… con una mattonella fatta così: " + mattonella); 
    }
   
	public void costruisciOblo(Cerchio vetro) {
	    System.out.println("sto posizionando vetro per una finestra a forma di: "  + vetro);
	    	
	}
} 

