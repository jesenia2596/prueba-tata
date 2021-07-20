package stepdefinitions;


import net.serenitybdd.screenplay.ensure.Ensure;
import signup.SignUpForm;
import signup.SignUpQuestions;
import signup.SignUpTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import navegation.Navegation;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.Alert;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SignUpStepDefinitions extends PageObject {

    private String actor;
    private String user;
    private String password;

    @Before
    public void seeTheStage(){
        this.actor="user";
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user is in the main page")
    public void user_is_page() {
        theActorCalled( actor ).attemptsTo(Navegation.theRequestPage());;
    }

    @When("user wants to sign Up")
    public void users_click_in_Sign_Up() {
        theActorCalled(actor).attemptsTo(Click.on(SignUpForm.BUTTON_SIGN_UP));
    }

    @When("types information in the field UserName (.*)$")
    public void i_type_information_in_the_field_UserName(String username)  throws Exception { this.user = username; }

    @When("types information in the field  Password (.*)$")
    public void i_type_information_in_the_field_Password(String password) {
       this.password = password;
    }

    @Then("user should be (.*) in the browser")
    public void user_view_in_the_input_create_User(String message)throws Exception {
        theActorCalled( actor ).attemptsTo( SignUpTask.openModal( user, password));
        Thread.sleep( 2000 );
        Alert alert = Serenity.getWebdriverManager().getCurrentDriver().switchTo().alert();
        theActorInTheSpotlight().attemptsTo(
                Ensure.that( alert.getText() ).contains(message)
        );

    }


}





