package RegForm;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllValidInputs {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);

        //Navigate to Student Registration Form
        driver.get("https://demoqa.com/automation-practice-form");

        //Maximize the browser window
        driver.manage().window().maximize();

        //Input Name
        WebElement fname= driver.findElement(By.id("firstName"));
        fname.sendKeys("Udani");
        Thread.sleep(2000);

        WebElement lname= driver.findElement(By.id("lastName"));
        lname.sendKeys("Ingeetha");
        Thread.sleep(2000);

        //Input Email
        WebElement mail= driver.findElement(By.id("userEmail"));
        mail.sendKeys("udani@gmail.com");
        Thread.sleep(2000);
 
        //Select Gender
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("gender-radio-2")));
        Thread.sleep(2000);

        //Input Mobile Number
        WebElement mobNum= driver.findElement(By.id("userNumber"));
        mobNum.sendKeys("0773540927");
        Thread.sleep(2000);

        //Input DOB
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.click();
        dob.sendKeys(Keys.CONTROL + "a");  // Select all text
        dob.sendKeys("10 Feb 2025");
        dob.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //Input Subjects
        WebElement sub1 = driver.findElement(By.id("subjectsInput"));
        sub1.sendKeys("Maths");
        sub1.sendKeys(Keys.ENTER);
        sub1.sendKeys("Computer Science");
        sub1.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //Select Hobbies
//        driver.findElement(By.id("state")).click();
//        driver.findElement(By.xpath("//div[text()='NCR']")).click();
//       Thread.sleep(2000);

//        driver.findElement(By.id("city")).click();
//        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
//        Thread.sleep(2000);

        //Select Picture
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Homini\\Downloads\\testing image.jpg");
        Thread.sleep(2000);

        //Input Address
        WebElement address= driver.findElement(By.id("currentAddress"));
        address.sendKeys("402,1/2, Ranmuthugala, Kadawatha");
        Thread.sleep(2000);

        //Select State and City
        driver.findElement(By.id("state")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("city")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
        Thread.sleep(2000);

        //Click Submit Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        
        // Close the browser
        driver.quit();

        //*****Check the submission using modal*****
        boolean isSubmissinModalPresent = driver.findElements(By.id("example-modal-sizes-title-lg")).size() > 0;

        if (!isSubmissinModalPresent) {
            System.out.println("Form submission failed!");
        } else {
            System.out.println("Form submitted successfully!");
        }

    }
}
