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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

try {
    WebUI.callTestCase(findTestCase('MCC/General/PA_Login_CommunityHospital'), [:], FailureHandling.STOP_ON_FAILURE)

    // Open dropdown
    WebUI.verifyElementPresent(findTestObject('Page_MyCareCoverage/hospitalSelector'), 5)

    // Load test data
    def hospitalData = TestDataFactory.findTestData('Data Files/Hospitals')

    // Loop through all hospital names in Excel
    for (def i = 1; i <= hospitalData.getRowNumbers(); i++) {
    String hospitalName = hospitalData.getValue('Hospital Name', i)
	    
	// Select the hospital in dropdown
    TestObject dynamicHospital = new TestObject('dynamicHospital')

    dynamicHospital.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//li[@role='option' and normalize-space()='$hospitalName']")
	// dynamicHospital.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//li[@role='option' and contains(text(), '$hospitalName')]")
    
	WebUI.click(findTestObject('Page_MyCareCoverage/hospitalSelector'))
		
    // Click the hospital
    WebUI.click(dynamicHospital)
	
    // Click Go/Confirm if needed
	WebUI.click(findTestObject('Page_MyCareCoverage/button__GOHospitalSelector'))

    // Validate URL or some element specific to the hospital
    String currentUrl = WebUI.getUrl()

    String cleanHospitalName = hospitalName.replaceAll('\\s', '').toLowerCase()

    String expectedPattern = ('.*' + cleanHospitalName) + '.*'

    WebUI.verifyMatch(currentUrl.toLowerCase(), expectedPattern, true)

    TestObject hospitalDropdownValue = new TestObject('hospitalDropdownValue')

    hospitalDropdownValue.addProperty('xpath', ConditionType.EQUALS, "//div[@id='hospital-select' and text()='$hospitalName')]")

    println('✅ Validation passed for: ' + hospitalName)
    }
    
    WebUI.delay(5) // Optional: reopen dropdown for next iteration
  
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