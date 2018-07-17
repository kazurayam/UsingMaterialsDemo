import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.carmina.material.FileType
import com.kazurayam.carmina.material.Helpers
import com.kazurayam.carmina.material.MaterialRepository
import com.kazurayam.carmina.material.MaterialRepositoryFactory

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable as GlobalVariable


/**
 * Take a screenshot of a Web page, save PNG file to make it a Material
 */
WebUI.openBrowser('')
WebUI.navigateToUrl('http://demoaut.katalon.com/')
WebUI.maximizeWindow()
WebUI.verifyElementPresent(findTestObject('Page_CURA Healthcare Service/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

Path pngFile = mr.resolveScreenshotFileAsMaterial(GlobalVariable.CURRENT_TESTCASE_ID, WebUI.getUrl())
WebUI.takeScreenshot(pngFile.toString())
WebUI.comment("saved a screenshot into ${pngFile.toString()}")

Path pngFileOnceMore = mr.resolveScreenshotFileAsMaterial(GlobalVariable.CURRENT_TESTCASE_ID, WebUI.getUrl())
WebUI.takeScreenshot(pngFileOnceMore.toString())
WebUI.comment("saved a screenshot into ${pngFileOnceMore.toString()}")

WebUI.closeBrowser()

