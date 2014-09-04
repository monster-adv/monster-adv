package analysis;

public class temp implements Runnable{
	
	private GenderInfo gender;
	
	public temp(GenderInfo gender)
	{
		this.gender = gender;
		
	}
	@Override
	public void run() {
		
	while(true)
	{
		System.out.println("flag = " + gender.flag + " male : " + gender.male + " female : " + gender.female);
		/*	
		if(gender.male == 1)
		{
			System.out.println("man   :" + gender.male);
			System.out.println("woman :" + gender.female );
			//gender.flag = 1;
		}*/
	}
		// TODO Auto-generated method stub
		
	}
	

}
