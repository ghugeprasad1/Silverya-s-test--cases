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
    WebUI.callTestCase(findTestCase('MCC/General/Login_FillPatientForm_ParkViewHospital'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_AddHouseholdEnabled'), 0)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/header_HouseHoldPageHeader'), 0)

    WebUI.click(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'))

    WebUI.verifyElementPresent(findTestObject('AuthorizationFormPage/header_AuthorizationFormPageHeader'), 0)

    WebUI.click(findTestObject('AuthorizationFormPage/button_IAmReadyToUploadDocuments'))

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/header_SupportingDocumentsPage'), 0)

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/text_verbiage to confirm supporting documents not required to submit completion'), 
        0)

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/documentType_DriversLicense_PhotoID'), 0)

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/documentType_NoIncomeLetter'), 0)

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/documentType_SocialSecurityCard'), 0)

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/documentType_BirthCertificate_Passport'), 0)

    WebUI.verifyElementPresent(findTestObject('SupportingDocumentsPage/documentType_ProofOfResidency'), 0)

    WebUI.click(findTestObject('SupportingDocumentsPage/button_SubmitInSupportingDocumentsPage'))

    WebUI.verifyElementPresent(findTestObject('SubmittedConfirmationPage/header_SubmittedInformationPageHeader'), 0)
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

