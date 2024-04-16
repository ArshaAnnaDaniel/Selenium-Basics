package data_provider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] serCredentialsData()
	{
		Object data[][]=new String[3][2];
		
		data[0][0]="arsha23@gmail.com";
		data[0][1]="kochu2328";
		
		data[1][0]="arshaanna23@gmail.com";
		data[1][1]="kochu@28";
		
		data[2][0]="arshaa3@gmail.com";
		data[2][1]="akshay23";
		
		return data;
	}

}
