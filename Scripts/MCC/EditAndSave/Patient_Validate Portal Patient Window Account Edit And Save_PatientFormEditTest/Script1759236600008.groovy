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
    WebUI.callTestCase(findTestCase('MCC/Patient Entry_HandleCAPTCHA'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), 'monday')

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), 'weekday')

    WebUI.click(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'), '03/07/1977')

    WebUI.waitForElementVisible(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'), 10)

    WebUI.click(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/list_YesAreYouUSCitizen_PatientForm'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'), '302-16-3115')

    WebUI.click(findTestObject('Page_MyCareCoverage/dropdown_Gender'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/dropdown_Gender'), 'Male', FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_AddressLine1_PatientForm'), '123 SW')

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_City'), 'San Jose')

    WebUI.click(findTestObject('Page_MyCareCoverage/input_State_PatientForm'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_State_PatientForm'), 'Kentucky')

    WebUI.click(findTestObject('Page_MyCareCoverage/list_SelectStateOption_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/Page_MyCareCoverage/Page_MyCareCoverage/list_KentuckyStateOption_PatientForm'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_ZipCode_PatientForm'), '95121')

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_HaveHealthInsurance_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_VisitRelatedToAccident_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_CurrentlyIncarcerated_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_InFosterCare_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_60DaysLostHealthInsurance_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_NoIncomeSource_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_LostJobIn6Months_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_Continue_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_AddHouseHoldMember_PatientIntakeEntry'), 
        5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Edit_AddHouseHold'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'), 5)

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Back_AddHouseHoldBottomButton_PatientIntakeEntry'), 
        5)

    WebUI.click(findTestObject('Page_MyCareCoverage - Household/button_Edit_AddHouseHold'))

    WebUI.verifyElementAttributeValue(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), 'value' // <-- this is the attribute to check
        , 'monday' // <-- the expected value
        // <-- the expected value
        , 0 // <-- timeout in seconds
        )

    WebUI.verifyElementAttributeValue(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), 'value' // <-- this is the attribute to check
        , 'weekday' // <-- the expected value
        // <-- the expected value
        , 0 // <-- timeout in seconds
        )
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

