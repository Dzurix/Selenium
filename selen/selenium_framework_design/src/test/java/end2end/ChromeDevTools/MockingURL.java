package end2end.ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.fetch.Fetch;

public class MockingURL {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    // kreiranje sesije
    devTools.createSession();
    // pozivanje Fetch komande
    devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

    //pozivanje Listenera

    devTools.addListener(
      Fetch.requestPaused(),
      request -> {
        if (request.getRequest().getUrl().contains("=shetty")) {
          String mockedUrl = request
            .getRequest()
            .getUrl()
            .replace("=shetty", "=BadGuy");

          System.out.println(mockedUrl);

          //nastavljam sa slanjem requesta

          devTools.send(
            Fetch.continueRequest(
              request.getRequestId(),
              Optional.of(mockedUrl),
              Optional.of(request.getRequest().getMethod()),
              Optional.empty(),
              Optional.empty(),
              Optional.empty()
            )
          );
        } else {
          devTools.send(
            Fetch.continueRequest(
              request.getRequestId(),
              Optional.of(request.getRequest().getUrl()),
              Optional.of(request.getRequest().getMethod()),
              Optional.empty(),
              Optional.empty(),
              Optional.empty()
            )
          );
        }
      }
    );

    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    Thread.sleep(3000);
    System.out.println(driver.findElement(By.cssSelector("p")).getText());
  }
}
