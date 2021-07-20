package car;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


public class CarTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(CarForm.BUTTON_LAPTOPS),
                Click.on(CarForm.LAPTOP),
                Click.on(CarForm.BUTTON_ADD_CART),
                Click.on(CarForm.BUTTON_CART)

        );

    }
}
