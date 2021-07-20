package contact;

import org.openqa.selenium.By;

public class ContactForm {
    public static By BUTTON_CONTACT = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    public static By INPUT_CONTACT_EMAIL = By.xpath("//*[@id=\"recipient-email\"]");
    public static By INPUT_CONTACT_NAME = By.xpath("//*[@id=\"recipient-name\"]");
    public static By INPUT_CONTACT_MESSAGE = By.xpath("//*[@id=\"message-text\"]");
    public static By BUTTON_SEND_MESSAGE = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");

}

