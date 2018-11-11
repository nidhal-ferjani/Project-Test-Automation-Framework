package com.selenium.taf.tests.factories;


import org.testng.annotations.Factory;

import com.selenium.taf.data.DataDrivenProvider;
import com.selenium.taf.tests.UserRegistrationParallelTesting;
import com.selenium.taf.tests.UserRegistrationWithDDTAndDataProviderTest;

public class FactoryUserRegistrationWithDDT {
	
	
	
    
	@Factory(dataProvider=DataDrivenProvider.INPUT_DATA_USER_PROVIDER, dataProviderClass =DataDrivenProvider.class,enabled=false)
	public Object[] createInstancesUserRegistrationWithDataProvider(String gender, String firstName, String lastName, 
			                                                        String email, String oldPassword) {
	   	      return new Object[] {new UserRegistrationWithDDTAndDataProviderTest(gender,firstName, 
		                                                                          lastName, email, oldPassword)};
		
	
	}
	
	@Factory(dataProvider=DataDrivenProvider.INPUT_DATA_USER_EXCEL, dataProviderClass =DataDrivenProvider.class,enabled=false)
	public Object[] createInstancesUserRegistrationWithExcelData(String gender, String firstName, String lastName, String email, String oldPassword) {
	   	      return new Object[] {new UserRegistrationWithDDTAndDataProviderTest(gender,firstName, 
		                                                                          lastName, email, oldPassword)};
	
	}
	
	@Factory(dataProvider=DataDrivenProvider.INPUT_DATA_USER_CSV, dataProviderClass =DataDrivenProvider.class,enabled=false)
	public Object[] createInstancesUserRegistrationWithCSVData(String gender, String firstName, String lastName, String email, String oldPassword) {
	   	      return new Object[] {new UserRegistrationWithDDTAndDataProviderTest(gender,firstName, 
		                                                                          lastName, email, oldPassword)};
	
	}
	
	
	@Factory(dataProvider=DataDrivenProvider.INPUT_DATA_USER_JSON, dataProviderClass =DataDrivenProvider.class,enabled=false)
	public Object[] createInstancesUserRegistrationWithJSONData(String gender, String firstName, String lastName, String email, String oldPassword) {
	   	      return new Object[] {new UserRegistrationWithDDTAndDataProviderTest(gender,firstName, 
		                                                                          lastName, email, oldPassword)};
	
	}
	
	@Factory(dataProvider=DataDrivenProvider.INPUT_DATA_USER_FAKER_DATA, dataProviderClass =DataDrivenProvider.class,enabled=false)
	public Object[] createInstancesUserRegistrationWithFakerData(String gender, String firstName, String lastName, String email, String oldPassword) {
	   	      return new Object[] {new UserRegistrationWithDDTAndDataProviderTest(gender,firstName, 
		                                                                          lastName, email, oldPassword)};
	
	}
	
	@Factory(dataProvider=DataDrivenProvider.INPUT_DATA_USER_FAKER_DATA, dataProviderClass =DataDrivenProvider.class)
	public Object[] createInstancesUserRegistrationWithFakerDataParellelGrid(String gender, String firstName, String lastName, String email, String oldPassword) {
	   	      return new Object[] {new UserRegistrationParallelTesting(gender,firstName, 
		                                                                          lastName, email, oldPassword)};
	
	}
}
