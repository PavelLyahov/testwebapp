package web.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import web.logger.MyLogger;

public class MyListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        MyLogger.get().info("On finish");
        MyLogger.get().info(context.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        MyLogger.get().info("On start");
        MyLogger.get().info(context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        MyLogger.get().info("--- Test Started ---");
        MyLogger.get().info(result.getName());
    }

    public void onTestFinish(ITestResult result) {
        MyLogger.get().info("--- Test finished ---");
        MyLogger.get().info(result.getName());
        MyLogger.get().info(String.valueOf(result.getStartMillis() - result.getEndMillis()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        onTestFinish(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        onTestFinish(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        onTestFinish(result);
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        onTestFinish(result);
    }
}
