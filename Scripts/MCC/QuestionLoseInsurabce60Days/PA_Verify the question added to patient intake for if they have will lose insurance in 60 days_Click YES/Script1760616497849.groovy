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
    WebUI.callTestCase(findTestCase('MCC/General/Login_CommunityHospital'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_Add Patient'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Text_NewQuestiontToLoseInsuranceIn60Days'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/CheckBox_LostInsuranceQuestion_Yes'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/CheckBox_LostInsuranceQuestion_No'), 5)

    WebUI.click(findTestObject('Page_MyCareCoverage/checkbox_Yes_60DaysLostHealthInsurance_PatientForm'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_Yes_EnterDate60DaysLostHealthInsurance_PatientForm'), '11/11/2025')
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

