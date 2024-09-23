package com.Myntra.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int i=0;
	int j=2;

	public boolean retry(ITestResult result) {
		if(i<j) {
                i++;
		return true;
	}
		return false;
}
}
