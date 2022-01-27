import io.netty.util.Timeout;
import org.asynchttpclient.request.body.multipart.part.ByteArrayMultipartPart;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

public class main {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.powerlanguage.co.uk/wordle/");
        // Load the popup
        Thread.sleep(500);
        // Close the popup
        driver.findElement(By.xpath("/html/body")).click();
    }
}
