package web.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SimpleWebAppStartPage extends Form {
    private final ILabel divLabel = AqualityServices.getElementFactory().getLabel
            (By.xpath("//div[contains(text(), 'This is div')]"), "Label");

    public SimpleWebAppStartPage() {
        super(By.xpath("//div[contains(text(), 'This is div')]"), "Start form");
    }

    public String getDivText() {
        return divLabel.getText();
    }
}
