package end2endPOM;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponent {

  WebDriver driver;

  public ConfirmationPage(WebDriver driver) {
    super(driver);
    //TODO Auto-generated constructor stub
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = ".hero-primary")
  WebElement confirmationMessage;

  //Action
  public String getConfirmationMessage() {
    return confirmationMessage.getText();
  }
}
