package signup;

import org.openqa.selenium.By;

public class SignUpForm {

    public static By BUTTON_SIGN_UP = By.xpath("/html/body/nav/div[1]/ul/li[8]/a");
    public static By INPUT_USERNAME = By.xpath("//*[@id=\"sign-username\"]");
    public static By INPUT_PASSWORD = By.xpath("//*[@id=\"sign-password\"]");
    public static By BUTTON_SIGN_UP_RECORD = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    public static By MESSAGE = By.xpath("/html/body/div[3]");

}
