package figureGeometriche;

public class FiguraUnica {
	
	
	private static FiguraUnica instance = new FiguraUnica();
	
	
	private FiguraUnica() {
		
	}
	
	public static FiguraUnica getInstance() {
		return instance;
	}
}
