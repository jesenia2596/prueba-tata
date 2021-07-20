package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.LoginForm;
import login.LoginQuestions;
import login.LoginTask;
import navegation.Navegation;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import signup.SignUpForm;
import signup.SignUpTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions  extends PageObject {

    private String actor;
    private String user;
    private String password;

    @Before
    public void seeTheStage(){
        this.actor="user";
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user is page home")
    public void user_is_page_home() {
        theActorCalled( actor ).attemptsTo(Navegation.theRequestPage());;
    }

    @When("Users click in log in")
    public void users_click_in_log_in() {
        theActorCalled(actor).attemptsTo(Click.on(LoginForm.BUTTON_LOGIN));
    }

    @When("I type information in the modal field UserName (.*)$")
    public void i_type_information_in_the_modal_field_UserName(String username)  throws Exception {
        this.user = username;
    }

    @When("I type information in the modal field Password (.*)$")
    public void i_type_information_in_the_modal_field_Password(String password) {
        this.password = password;
    }

    @Then("user view home page (.*)")
    public void user_view_home_page_Welcome(String message)throws Exception {
        theActorCalled( actor ).attemptsTo( LoginTask.openModal( user, password));
        Thread.sleep(2000);
        theActorInTheSpotlight().should(
                seeThat("The user should see his name", LoginQuestions.value(), equalTo(message))
        );
    }

}
