import java.io.Serializable;

public class RecyclingCenter implements Serializable {
	
	private String code;
	private double tonesOfRecycling;
	
	
	public RecyclingCenter(String code, double tonesOfRecycling) {
		super();
		this.code = code;
		this.tonesOfRecycling = tonesOfRecycling;
	}


	
	
}
