
public class CarInsurance extends Insurance 
{
	private int kivikaEkatosta;

	public CarInsurance(String onomaAsfalismenoy, int diakeiaSeMines, int kivikaEkatosta) 
	{
		super(onomaAsfalismenoy, diakeiaSeMines);
		this.kivikaEkatosta = kivikaEkatosta;
	}	
	
	//kostos afaelia aftokinitoy 
	public int totalCharge()
	{
		return (this.kivikaEkatosta*this.diakeiaSeMines/60);
	}

}
