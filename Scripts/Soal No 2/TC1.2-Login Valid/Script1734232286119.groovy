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

try {
	WebUI.openBrowser('')

	WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

	WebUI.click(findTestObject('Object Repository/Login/btnMakeAppointment'))

	WebUI.setText(findTestObject('Object Repository/Login/inputUsername'), 'John Doe')

	WebUI.setEncryptedText(findTestObject('Object Repository/Login/inputPassword'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

	WebUI.click(findTestObject('Object Repository/Login/btnLogin'))

	boolean isLoginValid = WebUI.verifyElementText(findTestObject('Object Repository/Login/txtMakeAppointment'), 'Make Appointment')

	if (isLoginValid.equals(true)) {
		KeywordUtil.markPassed('Login with valid data successfull')
	} else {
		KeywordUtil.markError('Login with valid Failed')
	}
}
catch (Exception e) {
	KeywordUtil.markFailed('Test failed due to: ' + e.getMessage())
}
finally {
	WebUI.closeBrowser()
}