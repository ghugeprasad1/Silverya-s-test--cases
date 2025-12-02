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
	def mappingData = TestDataFactory.findTestData(GlobalVariable.HospitalList)
	
	for (int i = 1; i <= mappingData.getRowNumbers(); i++) {
		
		String dropdownName = mappingData.getValue('DropdownName', i)
		String urlName = mappingData.getValue('URLName', i)
	
		TestObject dynamicHospital = new TestObject('dynamicHospital')
		dynamicHospital.addProperty('xpath', ConditionType.EQUALS,
			"//li[@role='option' and normalize-space()='" + dropdownName + "']")
	
		WebUI.click(findTestObject('Page_MyCareCoverage/hospitalSelector'))
		WebUI.click(dynamicHospital)
		WebUI.click(findTestObject('Page_MyCareCoverage/button__GOHospitalSelector'))
	
		String currentUrl = WebUI.getUrl().toLowerCase()
	
		WebUI.verifyMatch(currentUrl, ".*" + urlName.toLowerCase() + ".*", true)
	
		println("✔ Validated: " + dropdownName + " → " + urlName)
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