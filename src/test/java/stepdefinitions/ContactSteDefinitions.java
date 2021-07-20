package stepdefinitions;

import contact.ContactForm;
import contact.ContactTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.LoginForm;
import login.LoginTask;
import navegation.Navegation;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Alert;
import signup.SignUpTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ContactSteDefinitions extends PageObject {

    private String actor;
    private String email;
    private String name;
    private String message;

    @Before
    public void seeTheStage() {
        this.actor = "user";
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user is page home Contact")
    public void user_is_page_home_Contact() {
        theActorCalled(actor).attemptsTo(Navegation.theRequestPage());
    }

    @When("Users click in Contact")
    public void users_click_in_Contact() {
            theActorCalled(actor).attemptsTo(Click.on(ContactForm.BUTTON_CONTACT));
        }

    @When("I type information in the modal field Contact Email(.*)$")
    public void i_type_information_in_the_modal_field_Contact_Email(String email)  throws Exception {
        this.email = email;
    }

    @When("I type information in the modal field Contact Name (.*)$")
    public void i_type_information_in_the_modal_field_Contact_Name(String name) {
        this.name = name;
    }

    @When("I type information in the modal field Message (.*)$")
    public void i_type_information_in_the_modal_field_Message(String message) {
        this.message = message;
    }

    @Then("Message is sent and display (.*)")
    public void message_is_sent( String response )throws Exception {
        theActorCalled( actor ).attemptsTo(ContactTask.openModal(email,name,message));

        Thread.sleep( 2000 );
        Alert alert = Serenity.getWebdriverManager().getCurrentDriver().switchTo().alert();
        theActorInTheSpotlight().attemptsTo(
                Ensure.that( alert.getText() ).contains(message)
        );
    }


}
