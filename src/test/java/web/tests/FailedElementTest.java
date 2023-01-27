package web.tests;

import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;


@Flaky
public class FailedElementTest extends BaseTest{

    @Story("Failed tests story")
    @TmsLink("link on issue")
    @Test
    public static void failedTest() {
        generateRuntimeEx();
        Assert.assertTrue(true);
    }

    private static void generateRuntimeEx() {
        throw new RuntimeException();
    }
}
