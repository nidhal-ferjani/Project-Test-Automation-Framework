package com.selenium.taf.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import com.selenium.taf.data.DataDrivenProvider;

public class GlobalListener implements IAnnotationTransformer2,ITestListener{

	private ITestContext context;
		
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
	
	}

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
		
		

		if (context.getName().contains("Test User Registration with Data Provider")) {
			System.out.println("Transform===============>" + context.getName());
			 
		}else if (method.getName().contains("createInstancesUserRegistrationWithExcelData")) {
			System.out.println("Transform===============>" + method.getName());
			annotation.setDataProvider( DataDrivenProvider.INPUT_DATA_USER_EXCEL);
			annotation.setDataProviderClass(DataDrivenProvider.class);
		}
		

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		this.context = context;
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	
	


}
