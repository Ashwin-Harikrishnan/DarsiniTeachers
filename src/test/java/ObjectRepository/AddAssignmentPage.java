package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddAssignmentPage extends BaseClass{
	AndroidDriver<MobileElement> androidDriver;
	//ClassroomPage ClassromObj = new ClassroomPage(androidDriver);
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter assignment name']")
	public AndroidElement assignmentName;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter description']")
	public AndroidElement assignmentDescription;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Upload: PDF, JPEG, TEXT']")
	public AndroidElement assignmentFileUpload;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'dd/mm/yyyy']")
	public AndroidElement assignmentDatepicker;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create']")
	public AndroidElement assignmentConfirm;
	@AndroidFindBy(id = "com.darisni.teacher:id/btn_positive")
	public AndroidElement assignmentPopupConfirm;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create Announcement or Assignment']")
	public AndroidElement createAssignmentStartBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create an assignment']")
	public AndroidElement createAssignmentBtn;
	@AndroidFindBy(id = "com.darisni.teacher:id/txt_card_title")
	public AndroidElement assignmentNameVerification;
	
	
	public void addAssignment() {
		clickWait(createAssignmentStartBtn);
		createAssignmentStartBtn.click();
		clickWait(createAssignmentBtn);
		createAssignmentBtn.click();
		clickWait(assignmentName);
		assignmentName.sendKeys("Assignment 1");
		assignmentDescription.sendKeys("1st assignment in the series");
		assignmentFileUpload.sendKeys("E:\\Random Crap\\Studies\\Resume.pdf");
		assignmentDatepicker.sendKeys("03/02/2021");
		assignmentConfirm.click();
		assignmentPopupConfirm.click();
		
	}
	
	public AddAssignmentPage(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
	
}
