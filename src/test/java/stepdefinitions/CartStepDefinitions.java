package stepdefinitions;

import car.CarForm;
import car.CarQuestions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.LoginForm;
import login.LoginTask;
import navegation.Navegation;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class CartStepDefinitions {
    private String actor;
    private String username;
    private String password;

    @Before
    public void seeTheStage() {
        this.actor = "user";
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("I am entry in the application with user (.*) and password (.*)$")
    public void i_am_entry_in_the_application_with_user_and_password(String username, String password)throws Exception {
        theActorCalled(actor).attemptsTo(Navegation.theRequestPage());
        theActorCalled(actor).attemptsTo(Click.on(LoginForm.BUTTON_LOGIN));
        theActorCalled( actor ).attemptsTo( LoginTask.openModal( username, password));
    }

    @When("Users click in categories Laptops")
    public void users_click_in_categories_Laptops() throws InterruptedException {
        Thread.sleep(3000);
        theActorCalled(actor).attemptsTo(Click.on(CarForm.BUTTON_LAPTOPS));
    }

    @When("Users click in macbook Pro")
    public void users_click_in_macbook_Pro() {
        theActorCalled(actor).attemptsTo(Click.on(CarForm.LAPTOP));
    }

    @When("Users click in add to cart")
    public void users_click_in_add_to_cart()  throws InterruptedException{
        theActorCalled(actor).attemptsTo(Click.on(CarForm.BUTTON_ADD_CART));
    }

    @When("user view (.*) Product added")
    public void user_view_Message_Product_added( String message ) throws InterruptedException {

    }

    @Then("user can see the added product in the shopping cart")
    public void user_can_see_the_added_product_in_the_shopping_cart()throws Exception {
        Thread.sleep( 2000 );


        theActorCalled(actor).attemptsTo(Click.on(CarForm.BUTTON_CART));
        String text = Serenity.getWebdriverManager().getCurrentDriver().findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")).getText();

        theActorInTheSpotlight().attemptsTo(
                Ensure.that( text ).contains("MacBook Pro")
        );

    }


}