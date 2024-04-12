
public class MolecularTest extends DiagnosticTest{
	
	private double exactPresent;

	public MolecularTest(String lastName, String date, boolean result, String piece, double exactPresent) {
		super(lastName, date, result, piece);
		this.exactPresent = exactPresent;
	}

	@Override
	public String toString() {
		return "MolecularTest," +super.toString() +" [exactPresent=" + exactPresent + "]";
	}

	
	
	
	
	

}
