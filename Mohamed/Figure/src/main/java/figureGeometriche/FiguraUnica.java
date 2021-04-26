package figureGeometriche;

public class FiguraUnica {
	
	
	private static FiguraUnica instance = null;
	
	
	private FiguraUnica() {
		instance = new FiguraUnica();
	}
	
	public static FiguraUnica getInstance() {
		return instance;
	}
}
