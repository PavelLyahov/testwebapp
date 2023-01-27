package web.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class StartForm extends Form {
    private final IButton searchButton = AqualityServices.getElementFactory().getButton(By.xpath("(//input[contains(@value, 'Google')])[2]"), "Label");

    public StartForm() {
        super(By.xpath("(//input[contains(@value, 'Google Search')])[2]"), "Start form");
    }

    public String getSearchButtonText() {
        return searchButton.getAttribute("value");
    }

}
