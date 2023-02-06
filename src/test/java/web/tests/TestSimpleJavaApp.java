package web.tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.forms.SimpleWebAppStartPage;

public class TestSimpleJavaApp {

    @Test
    public void verifyDivText() {
        AqualityServices.getBrowser().goTo("http://localhost:8085/");
        AqualityServices.getBrowser().maximize();
        String text = new SimpleWebAppStartPage().getDivText();
        Assert.assertEquals(text, "This is div");
        AqualityServices.getBrowser().quit();
    }
}
