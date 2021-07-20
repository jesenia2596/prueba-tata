package signup;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SignUpQuestions implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Serenity.getWebdriverManager().getCurrentDriver().switchTo().alert().getText();
    }

    public static Question<String> value () {
        return new SignUpQuestions() ;
    }
}

