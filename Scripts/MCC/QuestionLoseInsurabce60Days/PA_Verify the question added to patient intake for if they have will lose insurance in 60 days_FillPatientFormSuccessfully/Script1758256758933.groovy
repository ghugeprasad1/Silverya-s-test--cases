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
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import com.kms.katalon.core.testobject.ConditionType as ConditionType

try {
    // Calculate today's date + 2 days
    Date currentDate = new Date()

    Calendar cal = Calendar.getInstance()

    cal.setTime(currentDate)

    cal.add(Calendar.DATE, 2)

    String futureDate = new SimpleDateFormat('MM/dd/yyyy').format(cal.getTime())

    WebUI.comment('Future date (Today + 2 days): ' + futureDate)

    WebUI.callTestCase(findTestCase('MCC/General/Login_CommunityHospital'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/PatientTab'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_Add Patient'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), 'mongo')

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), 'db')

    WebUI.click(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'), '11/11/1990')

    WebUI.waitForElementVisible(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'), 10)

    WebUI.click(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/list_YesAreYouUSCitizen_PatientForm'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'), '123-45-6789')

    WebUI.click(findTestObject('Page_MyCareCoverage/dropdown_Gender'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/dropdown_Gender'), 'Male', FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_AddressLine1_PatientForm'), '123 SW')

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_City'), 'San Jose')

    WebUI.click(findTestObject('Page_MyCareCoverage/input_State_PatientForm'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_State_PatientForm'), 'Kentucky')

    WebUI.click(findTestObject('Page_MyCareCoverage/list_SelectStateOption_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/Page_MyCareCoverage/Page_MyCareCoverage/list_KentuckyStateOption_PatientForm'))

    WebUI.setText(findTestObject('Page_MyCareCoverage/input_ZipCode_PatientForm'), '95126')

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_HaveHealthInsurance_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_VisitRelatedToAccident_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_CurrentlyIncarcerated_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_InFosterCare_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_Yes_60DaysLostHealthInsurance_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/input_Yes_EnterDate60DaysLostHealthInsurance_PatientForm'))

    WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_Yes_EnterDate60DaysLostHealthInsurance_PatientForm'), futureDate)

    WebUI.click(findTestObject('Page_MyCareCoverage/button_NoIncomeSource_PatientForm'))

    WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_LostJobIn6Months_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_Continue_PatientForm'))

    WebUI.click(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/button_AddMember_AddHouseHoldPage'), 5)

    WebUI.click(findTestObject('Page_MyCareCoverage/button_Edit_AddHouseHoldPage'))

    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/checkbox_Yes_60DaysLostHealthInsurance_PatientForm'), 
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

