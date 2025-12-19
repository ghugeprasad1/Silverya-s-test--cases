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
import org.openqa.selenium.WebElement as WebElement

try {
	def lastName = WebUI.callTestCase(findTestCase('MCC/General/PatientIntakeForm_Create 2 Patient for Duplicate Test'),
		[:], FailureHandling.STOP_ON_FAILURE)

	WebUI.delay(5)
	WebUI.callTestCase(findTestCase('MCC/General/PA_Login'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))
	
	WebUI.delay(3)
	
    WebUI.executeJavaScript('document.querySelector("button svg[data-testid=\'RefreshIcon\']").closest(\'button\').click();', 
        null)

    // Wait for browser alert
    WebUI.waitForAlert(5)

    // Accept (click OK)
    WebUI.acceptAlert()

    WebUI.delay(5)

    WebUI.setText(findTestObject('Page_MyCareCoverage/PatientSearch'), lastName)

    TestObject scrollbar = findTestObject('Page_MyCareCoverage - Patient Information/scrollBar_PatientTabBottomScroll')

    WebUI.executeJavaScript('arguments[0].scrollLeft = arguments[0].scrollWidth;', [WebUI.findWebElement(scrollbar)])

    // Scroll the window to the rightmost and check first row
    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Patient Information/value_PotentialDuplicateYes_AtFirstRow'), 
        5)

    WebUI.verifyElementClickable(findTestObject('Page_MyCareCoverage - Patient Information/value_PotentialDuplicateYes_AtFirstRow'))

    // Scroll the window to the rightmost and check second row
    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Patient Information/value_PotentialDuplicateYes_AtSecondRow'), 
        5)

    WebUI.verifyElementClickable(findTestObject('Page_MyCareCoverage - Patient Information/value_PotentialDuplicateYes_AtSecondRow'))
}
catch (Exception e) {
    WebUI.comment('❌ Test failed: ' + e.getMessage())

    WebUI.takeScreenshot()

    throw e
} 
// You can log or take a screenshot here if needed
// rethrow for reporting
finally { 
    WebUI.closeBrowser()
}

