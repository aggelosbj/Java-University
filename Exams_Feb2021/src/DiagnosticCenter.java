
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class DiagnosticCenter {
	
	private ArrayList<Test> tests = new ArrayList<>();
	

	public DiagnosticCenter() {
		
	}
	
	
	public void addTest(Test aTest) {
		tests.add(aTest);
	}
	
	
	 
	public void checkForTest(ArrayList<String> names) {
		
	
		Collections.sort(names);
		
		makeFile();
		
		boolean found;
		
		
		
		for(String name: names) {
			found = false;
			for(Test test: tests ) {
				if (test.getLastName().equals(name)) {
					System.out.println(test.getLastName()+ " has performed a test width the following information:");
					System.out.println(test.toString());
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println(name+" has not performed any test.");
			}
			System.out.println("-------------");
		}
		
		
		
	}
	
	public void makeFile() {
		
		
		try {
			FileOutputStream out = new FileOutputStream("TestedPeople.txt");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void showResults() {
		int positive =0;
		int negative = 0;
		int size = tests.size();
		float posPct;
		float negPct;
		
		
		for(Test test: tests) {
			if(((DiagnosticTest) test).getResult()) {
				positive++;
			}
			else {
				negative++;
			}
		}
		
		posPct = (float) positive/size*100;
		negPct = (float) negative/size*100;
		
		System.out.printf("positive tests: " + positive + "Negative tests: "+ negative +"----" + posPct,negPct);
		
	}
	
	

}
