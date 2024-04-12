
public class HouseInsurance extends Insurance
{
	private int tetragonikaMentra;

	public HouseInsurance(String onomaAsfalismenoy, int diakeiaSeMines, int tetragonikaMentra) 
	{
		super(onomaAsfalismenoy, diakeiaSeMines);
		this.tetragonikaMentra = tetragonikaMentra;
	}
	
	//kostos asfaleias spitioy
	public int totalCharge()
	{
		return (this.tetragonikaMentra*this.diakeiaSeMines/10);
	}
	
}
