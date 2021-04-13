package ComponentiTreni;

public class MotriceTrenitalia extends Motrice {

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("🚈");
	}

	@Override
	protected double pesoPersonalizzato() {
		return 1100;
	}

	@Override
	protected double pesoTrainabilePersonalizzato() {
		return 130000;
	}

}
