package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Comands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element){
        try {
            waitElementBeVisible(element, 10000);
            getDriver().findElement(element).click();
            System.out.println("************ Clicou no elemento ************");
        } catch(Exception e){
            System.out.println("************ Ocorreu um erro ao tentar clicar no elemento ************" + element);
            System.out.println(e);
        }
    }

    public static void fillField(By element, String value){
        try {
            waitElementBeClickable(element, 10000);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("Preencheu o campo: " + element);
        } catch(Exception error){
            System.out.println("************ Ocorreu um erro ao tentar preencher o campo ************" + element);
            System.out.println(error);
        }
    }

    public static void checkMessage(By element, String expectedMessage) {
        String actualMessage = "";

        waitElementBeVisible(element, 10000);
        actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals("Erro ao validar mensagem!", expectedMessage, actualMessage);
    }
}
