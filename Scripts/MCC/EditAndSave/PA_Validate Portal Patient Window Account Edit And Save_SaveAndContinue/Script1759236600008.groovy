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
    def lastName = WebUI.callTestCase(findTestCase('MCC/General/Login_FillPatientForm_ParkViewHospital'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/PatientSearch'), lastName)

    WebUI.click(findTestObject('Page_MyCareCoverage/Button_ActionThreeDots'))

    WebUI.click(findTestObject('Page_MyCareCoverage/list_Edit_Actions'))

    WebUI.switchToWindowIndex(1)

    WebUI.click(findTestObject('Page_MyCareCoverage/checkbox_Edit_PatientsTabPageHeader'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/EditModeActivated_Message'), 0)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/button_GotItOnEditOverlay'), 0)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/text_EditOverlayFullText'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/button_GotItOnEditOverlay'))

    WebUI.click(findTestObject('Page_MyCareCoverage - Household/button_Back_PageBottomButton'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Page_MyCareCoverage/Input_AddressLine2'), 'abc')

    WebUI.click(findTestObject('Page_MyCareCoverage/SaveAndContinue_Button'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Patient Information/message_ContinueSaveOverlayTitle'), 
        0)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/button_CancelbtnOnDiscardChangesOverlay'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage - Patient Information/button_SaveChanges_ContinueSaveOverlay'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/Header_Household'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/SaveAndContinue_Button'))

    WebUI.click(findTestObject('Page_MyCareCoverage - Patient Information/button_SaveChanges_ContinueSaveOverlay'))

    WebUI.delay(10)

    WebUI.verifyElementPresent(findTestObject('AuthorizationFormPage/header_AuthorizationFormPageHeader'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/SaveAndContinue_Button'))

    WebUI.click(findTestObject('Page_MyCareCoverage - Patient Information/button_SaveChanges_ContinueSaveOverlay'))

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/header_SupportingDocumentsPage'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage/SaveAndContinue_Button'))

    WebUI.click(findTestObject('Page_MyCareCoverage - Patient Information/button_SaveChanges_ContinueSaveOverlay'))

    WebUI.verifyElementPresent(findTestObject('SubmittedConfirmationPage/header_SubmittedInformationPageHeader'), 0)

    WebUI.verifyElementPresent(findTestObject('SubmittedConfirmationPage/update_AddressLine2InSubmittedConfirmationPage'), 
        0)
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

