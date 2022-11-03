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
  tags = "@PortalTest", // ovde se pokrecu samo koje sam ovako tagovao
  //tags = "@SmokeTest or @RegTest"     ili ovako ako hocu vise tagova da pokrenem
  //tags ="not @SanityTest"    pokrenuti sve osim @SanytyTest
  //tags = "@SmokeTest and @RegTest" // ovako pokrecem one koji su oznaceni sa 2 taga
  plugin = {
    "pretty",
    "html:target/cucumber.html", // ovo je generisanje HTML
    "json:target/cucumber.json", // ovo je JSON file
    "junit:target/cucumber.xml", // ovo koristim za JENKINS
  } // oboji zeleno i crveno u "DEBUG CONSOLE", a i kreira HTML report u TARGET folder
  //dryRun = true // samo proverava da li je svaki SCENARIO iz feature file pravilno mapiran u STEP DEFINITION file
  // dryRun je ZAMENA ZA tidygherkin ako nesto nije mapirano - nece proveravati da li radi,vec samo provera mapiranja
  // monochrome = true // da bude lepsi output u CONSOLE, za VSC ovo ne treba

)
public class testRunner {}
