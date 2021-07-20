package navegation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import signup.SignUpNavegation;


public class Navegation {


    public static Performable theRequestPage() {
        return Task.where("{0} opens the home page",
                Open.browserOn().the(SignUpNavegation.class));


    }
}

