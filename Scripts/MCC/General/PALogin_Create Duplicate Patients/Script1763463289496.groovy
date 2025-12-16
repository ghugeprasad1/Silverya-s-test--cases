import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//Generate ONE unique last name
String lastName = 'LN' + (1..6).collect({
		('a'..'z')[new Random().nextInt(26)]
	}).join()

println("Using LAST NAME for both patients: $lastName")

//Common patient data
Map patientData = [('firstName') : 'Automation', ('lastName') : lastName, ('dob') : '06/06/1984', ('gender') : 'male', ('ssn') : '999-55-6666'
	, ('zip') : '91919']

WebUI.callTestCase(findTestCase('MCC/General/PA_Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_MyCareCoverage/tab_AddPatientLeftNavigation'))

// Patient Name
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), lastName)
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), patientData.firstName)

// DOB
WebUI.click(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'))
WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'), patientData.dob)

// Citizen
WebUI.waitForElementVisible(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'), 10)
WebUI.click(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'))
WebUI.click(findTestObject('Page_MyCareCoverage/list_YesAreYouUSCitizen_PatientForm'))

// SSN
WebUI.setText(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'), patientData.ssn)

// Gender
WebUI.click(findTestObject('Page_MyCareCoverage/dropdown_Gender'))
WebUI.sendKeys(findTestObject('Page_MyCareCoverage/dropdown_Gender'), patientData.gender)

// Address
WebUI.setText(findTestObject('Page_MyCareCoverage/input_AddressLine1_PatientForm'), '123 SW Expressway')
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_City'), 'San Jose')
WebUI.click(findTestObject('Page_MyCareCoverage/input_State_PatientForm'))
WebUI.setText(findTestObject('Page_MyCareCoverage/input_State_PatientForm'), 'Kentucky')
WebUI.setText(findTestObject('Page_MyCareCoverage/input_ZipCode_PatientForm'), patientData.zip)

WebUI.delay(5)

// Checkboxes
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_HaveHealthInsurance_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_VisitRelatedToAccident_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_CurrentlyIncarcerated_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_InFosterCare_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_60DaysLostHealthInsurance_PatientForm'))

// No Income
WebUI.click(findTestObject('Page_MyCareCoverage/button_NoIncomeSource_PatientForm'))
WebUI.click(findTestObject('Page_MyCareCoverage/checkbox_No_LostJobIn6Months_PatientForm'))

// Continue
WebUI.click(findTestObject('Page_MyCareCoverage/button_Continue_PatientForm'))

//Overlay
WebUI.waitForElementClickable(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'), 10)
WebUI.click(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'))

// Verification after Patient Created
WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/button_AddMember_AddHouseHoldPage'), 10)
WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Edit_AddHouseHold'), 10)
WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'), 10)

//Second Patient
WebUI.callTestCase(findTestCase('MCC/General/PA_Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_MyCareCoverage/tab_AddPatientLeftNavigation'))

// Patient Name
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_LastName'), lastName)
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_FirstName'), patientData.firstName)

// DOB
WebUI.click(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'))
WebUI.sendKeys(findTestObject('Page_MyCareCoverage/input_PatientForm_DateOfBirth'), patientData.dob)

// Citizen
WebUI.waitForElementVisible(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'), 10)
WebUI.click(findTestObject('Page_MyCareCoverage/list_AreYouACitizen_PatientForm'))
WebUI.click(findTestObject('Page_MyCareCoverage/list_YesAreYouUSCitizen_PatientForm'))

// SSN
WebUI.setText(findTestObject('Page_MyCareCoverage/input_SSN_PatientForm'), patientData.ssn)

// Gender
WebUI.click(findTestObject('Page_MyCareCoverage/dropdown_Gender'))
WebUI.sendKeys(findTestObject('Page_MyCareCoverage/dropdown_Gender'), patientData.gender)

// Address
WebUI.setText(findTestObject('Page_MyCareCoverage/input_AddressLine1_PatientForm'), '2050 Almeda Way')
WebUI.setText(findTestObject('Page_MyCareCoverage/input_PatientForm_City'), 'San Francisco')
WebUI.click(findTestObject('Page_MyCareCoverage/input_State_PatientForm'))
WebUI.setText(findTestObject('Page_MyCareCoverage/input_State_PatientForm'), 'Illinois')
WebUI.setText(findTestObject('Page_MyCareCoverage/input_ZipCode_PatientForm'), patientData.zip)

WebUI.delay(5)

// Checkboxes
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_HaveHealthInsurance_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_VisitRelatedToAccident_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_CurrentlyIncarcerated_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_InFosterCare_PatientForm'))
WebUI.check(findTestObject('Page_MyCareCoverage/checkbox_No_60DaysLostHealthInsurance_PatientForm'))

// No Income
WebUI.click(findTestObject('Page_MyCareCoverage/button_NoIncomeSource_PatientForm'))
WebUI.click(findTestObject('Page_MyCareCoverage/checkbox_No_LostJobIn6Months_PatientForm'))

// Continue
WebUI.click(findTestObject('Page_MyCareCoverage/button_Continue_PatientForm'))

//Overlay
WebUI.waitForElementClickable(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'), 10)
WebUI.click(findTestObject('Page_MyCareCoverage/button_ContinueOnReviewOverlay_PatientForm'))

// Verification after Patient Created
WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/button_AddMember_AddHouseHoldPage'), 10)
WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Edit_AddHouseHold'), 10)
WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage - Household/button_Continue_AddHouseHold'), 10)

return lastName