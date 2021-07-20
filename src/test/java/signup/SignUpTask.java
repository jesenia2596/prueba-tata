package signup;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SignUpTask implements Task {

    private  String username;
    private  String password;

    public SignUpTask( String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static Performable openModal( String user, String password) {
        return instrumented( SignUpTask.class, user, password );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(SignUpForm.INPUT_USERNAME),
                Enter.theValue(password).into(SignUpForm.INPUT_PASSWORD),
                Click.on(SignUpForm.BUTTON_SIGN_UP_RECORD)

        );

    }
}