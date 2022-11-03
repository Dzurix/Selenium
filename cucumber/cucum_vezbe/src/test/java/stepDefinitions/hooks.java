package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

  @Before("@MobileTest") // ovo je ANOTATION  -  izvrsava se pre SVAKOG testa(scenaria) koji naglasimo
  // ako NE NAGLASIMO koje testove, onda se izvrsava na svim u feature fajlu - u sustini onda je ISTI KAO BACKGROUND
  public void beforevaldiation() {
    System.out.println("Before Mobile  hook");
  }

  @After("@MobileTest")
  public void Aftervaldiation() {
    System.out.println("  After Mobile before hook");
  }

  @Before("@WebTest")
  public void beforeWebvaldiation() {
    System.out.println("Before Web  hook");
  }

  @After("@WebTest")
  public void AfterWebvaldiation() {
    System.out.println("  After Web before hook");
  }
}
