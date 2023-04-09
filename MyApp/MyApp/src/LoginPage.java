
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class LoginPage extends Customer
{
private static final String FORM_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
private static final String Bank_ManagerLoginXpath ="//button[contains(text(),'Bank Manager Login')]";
private static final String Add_customerXpath = "//button[contains(text(),'Add Customer')]";
private static String First_NameXpath = "//input[@placeholder='First Name']";
private static String Last_NameXpath = "//input[@placeholder='Last Name']";
private static String PostcodeXpath =   "//input[@placeholder='Post Code']"; 
private static String SUBMIT_ID = "//button[@type='submit']";
private ChromeDriver driver;

public LoginPage()  {
 driver = new ChromeDriver();   
}
public void loadrUrl(){
driver.get(FORM_URL);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
driver.findElement(By.xpath (Bank_ManagerLoginXpath)).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
driver.findElement(By.xpath(Add_customerXpath)).click();
}
public void fillForm(Customer customer) {
    driver.findElement(By.xpath(First_NameXpath)).sendKeys(customer.getFirstName());    
    driver.findElement(By.xpath(Last_NameXpath)).sendKeys(customer.getLastName());
    driver.findElement(By.xpath(PostcodeXpath)).sendKeys(customer.getPostCode());
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
} 
public void submitForm(){
driver.findElement(By.xpath(SUBMIT_ID)).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
driver.switchTo().alert().accept();
}
public void verifyCustomer()
{
    driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();;
}
public void closing(){
driver.close();
}
    public static void main(String[] args) {
        LoginPage registrationPage = new LoginPage();
        List<Customer> customers = new ArrayList<>();
        Customer cust= new Customer();
        cust.setFirstName("Christopher");
        cust.setLastName("Connely");
        cust.setPostCode("L789C349");
		
		Customer customer1 = new Customer();
        customer1.setFirstName("Frank");
        customer1.setLastName("Christopher");
        customer1.setPostCode("A897N450");
		
		Customer customer2 = new Customer();
        customer2.setFirstName("Christopher");
        customer2.setLastName("Minka");
        customer2.setPostCode("M098Q585");
		
		Customer customer3 = new Customer();
        customer3.setFirstName("Connely");
        customer3.setLastName("Jackson");
        customer3.setPostCode("L789C349");
		
		Customer customer4 = new Customer();
        customer4.setFirstName("Jackson");
        customer4.setLastName("Frank");
        customer4.setPostCode("L789C349");
		
		Customer customer5 = new Customer();
        customer5.setFirstName("Minka");
        customer5.setLastName("Jackson");
        customer5.setPostCode("A897N450");
		
		Customer customer6 = new Customer();
        customer6.setFirstName("Jackson");
        customer6.setLastName("Connely");
        customer6.setPostCode("L789C349");
		
		customers.add(cust);
        customers.add(customer1);
        customers.add(customer2);
		customers.add(customer3);
        customers.add(customer4);
		customers.add(customer5);
        customers.add(customer6); 

        for (int i = 0; i < customers.size(); i++) {
            // Print all elements of List
            //System.out.println(customers.get(i));
            registrationPage.loadrUrl();
            registrationPage.fillForm(customers.get(i));
            registrationPage.submitForm();
        }
            registrationPage.verifyCustomer();
            //registrationPage.closing();
        }
  
    
}
