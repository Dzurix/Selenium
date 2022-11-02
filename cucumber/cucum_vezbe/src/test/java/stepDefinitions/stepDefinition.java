package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

public class stepDefinition {

  @Given("^User is on NetBanking landing page$")
  public void user_is_on_netbanking_landing_page() throws Throwable {
    System.out.println("Navigated to login URL!!!");
  }

  @When(
    "^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$"
  )
  public void user_login_into_application_with_username_something_and_password_something(
    String strArg1,
    String strArg2
  ) throws Throwable {
    System.out.println(strArg1);
    System.out.println(strArg2);
  }

  @Then("^Home page is populated$")
  public void home_page_is_populated() throws Throwable {
    System.out.println("Validated home page");
  }

  @And("^Cards displayed are \"([^\"]*)\"$")
  public void cards_displayed_are_something(String strArg1) throws Throwable {
    System.out.println(strArg1);
  }

  @When("^User sign up with folowing details$")
  public void user_sign_up_with_folowing_details(DataTable data)
    throws Throwable {
    List<List<String>> obj = data.asLists();
    System.out.println(obj.get(0).get(0));
    System.out.println(obj.get(0).get(1));
    System.out.println(obj.get(0).get(2));
  }

  @When("^User login into application with username (.+) and password (.+)$")
  public void user_login_into_application_with_username_and_password(
    String username,
    String password
  ) throws Throwable {
    System.out.println(username);
    System.out.println(password);
  }
}
