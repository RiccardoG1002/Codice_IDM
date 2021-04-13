package ComponentiTreni;

public class VagoneBagnoFR extends VagoneBagno {

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("🚽");
	}

	@Override
	protected double pesoPersonalizzato() {
		return 1200;
	}
	
	@Override
	protected void pulisciPersonalizzato() {
		System.out.println("Il bagno è pulito!");
	}

}
