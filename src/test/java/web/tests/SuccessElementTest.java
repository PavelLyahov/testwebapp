package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.forms.StartForm;

public class SuccessElementTest extends BaseTest {

    @Test
    public static void verifyClearingText() {
        String text = new StartForm().getSearchButtonText();
        Assert.assertTrue(text.contains("Google"));
    }
}
