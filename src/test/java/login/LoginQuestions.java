package login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class LoginQuestions implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as( actor ).find( LoginForm.WELCOME ).getText();
    }

    public static Question<String> value() {
        return new LoginQuestions();
    }

}
