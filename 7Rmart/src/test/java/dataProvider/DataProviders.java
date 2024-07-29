package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] verifyUserCredentialsData()
	{
		Object data[][]=new Object[3][2];
		
		data[0][0]="56363";
		data[0][1]="admin";
		
		data[1][0]="admin";
		data[1][1]="tyyy";
		
		data[2][0]="fhsh";
		data[2][1]="566";
		
		return data;
	}

}
