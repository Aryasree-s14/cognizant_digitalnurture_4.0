package ForecastTool;

public class Forecast {
	
	public static double futurevalue(double initial,double rate,int time)
	{
		if (time==0)
		{
			return initial;
		}
		else
		{
			return futurevalue(initial,rate,time-1)*(rate+1);
		}
	}

	public static void main(String[] args) 
	{
		double initial=100.0;
		double rate=0.10;
		int time=4;
		double res=futurevalue(initial,rate,time);
		System.out.println("The future value is:"+res);

	}

}
