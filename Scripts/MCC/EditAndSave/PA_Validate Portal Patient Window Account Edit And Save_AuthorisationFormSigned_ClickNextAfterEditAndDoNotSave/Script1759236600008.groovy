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
    def lastName = WebUI.callTestCase(findTestCase('MCC/General/Login_FillPatientFormForParkView'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/PatientSearch'), lastName)

    WebUI.click(findTestObject('Page_MyCareCoverage/Button_ActionThreeDots'))

    WebUI.click(findTestObject('Page_MyCareCoverage/list_Edit_Actions'))

    WebUI.switchToWindowIndex(1)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_AddHouseholdDisabled'), 0)

    WebUI.verifyElementNotPresent(findTestObject('Page_MyCareCoverage/SaveAndContinue_Button'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/Next_Button'))

    WebUI.verifyElementPresent(findTestObject('AuthorizationFormPage/header_AuthorizationFormPageHeader'), 0)

    WebUI.verifyElementPresent(findTestObject('AuthorizationFormPage/button_DisabledSignAuthorizationForm_GreyedOut'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/checkbox_Edit_PatientsTabPageHeader'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/EditModeActivated_Message'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/button_GotItOnEditOverlay'))

    WebUI.click(findTestObject('AuthorizationFormPage/button_EnabledSignAuthorizationButton_Active'))

    WebUI.verifyElementPresent(findTestObject('AuthorizationForm/signPad_ARForm'), 0)

    WebUI.clickOffset(findTestObject('AuthorizationForm/signPad_ARForm'), 10, 10)

    // Draw a freehand scribble
    WebUI.dragAndDropByOffset(findTestObject('AuthorizationForm/signPad_ARForm'), 30, 10)

    WebUI.dragAndDropByOffset(findTestObject('AuthorizationForm/signPad_ARForm'), 20, 30)

    WebUI.click(findTestObject('Page_MyCareCoverage - Household/button_Back_PageBottomButton'))

    WebUI.verifyElementPresent(findTestObject('AuthorizationFormPage/header_AuthorizationFormPageHeader'), 0)

    WebUI.verifyElementNotPresent(findTestObject('AuthorizationFormPage/link_DownloadSignedAuthorizationForm'), 0)
	
    WebUI.click(findTestObject('Page_MyCareCoverage/Next_Button'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Message_DiscardChanges'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/button_DiscardAndContinueButtonOnDiscardChangesOverlay'))

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/header_SupportingDocumentsPage'), 0)
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

