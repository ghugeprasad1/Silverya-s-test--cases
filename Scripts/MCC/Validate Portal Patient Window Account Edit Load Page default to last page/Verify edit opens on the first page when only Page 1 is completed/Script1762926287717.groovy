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

try {
    WebUI.openBrowser('')

    WebUI.navigateToUrl(GlobalVariable.ParkViewStageBaseUrl)

    WebUI.setText(findTestObject('Object Repository/Page_MyCareCoverage/input_Username_last'), GlobalVariable.StageuserName)

    WebUI.setText(findTestObject('Object Repository/Page_MyCareCoverage/input_Password_last'), GlobalVariable.Stagepassword)

    WebUI.click(findTestObject('Page_MyCareCoverage/checkbox_CAPTCHA'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Page_MyCareCoverage/button_Login'))

    WebUI.waitForPageLoad(30)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))

    WebUI.waitForPageLoad(30)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientSearch'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/PatientSearch'), 'kjdncvjiownvhio' //
        //
        //
        //
        )

    WebUI.click(findTestObject('Page_MyCareCoverage/Button_ActionThreeDots'))

    WebUI.click(findTestObject('Page_MyCareCoverage/Button_Edit'))

    // Step 2: Get all open tabs
    WebUI.switchToWindowIndex(1)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Button_EditPatientPageEditButton'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Back_Button'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Next_Button'), 5)

    WebUI.verifyElementHasAttribute(findTestObject('Page_MyCareCoverage/FirstName_Input'), 'disabled', 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Input_AddressLine2'), 0)
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

