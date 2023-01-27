package web.tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.constants.URL;

public abstract class BaseTest {
    private static final String DEFAULT_URL = URL.START_PAGE.getUrl();
    protected final IElementFactory elementFactory;

    protected BaseTest() {
        elementFactory = AqualityServices.getElementFactory();
    }

    @BeforeMethod
    protected void beforeMethod() {
        getBrowser().goTo(DEFAULT_URL);
        getBrowser().maximize();
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

}
