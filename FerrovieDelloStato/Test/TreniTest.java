import NegozioTreni.VenditoreTreni;
import Treni.Treno;

public class TreniTest {

	public static void main(String[] args) {
		VenditoreTreni venditore = new VenditoreTreni();
		try {
			Treno treno = venditore.ordinaTreno("MPPPPPB", 0);
			treno.accendi();
			treno.mostra();
			treno.aggiungiPasseggeri(300);
			System.out.println("Il treno pesa: " + treno.peso());
			treno.aggiungiPasseggeri(11);
			System.out.println("Il treno pesa: " + treno.peso());
			venditore.aggiungiCarrozza("PPBRR", 0, treno);
			treno.accendi();
			treno.mostra();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}