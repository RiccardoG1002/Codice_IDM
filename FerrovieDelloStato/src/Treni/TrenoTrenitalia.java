package Treni;

public class TrenoTrenitalia extends Treno {

	@Override
	protected void accendiPersonalizzata() {
		System.out.println("Il treno partirà con un ritardo previsto di 10 minuti \nCi scusiamo per il disagio");
	}

}
