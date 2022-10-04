package end2end.ChromeDevTools;

import com.github.dockerjava.transport.DockerHttpClient.Request;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;
import org.openqa.selenium.devtools.v103.network.model.Response;
import org.openqa.selenium.devtools.v104.io.IO.ReadResponse;

public class NetworkLogActivity {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();

    DevTools devTools = driver.getDevTools();

    devTools.createSession();
    //sve komande gledamo u ChromeDevTolls Protocol

    devTools.send(
      Network.enable(Optional.empty(), Optional.empty(), Optional.empty())
    );

    devTools.addListener(
      Network.requestWillBeSent(),
      request -> {
        org.openqa.selenium.devtools.v103.network.model.Request req = request.getRequest();
        // System.out.println(req.getUrl());
        //req.getHeaders()
      }
    );

    //Event will get fired

    devTools.addListener(
      Network.responseReceived(),
      response -> {
        Response res = response.getResponse();
        //  System.out.println(res.getUrl());
        // System.out.println(res.getStatus());

        // ako hocemo da logujemo samo status code 400, tj. gresku
        if (res.getStatus().toString().startsWith("4")) {
          System.out.println(
            res.getUrl() + "is failing with status code" + res.getStatus()
          );
        }
      }
    );

    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
  }
}
