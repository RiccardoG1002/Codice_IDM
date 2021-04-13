package ComponentiTreni;

public class VagoneBagnoTI extends VagoneBagno {

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("🚫");
	}

	@Override
	protected double pesoPersonalizzato() {
		return 1250;
	}
	
	@Override
	protected void pulisciPersonalizzato() {
		System.out.println("Ti piacerebbe!");
	}

}
