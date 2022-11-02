package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//moram da naglasim gde su mi feature fajlovi i step definicije
//za to koristim CUCUMBER OPTIONS
@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/features", // folder gde su features fajlovi
  glue = "stepDefinitions", // folder gde su step definicije
  stepNotifications = true, // ovo je neki default
  //tags = "@SmokeTest" // ovde se pokrecu samo koje sam ovako tagovao
  //tags = "@SmokeTest or @RegTest"     ili ovako ako hocu vise tagova da pokrenem
  //tags ="not @SanityTest"    pokrenuti sve osim @SanytyTest
  tags = "@SmokeTest and @RegTest" // ovako pokrecem one koji su oznaceni sa 2 taga
)
public class testRunner {}
