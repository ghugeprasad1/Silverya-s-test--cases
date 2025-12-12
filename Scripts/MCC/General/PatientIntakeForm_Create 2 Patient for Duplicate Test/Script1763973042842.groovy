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

WebUI.callTestCase(findTestCase('MCC/General/Patient Entry_HandleCAPTCHA'), [:], FailureHandling.STOP_ON_FAILURE)

// Generate unique last name
String lastName = 'LN' + (1..6).collect({ 
        ('a'..'z')[new Random().nextInt(26)]
    }).join()

println('Generated Last Name: ' + lastName)

//WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Patient Information/header_PatientEntryPageHeader'), 3)
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), lastName)

WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), 'Automation')

WebUI.click(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'))

WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'), '02/02/1990')

WebUI.waitForElementVisible(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'), 5)

WebUI.click(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/list_YesAreYouUSCitizen_PatientForm'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'))

WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'), '199-11-1254')

WebUI.click(findTestObject('Page_MyCareCoverage/dropdown_Gender'))

WebUI.sendKeys(findTestObject('Page_MyCareCoverage/dropdown_Gender'), 'Male', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_MyCareCoverage/input_AddressLine1_PatientForm'), '06 Radisson way')

WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_City'), 'Portland')

WebUI.click(findTestObject('Page_MyCareCoverage/input_State_PatientForm'))

WebUI.setText(findTestObject('Page_MyCareCoverage/input_State_PatientForm'), 'Kentucky')

//WebUI.click(findTestObject('Page_MyCareCoverage/list_SelectStateOption_PatientForm'))
//WebUI.click(findTestObject('Page_MyCareCoverage/Page_MyCareCoverage/Page_MyCareCoverage/list_KentuckyStateOption_PatientForm'))
WebUI.setText(findTestObject('Page_MyCareCoverage/input_ZipCode_PatientForm'), '33212')

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_HaveHealthInsurance_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_VisitRelatedToAccident_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_CurrentlyIncarcerated_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_InFosterCare_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_60DaysLostHealthInsurance_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/button_NoIncomeSource_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_LostJobIn6Months_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/button_Continue_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_AddHouseHoldMember_PatientIntakeEntry'), 
    5)

WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'), 5)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('MCC/General/Patient Entry_HandleCAPTCHA'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), lastName)

WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), 'Automation')

WebUI.click(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'))

WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'), '02/02/1990')

WebUI.waitForElementVisible(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'), 5)

WebUI.click(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/list_YesAreYouUSCitizen_PatientForm'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'))

WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'), '199-11-1254')

WebUI.click(findTestObject('Page_MyCareCoverage/dropdown_Gender'))

WebUI.sendKeys(findTestObject('Page_MyCareCoverage/dropdown_Gender'), 'Male', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_MyCareCoverage/input_AddressLine1_PatientForm'), '06 Radisson way')

WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_City'), 'Portland')

WebUI.click(findTestObject('Page_MyCareCoverage/input_State_PatientForm'))

WebUI.setText(findTestObject('Page_MyCareCoverage/input_State_PatientForm'), 'Kentucky')

//WebUI.click(findTestObject('Page_MyCareCoverage/list_SelectStateOption_PatientForm'))
//WebUI.click(findTestObject('Page_MyCareCoverage/Page_MyCareCoverage/Page_MyCareCoverage/list_KentuckyStateOption_PatientForm'))
WebUI.setText(findTestObject('Page_MyCareCoverage/input_ZipCode_PatientForm'), '33212')

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_HaveHealthInsurance_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_VisitRelatedToAccident_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_CurrentlyIncarcerated_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_InFosterCare_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_60DaysLostHealthInsurance_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/button_NoIncomeSource_PatientForm'))

WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_LostJobIn6Months_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/button_Continue_PatientForm'))

WebUI.click(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_AddHouseHoldMember_PatientIntakeEntry'),
	5)

WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'), 5)

WebUI.delay(5)

// return lastName for Next step input
return lastName

