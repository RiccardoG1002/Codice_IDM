package ComponentiTreni;

public class MotriceFrecciaRossa extends Motrice{

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("🚄");
	}

	@Override
	protected double pesoPersonalizzato() {
		return 1000;
	}

	@Override
	protected double pesoTrainabilePersonalizzato() {
		return 140000;
	}

}