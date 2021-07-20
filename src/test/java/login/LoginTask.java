package login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {

    private  String username;
    private  String password;

    public LoginTask( String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static Performable openModal(String user, String password) {
        return instrumented( LoginTask.class, user, password );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginForm.INPUT_USERNAME_LOGIN),
                Enter.theValue(password).into(LoginForm.INPUT_PASSWORD_LOGIN),
                Click.on(LoginForm.BUTTON_LOGIN_)

        );

    }
}
