
public class DiagnosticTest extends Test{

	protected boolean result;
	protected String piece;
	
	
	public DiagnosticTest(String lastName, String date, boolean result, String piece) {
		super(lastName, date);
		this.result = result;
		this.piece = piece;
	}

	
	
	@Override
	public String toString() {
		return super.toString()+"DiagnosticTest [result=" + result + ", piece=" + piece + "]";
	}



	public Boolean getResult() {
		return result;
	}
	
	
}
