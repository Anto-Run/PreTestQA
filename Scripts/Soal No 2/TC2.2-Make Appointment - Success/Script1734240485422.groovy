import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil




WebUI.callTestCase(findTestCase('Test Cases/Soal No 2/TC1.2-Login Valid'), [:])

//Defined Data
String facility = "Seoul CURA Healthcare Center"
String applyReadmission = "No" // Yes or No
String healthCareProgram = "None"
String appointmentDate = "10/12/2024" // sesuaikan formatnya
String comment = "Test Make Appointment"


//Input Data
WebUI.selectOptionByValue(findTestObject('Object Repository/Book Appointment/selectFacility'), 
    facility, true)

if(applyReadmission.equalsIgnoreCase("Yes")) {
	WebUI.check(findTestObject('Object Repository/Book Appointment/checkApplyHospitalReadmission'))
}

if(healthCareProgram.equalsIgnoreCase("Medicare")) {
	WebUI.click(findTestObject("Object Repository/Book Appointment/inputMedicarePrograms"))
	
}else if (healthCareProgram.equalsIgnoreCase("Medicaid")) {
	WebUI.click(findTestObject("Object Repository/Book Appointment/inputMedicaidPrograms"))
	
}else if (healthCareProgram.equalsIgnoreCase("None")) {
	WebUI.click(findTestObject("Object Repository/Book Appointment/inputNonePrograms"))
}

WebUI.setText(findTestObject('Object Repository/Book Appointment/inputVisitDate'), appointmentDate)


WebUI.setText(findTestObject("Object Repository/Book Appointment/textareaComment"), comment)
WebUI.click(findTestObject("Object Repository/Book Appointment/btnBookAppointment"))


boolean bookAppointmentSuccess = WebUI.verifyElementText(findTestObject("Object Repository/Book Appointment/verifyBookAppointmentSuccess"), "Appointment Confirmation")

// Verify book appointment and data appointment
if(bookAppointmentSuccess) {
	KeywordUtil.markPassed("Make Appointment Success")
	
	//Verify Data
	WebUI.verifyElementText(findTestObject("Object Repository/Book Appointment/verifyDataFacility"),facility)
	WebUI.verifyElementText(findTestObject("Object Repository/Book Appointment/verifyDataCheckApplyReadmission"), applyReadmission)
	WebUI.verifyElementText(findTestObject("Object Repository/Book Appointment/verifyDataHealthCareProgram"), healthCareProgram)
	WebUI.verifyElementText(findTestObject("Object Repository/Book Appointment/verifyDataDateAppointment"), appointmentDate)
	WebUI.verifyElementText(findTestObject("Object Repository/Book Appointment/verifyDataComment"), comment)
	
}else {
	KeywordUtil.markFailed("Book Appointment Failed")
}

WebUI.closeBrowser()






