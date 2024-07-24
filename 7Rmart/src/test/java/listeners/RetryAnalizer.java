package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer {

	int retrylimit=3;
	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
