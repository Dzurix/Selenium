package end2endPOM;

import AbstractComponents.AbstractComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponent {

  WebDriver driver;

  @FindBy(css = "tr td:nth-child(3)")
  private List<WebElement> productNames;

  public OrderPage(WebDriver driver) {
    super(driver);
    //TODO Auto-generated constructor stub
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public Boolean VerifyOrdersDisplay(String productName) {
    Boolean match = productNames
      .stream()
      .anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    return match;
  }
}
