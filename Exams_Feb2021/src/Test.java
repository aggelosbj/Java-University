
public class Test {
	
	protected String LastName;
	protected String date;
	
	
	public Test(String lastName, String date) {
		LastName = lastName;
		this.date = date;
	}

	
	

	@Override
	public String toString() {
		return "Test [date=" + date + "]";
	}




	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
	



	
	
	
	
	

}
