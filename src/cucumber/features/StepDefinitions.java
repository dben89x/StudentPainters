package cucumber.features;

import java.util.List;

import code.Estimate;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
  Estimate estimate = new Estimate();

  @Given("^User chooses \"([^\"]*)\" sections$")
  public void aMethod(String sections) throws Throwable{

  }

  @Then("^Code runs \"([^\"]*)\" times$")
  public void aMethod2() throws Throwable{
    System.out.println("It worked.");
  }

  @And("^\"([^\"]*)\" equals \"([^\"]*)\"$")
  public void testOutput(DataTable table) throws Throwable{
    System.out.println(table);
    List<List<String>> data = table.raw();
    System.out.println(data);
  }
}
