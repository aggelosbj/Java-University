
public class AntigenTest extends DiagnosticTest {
	
	private int TimeOfResult;

	public AntigenTest(String lastName, String date, boolean result, String piece, int timeOfResult) {
		super(lastName, date, result, piece);
		TimeOfResult = timeOfResult;
	}

	@Override
	public String toString() {
		return "AntigenTest" + super.toString() + " [TimeOfResult=" + TimeOfResult + "]";
	}

	

	
	
	
	
	
	
	
}
