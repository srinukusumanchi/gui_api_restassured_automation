/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-05
 * Created Time: 9:31 a.m.
 */

package bns.a6.microui.web.utility.reporting;

import com.quantum.java.pages.ExtentReportHelper;
import com.quantum.utility.LoggingUtils;
import com.quantum.utils.LogHelper;

import java.io.File;
import java.util.Objects;

public final class ReportPortal {

    private static ReportPortal REPORTPORTALINSTANCE = null;
    private static ExtentReportHelper extentReportHelper;
    public static final String STEP_VALIDATION_FAILED_TEXT = "*********************************************************  Step Validation Failed  ********************************************************* \n";

    public static ExtentReportHelper getExtentReportHelper() {
        if (extentReportHelper == null) {
            setExtentReportHelper(new ExtentReportHelper());
        }
        return extentReportHelper;
    }

    public static void setExtentReportHelper(ExtentReportHelper extentReportHelper) {
        ReportPortal.extentReportHelper = extentReportHelper;
    }

    public static File getScreenshot() {
        return new File(Objects.requireNonNull(ReportPortal.getExtentReportHelper().
                getScreenshot("Screenshot")));
    }

    public ReportPortal() {
        //
    }

    public static void stepInfoWithScreenshot(String message) {
        LoggingUtils.logSuccess(getScreenshot(), "****  Information  **** \n" + message);
    }

    public static void stepInfoWithoutScreenshot(String message) {
        LogHelper.logger.info("*********************************************************  Step Information  ********************************************************* \n" + message);
        LoggingUtils.log("****  Information  **** \n" + message);
    }

    public static void stepPassWithScreenshot(String message) {
        LogHelper.logger.info("*********************************************************  Step Validation Passed  ********************************************************* \n" + message);
        LoggingUtils.logSuccess(getScreenshot(), "****  Step Validation Passed  **** \n" + message);

    }


    public static void stepPassWithoutScreenshot(String message) {
        LogHelper.logger.info("*********************************************************  Step Validation Passed  ********************************************************* \n" + message);
        LoggingUtils.log( "****  Step Validation Passed  **** \n" + message);

    }

    public static void stepFailWithScreenshot(String message) {
        LogHelper.logger.error(STEP_VALIDATION_FAILED_TEXT + message);
        LoggingUtils.logFailure(getScreenshot(), STEP_VALIDATION_FAILED_TEXT + message);
    }

    public static void stepPass(String message) {
        LogHelper.logger.info("*********************************************************  Step Validation Passed  ********************************************************* \n" + message);
    }

    public static void stepFailWithOutScreenshot(String message) {
        LogHelper.logger.error(STEP_VALIDATION_FAILED_TEXT + message);
    }
    public static synchronized ReportPortal getInstance() {
        if (Objects.isNull(REPORTPORTALINSTANCE)) {
            REPORTPORTALINSTANCE = new ReportPortal();
        }
        return REPORTPORTALINSTANCE;
    }

}
