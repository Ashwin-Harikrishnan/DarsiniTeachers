package TestScripts;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddAssignmentPage;
import ObjectRepository.AddClassroomPage;
import ObjectRepository.ClassroomPage;
import ObjectRepository.LoginPage;
import ObjectRepository.LogoutPage;
import TestData.ExcelDataImport;
import TestData.TestDataImport;

public class AddAssignmentTest extends BaseClass {
	ClassroomPage classroomObj;
	AddAssignmentPage assignmentObj;
	LoginPage loginObj;
	static TestDataImport TestDataObj;
	static ExcelDataImport excelDataObj;
	static String[] testData;
	LogoutPage logoutObj;
	String actualstring;
	String expectedstring;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		loginObj = new LoginPage(androidDriver);
		classroomObj = new ClassroomPage(androidDriver);
		assignmentObj = new AddAssignmentPage(androidDriver);
		logoutObj = new LogoutPage(androidDriver);
		TestDataObj = new TestDataImport();
		excelDataObj = new ExcelDataImport();
		excelDataObj.readExcel("Sheet1");
		TestDataObj.setFakerData();

	}

	@Test
	public void addAssignmentTest() {
		try {
			loginObj.validLogin();
			classroomObj.assignmentNavigationMethod("Central Integration Planner");
			assignmentObj.addAssignment();
			sleep(1000);
			actualstring = assignmentObj.assignmentNameVerification.getText();
			expectedstring = "Assignment 1";

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertEquals(actualstring, expectedstring);

	}

	@AfterClass
	public void endTest() {
		sleep(1000);
		classroomObj.backBtn.click();
		logoutObj.logout();

	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
