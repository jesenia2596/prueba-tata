package contact;

import login.LoginForm;
import login.LoginTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ContactTask implements Task {

    private  String contactEmail;
    private  String contactName;
    private  String message;

    public ContactTask( String contactemail, String contactname, String message) {
        this.contactEmail = contactemail;
        this.contactName = contactname;
        this.message = message;
    }


    public static Performable openModal(String contactemail, String contactname, String message) {
        return instrumented( ContactTask.class, contactemail, contactname,message );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(contactEmail).into(ContactForm.INPUT_CONTACT_EMAIL),
                Enter.theValue(contactName).into(ContactForm.INPUT_CONTACT_NAME),
                Enter.theValue(message).into(ContactForm.INPUT_CONTACT_MESSAGE),
                Click.on(ContactForm.BUTTON_SEND_MESSAGE)

        );

    }
}