import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class Q2 extends LoginPage {
    public void selectCustomer() {
        driver.get(LoginPage.FORM_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.findElement(By.xpath (CustomeroginXpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Select dropdown = new Select(driver.findElement(By.xpath ("//select[@name='userSelect']")));
		dropdown.selectByVisibleText("Hermoine Granger");
		driver.findElement(By.xpath( "//button[@type='submit']")).click();
        }
        public void SelectAccount() {
            Select dropdown2 = new Select(driver.findElement(By.xpath ("//select[@id='accountSelect']")));
            ///select[@id='accountSelect']/
            dropdown2.selectByVisibleText("1003");
          
        }
        public String AmountTransaction(int i, String Trans) {
            String Status = null;
            if (Trans.equalsIgnoreCase("Withdraw")) {
                WebElement balance = driver.findElement(By.xpath("//div[@class='center']/strong[2]"));
                int bal = Integer.parseInt(balance.getText());
                int AfterTrans = bal - i;
                WebElement withdraw = driver.findElement(By.xpath("//button[@ng-click='withdrawl()']"));
                withdraw.click();
                WebElement withdrawAmtInput = driver.findElement(By.xpath("//form[@ng-submit='withdrawl()']/div/input"));
                withdrawAmtInput.sendKeys(Integer.toString(i));
                WebElement WithdrawAmtsubmit = driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Withdraw')]"));
                WithdrawAmtsubmit.click();
                WebElement Afterbalance = driver.findElement(By.xpath("//div[@class='center']/strong[2]"));
                int Aftbal = Integer.parseInt(Afterbalance.getText());
                if (AfterTrans == Aftbal) {
                    System.out.println("Transaction Amount Processed Accurately");
                    Status= "Success";
                } else {
                    System.out.println("Kindly check the balance");
                    Status=  "Amount Failed";
                }
            }
            if (Trans.equalsIgnoreCase("Deposit")) {
                WebElement balance = driver.findElement(By.xpath("//div[@class='center']/strong[2]"));
                int bal = Integer.parseInt(balance.getText());
                int AfterTrans = bal + i;
                WebElement deposit = driver.findElement(By.xpath("//button[@ng-click='deposit()']"));
                deposit.click();
                WebElement DepositAmtInput = driver.findElement(By.xpath("//form[@ng-submit='deposit()']/div/input"));
                DepositAmtInput.sendKeys(Integer.toString(i));
                WebElement DepositAmtsubmit = driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Deposit')]"));
                DepositAmtsubmit.click();
                WebElement Afterbalance = driver.findElement(By.xpath("//div[@class='center']/strong[2]"));
                int Aftbal = Integer.parseInt(Afterbalance.getText());
                if (AfterTrans == Aftbal) {
                    System.out.println("Transaction Amount Processed Accurately" + AfterTrans + Aftbal);;
                    Status= "Success";
                } else {
                    System.out.println("Kindly check the balance" + AfterTrans + Aftbal);
                    Status= "Amount Failed";
                }
            }
            return Status;
            
        }

        public void performTransactions() {
            String status;
            status = AmountTransaction(50000, "Deposit");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            status = AmountTransaction(3000, "Withdraw");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            status = AmountTransaction(2000, "Withdraw");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            status = AmountTransaction(5000, "Deposit");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            status = AmountTransaction(10000, "Withdraw");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            status = AmountTransaction(15000, "Withdraw");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            status = AmountTransaction(1500, "Deposit");
            Assert.assertEquals(status, "Success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
public static void main(String[] args)
{
    Q2 q2= new Q2();
    q2.loadrUrl();
    q2.selectCustomer();
    q2.SelectAccount();
    q2.performTransactions();
}
}

