
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.Customer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoginPage extends Customer {
    private static final String FORM_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    private static final String Bank_ManagerLoginXpath = "//button[contains(text(),'Bank Manager Login')]";
    private static final String Add_customerXpath = "//button[contains(text(),'Add Customer')]";
    private static String First_NameXpath = "//input[@placeholder='First Name']";
    private static String Last_NameXpath = "//input[@placeholder='Last Name']";
    private static String PostcodeXpath = "//input[@placeholder='Post Code']";
    private static String SUBMIT_ID = "//button[@type='submit']";
    private static ChromeDriver driver;
    private static String fname = "Jackson";
    private static String Lname = "Christopher";

    public LoginPage() {
        driver = new ChromeDriver();
    }

    public void loadrUrl() {
        driver.get(FORM_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.findElement(By.xpath(Bank_ManagerLoginXpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath(Add_customerXpath)).click();
    }

    public static void fillForm(Customer customers) {
        driver.findElement(By.xpath(First_NameXpath)).sendKeys(customers.getFirstName());
        driver.findElement(By.xpath(Last_NameXpath)).sendKeys(customers.getLastName());
        driver.findElement(By.xpath(PostcodeXpath)).sendKeys(customers.getPostCode());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void submitForm() {
        driver.findElement(By.xpath(SUBMIT_ID)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.switchTo().alert().accept();
    }

    public static List<Customer> getExixtingCustomer() {
        List<Customer> customers = new ArrayList<>();
        driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
        WebElement table_Name = driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//table"));
        List<WebElement> rows_table = table_Name.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        for (int row = 1; row < rows_count; row++) {
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int columns_count = Columns_row.size();
            for (int column = 0; column < columns_count; column++) {
                String F_name = Columns_row.get(0).getText();
                String L_name = Columns_row.get(1).getText();
                String P_Code = Columns_row.get(2).getText();
                Customer cust = new Customer();
                cust.setFirstName(F_name);
                cust.setLastName(L_name);
                cust.setPostCode(P_Code);
                customers.add(cust);
            }
        }
        return customers;
    }

    public static void deleteCustomer(String fname, String Lname) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
        WebElement DelButton;
        DelButton = driver.findElement(By.xpath("//td[contains(text()," + fname + ")]/following::td[contains(text(),'"
                + Lname + "')]/following::td[3]//button"));
        System.out.println("successfully deleted " + fname + " and   " + Lname);
        DelButton.click();
    }

    public static List<Customer> getCustomerDetails() {
        List<Customer> customers = new ArrayList<>();
        Customer cust = new Customer();
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
            System.out.println(customers.get(i).getFirstName());
            System.out.println(customers.get(i).getLastName());
            System.out.println(customers.get(i).getPostCode());
        }
        return customers;

    }

    public static Set<Customer> verfiyCustomers(List<Customer> listOne, List<Customer> listTwo) {
        // List<Customer> result = new ArrayList<Customer>();
        Set result = new HashSet();

        for (Customer one : listOne) {
            for (Customer two : listTwo) {
                if (one.getFirstName().equals(two.getFirstName())
                        && one.getLastName().equals(two.getLastName())
                        && one.getPostCode().equals(two.getPostCode())) {

                    result.add(one);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LoginPage registrationPage = new LoginPage();
        
            registrationPage.loadrUrl();
           for(int i=0;i< getCustomerDetails().size();i++){
                fillForm(getCustomerDetails().get(i));
                submitForm();
           }
                      
            List<Customer> excList = getExixtingCustomer();
            List<Customer> customers = getCustomerDetails();
           Set<Customer> resultsSet =  verfiyCustomers(excList, customers) ;
           Iterator<Customer> it = resultsSet.iterator();
           while(it.hasNext())
           {
            System.out.println("customer added  "+it.next().getFirstName().);
           }
            deleteCustomer( fname, Lname);
            //driver.close();
        

        }

}
