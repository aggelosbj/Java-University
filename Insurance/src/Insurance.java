import java.util.ArrayList;

public abstract class Insurance 
{
	protected String onomaAsfalismenoy;
	protected int diakeiaSeMines;		
	
	public Insurance(String onomaAsfalismenoy, int diakeiaSeMines) 
	{		
		this.onomaAsfalismenoy = onomaAsfalismenoy;
		this.diakeiaSeMines = diakeiaSeMines;
	}
	
	public String getName()
	{
		return(this.onomaAsfalismenoy);
	}
	
	//mias kai den exoyme genikes asfaleies exoume i car i spitioy 
	//tote i methodos einai abstract
	public abstract int totalCharge();
	
	

}
