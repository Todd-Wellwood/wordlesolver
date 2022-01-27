import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<String> wordList;
    static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        driver = new ChromeDriver();
        driver.get("https://www.powerlanguage.co.uk/wordle/");
        WebElement gameBoard = driver.findElement(By.xpath("/html/body"));
        // Load the popup
        Thread.sleep(500);
        // Close the popup
        gameBoard.click();

        //Get the wordlist
        wordList = populateList();

        for (int i = 0; i < 6; i++) {
            gameBoard.sendKeys(wordList.remove(new Random().nextInt(wordList.size())));
            gameBoard.sendKeys(Keys.RETURN);
            Thread.sleep(2500);

        }
    }

    private static ArrayList<String> populateList() throws FileNotFoundException {
        ArrayList<String> returningSet = new ArrayList<>();
        Scanner scan = new Scanner(new FileReader("src/wordlist.txt"));
        while (scan.hasNext())
            returningSet.add(scan.next());
        return returningSet;
    }

    public WebElement expandRootElement(WebElement element) {
        return (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot",element);
    }
}
