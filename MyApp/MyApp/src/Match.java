import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Match{
public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\MyApp\\Drivers\\chromedriver.exe");

WebDriver driver = new ChromeDriver();
String url = "https://browserstack.com";
driver.get(url);
// Locating element with text()
WebElement e = driver.findElement(By.xpath("//*[text()='Get started free']"));

System.out.println("Element with text(): " + e.getText() );
driver.quit();
}
}