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
import com.kms.katalon.core.testobject.ConditionType

try {
    String lastName = WebUI.callTestCase(findTestCase('MCC/General/Patient_Fill Patient Details'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(5)

    WebUI.callTestCase(findTestCase('MCC/General/PA_Login'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/PatientSearch'), lastName)

    WebUI.click(findTestObject('Page_MyCareCoverage/Button_ActionThreeDots'))

    WebUI.click(findTestObject('Page_MyCareCoverage - Patient Information/list_SummaryInActionsButton'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Field_PatientSummary_InsuranceProduct'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Field_PatientSummary_Container'), 5)

    String pageText = WebUI.getText(findTestObject('Page_MyCareCoverage/Field_PatientSummary_Container'))

    boolean correctOrder = (pageText.indexOf('Primary Member') < pageText.indexOf('Insurance Product:')) && (pageText.indexOf(
        'Insurance Product:') < pageText.indexOf('DOB:'))

    WebUI.verifyEqual(correctOrder, true)
	
	// XPath: find Insurance Product after DOB
	String xpathAfterDOB = "//p[contains(text(),'DOB')]/following::p[contains(text(),'Insurance Product')]"
	
	// Find elements
	List<WebElement> insuranceAfterDOB = WebUI.findWebElements(
		new TestObject().addProperty("xpath", ConditionType.EQUALS, xpathAfterDOB), 5)
	
	if (insuranceAfterDOB.size() == 0) {
		WebUI.comment("✅ Insurance Product is NOT present below DOB")
	} 
	else {
		WebUI.comment("❌ Insurance Product found below DOB, count: " + insuranceAfterDOB.size())
		WebUI.takeScreenshot()
		assert false : "Insurance Product is present below DOB"
	}
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

